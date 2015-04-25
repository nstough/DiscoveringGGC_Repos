import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Logic so that the buttons say the appropriate action and do the appropriate action at all times
// John was here

/* To John:
 *  Based on the names of the buttons, I created methods to be called that will adjust the text of each button
 *  when they're preferred actions are set (i.e. hitting "Map" will display the player's current location and
 *  the 4 buttons will change to where they can go). List of all the additions/changes are below:
 *  
 *  - Added a mapAction method to perform the action needed when the Map button is pressed (like I did with
 *      the Talk button for questions).
 *  - Remove your "buttonClicked" variables. They served no purpose anymore.
 *  - Remove the "isPuzzle" and "isAnswering" variable. I see no purpose for either of them.
 *  - Adjusted the questions such that the question is word-wrapped in the text area and the buttons are changed
 *      to A, B, C, and D, rather than their proper text.
 *  
 *  What you need to do (at minimum):
 *  
 *  - Find a way to place 3 different items into random locations across the map (ID 1, 6, and 10)
 *      ("Michael's Binder", "Bottle of Water", and "Carl's Phone"). All other items are retrieved from
 *      the puzzles.
 *  - Make an observe method (similar to my questionAction and mapAction) that will display the contents of a room.
 *  - Adjust the "Talk" feature such that it can sometimes talk to other students instead of it always being a teacher.
 */

/**Class: GameGui
 * @author Nick Stough
 * @version 1.0
 * Course : Soft Dev
 * Written: Apr 5, 2015
 *
 * This class builds a Gui for the game and will accept input from the Game class
 *
 * Purpose: The purpose is to give the user a graphical interface for the game
 * 
 * Edited April 21, 2015 (9:34 PM) by Tim Nguyen
 * - Adjusted inventory buttons to properly display inventory.
 * - Added a method to provide inventory actions
 * - Added a "user" Player-Object.
 */

/**
 * @author Nick
 *
 */
public class GameGui extends Application implements Runnable
{
	//Instance of Game
	public Game myGame = new Game();
	
	//Instance of Player
	private Player user = new Player();
	
	//Creates a question bank for the game
	QuestionBank bank = new QuestionBank();
	
	//Score for the player.
	int score = 0;
	
	// player's current location.
	String location = "Current Location";
	
	//Creates a multiple booleans so the buttons know what they need to display
	boolean isQuestion = false;
	boolean isDirection = false;
	boolean isMap = false;
	
	String next = "Need to make something that tells the buttons what they need to say";
	
	//Create the Floor
	static FloorGenerator floor = new FloorGenerator();
	
	//Know which room you are in
	int roomNum = 0;
	
	//question number which shows how many questions have been asked
	int questionNum = 0;
	
	//Just change as you go
	public String version = "0.5";
	
	//The text that is displayed on the buttons
	public String b1Text = "Observe";
	public String b2Text = "Interact";
	public String b3Text = "Talk";
	public String b4Text = "Map";
	
	//Text displayed on the right hand buttons
	public String b5Text = "Inventory";
	public String b6Text = "Menu";
	
	//Text displayed in TextArea once button is pressed
	public String b1Results = myGame.getB1Results();
	public String b2Results = myGame.getB2Results();
	public String b3Results = myGame.getB3Results();
	public String b4Results = myGame.getB4Results();
	
	//Buttons
	Button b1 = new Button();
	Button b2 = new Button();
	Button b3 = new Button();
	Button b4 = new Button();
	Button b5 = new Button();
	Button b6 = new Button();
	
	//TextArea
	static TextArea ta = new TextArea();
	

	/**
	 * Method: Start
	 * Activates the gui and its elements
	 */
	public void start(Stage primaryStage)
	{	
		//Event handlers for the buttons
		b1Action handler1 = new b1Action();
		b2Action handler2 = new b2Action();
		b3Action handler3 = new b3Action();
		b4Action handler4 = new b4Action();
		b5Action handler5 = new b5Action();
		Menu handler6 = new Menu();
		
		//Layout of the TextArea
		ta.setPrefWidth(480);
		ta.setPrefHeight(270);
		ta.setLayoutX(10);
		ta.setLayoutY(10);		
		ta.setEditable(false);
		
		//Rectangles in place of lines seperating the buttons
		Rectangle lineHoriz = new Rectangle();
			lineHoriz.setLayoutX(250);
			lineHoriz.setLayoutY(290);
			lineHoriz.setStroke(Color.DARKGRAY);
			lineHoriz.setScaleX(500);
			lineHoriz.setScaleY(2);
			
		Rectangle lineVert = new Rectangle();
			lineVert.setLayoutX(325);
			lineVert.setLayoutY(365);
			lineVert.setStroke(Color.DARKGRAY);
			lineVert.setScaleX(2);
			lineVert.setScaleY(150);
			
			//Lots of button layout tweaks
			b1.setPrefWidth(145);
			b1.setPrefHeight(35);
			b1.setLayoutX(15);
			b1.setLayoutY(300);
			b1.setOnAction(handler1);
		
			b2.setPrefWidth(145);
			b2.setPrefHeight(35);
			b2.setLayoutX(170);
			b2.setLayoutY(300);
			b2.setOnAction(handler2);

			b3.setPrefWidth(145);
			b3.setPrefHeight(35);
			b3.setLayoutX(15);
			b3.setLayoutY(350);
			b3.setOnAction(handler3);
			
			b4.setPrefWidth(145);
			b4.setPrefHeight(35);
			b4.setLayoutX(170);
			b4.setLayoutY(350);
			b4.setOnAction(handler4);
		
			b5.setPrefWidth(145);
			b5.setPrefHeight(35);
			b5.setLayoutX(335);
			b5.setLayoutY(300);
			b5.setOnAction(handler5);
			
			b6.setPrefWidth(145);
			b6.setPrefHeight(35);
			b6.setLayoutX(335);
			b6.setLayoutY(350);
			b6.setOnAction(handler6);
		
		//Setting the text for the buttons
		b1.setText(b1Text);
		b2.setText(b2Text);
		b3.setText(b3Text);
		b4.setText(b4Text);
		b5.setText(b5Text);
		b6.setText(b6Text);
			
		//Creates panes and adds the Gui elements
		Pane pane = new Pane();
		pane.getChildren().add(ta);
	    pane.getChildren().add(b1);
	    pane.getChildren().add(b2);
	    pane.getChildren().add(b3);
	    pane.getChildren().add(b4);
	    pane.getChildren().add(b5);
	    pane.getChildren().add(b6);
	    pane.getChildren().add(lineHoriz);
	    pane.getChildren().add(lineVert);

	    //Builds a scene, names it, edits the layout, and shows it
		Scene scene = new Scene(pane, 500, 400);
		primaryStage.setTitle("Discovering GGC | Version " + version); 
		primaryStage.setScene(scene); 
		primaryStage.setResizable(false);
		primaryStage.show(); 
		
		//Starting placeholder text
		ta.appendText("You walk into an empty room\n");
	}

	public static void main(String[] args)
	{		
		//Create the Floor
		//FloorGenerator floor = new FloorGenerator();
		floor.layout();
		//Starts the gui
		launch(args);
	}
	
	/**
	 * 
	 * @author Nick
	 * Handles what happens when the first button is pressed
	 */
	  class b1Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{
	  		if (!b5Text.equalsIgnoreCase("inventory")) {
	  		  inventoryAction(1);
	  		} else if (isQuestion == true) {
	  		  answerAction(1);
	  		  isQuestion = false;
	  		  questionNum++;
	  		  defaultAction();
	  		} else if (isMap == true) {
	  		  isMap = false;
	  		  location = "A Building";
	  		  defaultAction();
	  		} else if (isDirection == true) {
	  		  ta.appendText(floor.getList().get(roomNum).getRoomDescription());
	  		  System.out.println("Direction activated");
	  		  isDirection = false;
	  		  defaultAction();
	  		} else {
	  			// looks around the room and prints out what is in the room (i.e. sees a teacher or an item)
	  		}
	  	}
	  }
	  
	  /**
	   * 
	   * @author Nick
	   * Handles what happens when the second button is pressed
	   */
	  class b2Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{
	  		if (!b5Text.equalsIgnoreCase("inventory")) {
		  		  inventoryAction(2);
		  		} else if (isQuestion == true) {
		  			answerAction(2);
		  			isQuestion = false;
		  			questionNum++;
		  			defaultAction();
		  		} else if (isMap == true) {
		  			isMap = false;
		  			location = "B Building";
		  			defaultAction();
		  		} else if (isDirection == true) {
		  			ta.appendText(floor.getList().get(roomNum).getRoomDescription());
		  			System.out.println("Direction activated");
		  			isDirection = false;
		  			defaultAction();
		  		} else {
		  			// interact with potential items in the room
		  		}
	  	}
	  }
	  
	  /**
	   * 
	   * @author Nick
	   * Handles what happens when the third button is pressed
	   */
	  class b3Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{
	  		if (!b5Text.equalsIgnoreCase("inventory")) {
		  		  inventoryAction(3);
		  		} else if (isQuestion == true) {
		  			answerAction(3);
		  			isQuestion = false;
		  			questionNum++;
		  			defaultAction();
		  		} else if (isMap == true) {
		  			isMap = false;
		  			location = "C Building";
		  			defaultAction();
		  		} else if (isDirection == true) {
		  			ta.appendText(floor.getList().get(roomNum).getRoomDescription());
		  			System.out.println("Direction activated");
		  			isDirection = false;
		  			defaultAction();
		  		} else {
		  			// if someone is in the room, talks to the person
		  			isQuestion = true;
		  			System.out.println("Question activated");
		  			questionAction();
		  		}
	  	}
	  }
	  
	  /**
	   * 
	   * @author Nick
	   * Handles what happens when the fourth button is pressed
	   */
	  class b4Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{
	  		if (!b5Text.equalsIgnoreCase("inventory")) {
		  		  inventoryAction(4);
		  		} else if (isQuestion == true) {
		  			answerAction(4);
		  			isQuestion = false;
		  			questionNum++;
		  			defaultAction();
		  		} else if (isMap == true) {
		  			isMap = false;
		  			location = "D Building";
		  			defaultAction();
		  		} else if (isDirection == true) {
		  			ta.appendText(floor.getList().get(roomNum).getRoomDescription());
		  			System.out.println("Direction activated");
		  			isDirection = false;
		  			defaultAction();
		  		} else {
		  			// open the map and travel to different parts of the campus
		  			isMap = true;
		  			mapAction();
		  		}
	  	}
	  }
	  
	  /**
	   * 
	   * @author Nick
	   * Handles what happens when the inventory button is pressed
	   */
	  class b5Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{
	  		if(b5Text.equalsIgnoreCase("inventory")){
	  			b5Text = "Back";
	  			
	  			b1.setText(user.getInventory().get(0).getItemName());
	  			b2.setText(user.getInventory().get(1).getItemName());
	  			b3.setText(user.getInventory().get(2).getItemName());
	  			b4.setText(user.getInventory().get(3).getItemName());
	  			b5.setText(b5Text);
	  			b6.setText(b6Text);
	  		}
	  		else if(b5Text.equalsIgnoreCase("back")){
	  			b5Text = "Inventory";
	 			
	  			b1.setText(b1Text);
	  			b2.setText(b2Text);
	  			b3.setText(b3Text);
	  			b4.setText(b4Text);
	  			b5.setText(b5Text);
	  			b6.setText(b6Text);
	  		}
	  	}
	  }
	
	/* 
	 * Method designed to perform actions based on the player's inventory and active quests.
	 */
	public void inventoryAction(int buttonNumber) {
	  boolean act = false;
	  boolean[] questActive = new boolean[PuzzleEvents.EVENT_SIZE];
	  
	  for (int i = 0; i < PuzzleEvents.events.size(); i++) {
		if (PuzzleEvents.events.get(i).getIsActive()) {
		  questActive[i] = true;
		} else {
		  questActive[i] = false;
		}
	  }
	  
	  if (questActive[user.getInventory().get(buttonNumber - 1).getQuestID()]) {
		act = true;
	  }
	  
	  if (act) {
		switch(user.getInventory().get(buttonNumber - 1).getQuestID()) {
		  case  1: PuzzleEvents.endEvent01();
		           break;
		  case  2: PuzzleEvents.endEvent02();
		           break;
		  case  3: PuzzleEvents.endEvent03();
		           break;
		  case  4: PuzzleEvents.endEvent04();
		           break;
		  case  5: PuzzleEvents.endEvent05();
		           break;
		  case  6: PuzzleEvents.endEvent06();
		           break;
		  case  7: PuzzleEvents.endEvent07();
		           break;
		  case  8: PuzzleEvents.endEvent08();
			       break;
		  case  9: PuzzleEvents.endEvent09();
		           break;
		  case 10: PuzzleEvents.endEvent10();
		           break;
	      default: break;
		}
	  } else {
	    ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
	  }
	}
	
	// Method to ask a question and change the buttons to the according answers.
	public void questionAction() {
	  String temp = bank.getList()[questionNum].getQuery();
	  int index = 0;
	  
	  while (temp.length() > 0) {
		if (temp.length() < 80) {
		  ta.appendText(temp + "\n");
		  temp = "";
		} else {
		  index = temp.lastIndexOf(" ", 80);
		  ta.appendText(temp.substring(0, index) + "\n");
		  temp = temp.substring(index + 1);
		}
	  }
	  
	  ta.appendText("A) " + bank.getList()[questionNum].getAns1() + "\nB) " +
	          bank.getList()[questionNum].getAns2() + "\nC) " + bank.getList()[questionNum].getAns3() +
			  "\nD) " + bank.getList()[questionNum].getAns4() + "\n");
	  b1.setText("A");
	  b2.setText("B");
	  b3.setText("C");
	  b4.setText("D");
	}
	
	// Method to induct an action if a question is being asked.
	public void answerAction(int buttonNumber) {
	  int guess = 0;
	  
	  if (isQuestion) {
		switch (buttonNumber) {
		  case  1: guess = 1;
		           break;
		  case  2: guess = 2;
		           break;
		  case  3: guess = 3;
		           break;
		  case  4: guess = 4;
		           break;
		  default: break;
		}
		
		ta.appendText(bank.isCorrectString(bank.getList()[questionNum], guess, user.getBonus()) + "\n");
		
		if (bank.isCorrect(bank.getList()[questionNum], guess, user.getBonus())) {
		  score++;
		  if (bank.usedHelp(bank.getList()[questionNum], guess, user.getBonus())) {
			user.setBonus(user.getBonus() - 1);
		  }
		}
	  }
	}
	
	// Method to induct an action of the map is being used.
	public void mapAction() {
	  
	  ta.appendText(location + "\n");
	  b1.setText("A Building");
	  b2.setText("B Building");
	  b3.setText("C Building");
	  b4.setText("D Building");
	}
	
	// Method to set the main buttons to their default statements.
	public void defaultAction() {
	  b1.setText(b1Text);
	  b2.setText(b2Text);
	  b3.setText(b3Text);
	  b4.setText(b4Text);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		launch();
		
	}
	
	
}
