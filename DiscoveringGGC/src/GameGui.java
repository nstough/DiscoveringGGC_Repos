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

import java.util.Random;

// John was here

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
	
	//Instance of PuzzleEvents
	PuzzleEvents quests = new PuzzleEvents();
	
	//Score for the player.
	int score = 0;
	
	// player's current location.
	String location = "The Administration Building";
	
	//Creates a multiple booleans so the buttons know what they need to display
	boolean isQuestion = false;
	boolean isDirection = false;
	boolean isMap = false;
	
	//Create the Floor
	static FloorGenerator floor = new FloorGenerator();
	
	static TeacherGenerator teachs = new TeacherGenerator();
	
	//Know which room you are in
	int roomNum = 0;
	
	//question number which shows how many questions have been asked
	int questionNum = 0;
	
	//teacher number which shows the number of teachers that have been used
	int teacherNum = 0;
	
	//Just change as you go
	public String version = "0.5";
	
	//The text that is displayed on the buttons
	public String b1Text = "Observe";
	public String b2Text = "Talk";
	public String b3Text = "Map";
	public String b4Text = "Status";
	
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
		teachs.createTeacherList();
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
	  		if (!b5.getText().equalsIgnoreCase("inventory")) {
	  		  inventoryAction(1);
	  		} else if (isQuestion == true) {
	  		  answerAction(1);
	  		  isQuestion = false;
	  		  questionNum++;
	  		  defaultAction();
	  		} else if (isMap == true) {
	  		  isMap = false;
	  		  isDirection = true;
	  		  location = b1.getText();
	  		} else if (isDirection == true) {
	  		  roomNum = roomNum + 1;
	  		  isDirection = false;
	  		  observeAction();
	  		  defaultAction();
	  		} else {
	  			// looks around the room and prints out what is in the room (i.e. sees a teacher or student)
	  			observeAction();
	  			System.out.println(roomNum);
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
	  		if (!b5.getText().equalsIgnoreCase("inventory")) {
		  		  inventoryAction(2);
		  		} else if (isQuestion == true) {
		  			answerAction(2);
		  			isQuestion = false;
		  			questionNum++;
		  			defaultAction();
		  		} else if (isMap == true) {
		  			isMap = false;
		  			isDirection = true;
		  			location = b2.getText();
		  		} else if (isDirection == true) {
		  			roomNum = roomNum + 2;
		  			isDirection = false;
		  			observeAction();
		  			defaultAction();
		  		} else {
		  		    // if someone is in the room, talks to the person
		  			if (floor.getList().get(roomNum).getHasCleared()) {
		  			  ta.appendText("Nobody is in this room.\n");
		  			} else if (floor.getList().get(roomNum).puzzle != -1 && floor.getList().get(roomNum).teacher > -1) {
		  			  switch (floor.getList().get(roomNum).puzzle) {
		  			    case  0: quests.helpEvent01();
		  			    		 break;
		  			    case  1: quests.helpEvent02();
 			    		 		 break;
		  			    case  2: quests.helpEvent03();
 			    		 		 break; 
		  			    case  3: quests.helpEvent04();
 			    		 		 break;
		  			    case  4: quests.helpEvent05();
 			    		 		 break;
		  			    case  5: quests.helpEvent06();
 			    		 		 break;
		  			    case  6: quests.helpEvent07();
		  			    		 break;
		  			    case  7: quests.helpEvent08();
		  			    		 break;
		  			    case  8: quests.helpEvent09();
		  			    		 break;
		  			    case  9: quests.helpEvent10();
 			    				 break;
		  		        default: break;
		  			  }
		  			} else if (floor.getList().get(roomNum).teacher != -1 && floor.getList().get(roomNum).puzzle == -1) {
		  			  isQuestion = true;
		  			  System.out.println("Question activated");
		  			  ta.appendText(teachs.getList().get(roomNum).getTeacherName() + ": " +
		  			          teachs.getList().get(roomNum).getDialogue() + "\n");
		  			  questionAction();
		  			} else {
		  			  ta.appendText("You do not know who is in this room.\n");
		  			}
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
	  		if (!b5.getText().equalsIgnoreCase("inventory")) {
		  		  inventoryAction(3);
		  		} else if (isQuestion == true) {
		  			answerAction(3);
		  			isQuestion = false;
		  			questionNum++;
		  			defaultAction();
		  		}	else if (isMap == true) {
		  			isMap = false;
		  			isDirection = true;
		  			location = floor.getList().get(roomNum).getRoomName();
		  		} else if (isDirection == true) {
		  			isDirection = false;
		  			roomNum = 0;
		  			observeAction();
		  			defaultAction();
		  		} else {
		  			// open the map and travel to different parts of the campus
		  			isDirection = true;
		  			mapAction();
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
	  		if (!b5.getText().equalsIgnoreCase("inventory")) {
		  		  inventoryAction(4);
		  		} else if (isQuestion == true) {
		  			answerAction(4);
		  			isQuestion = false;
		  			questionNum++;
		  			defaultAction();
		  		} else if (isMap == true) {  
		  			isMap = false;
		  			isDirection = true;
		  			location = floor.getList().get(roomNum).getRoomName();
		  		} else if (isDirection == true) {
		  			isDirection = false;
		  			defaultAction();
		  		} else {
		  		  // displays the player's current score and the likes
		  		  statusAction();
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
	  		if(b5.getText().equalsIgnoreCase("inventory")){
	  			b1.setText(user.getInventory().get(0).getItemName());
	  			b2.setText(user.getInventory().get(1).getItemName());
	  			b3.setText(user.getInventory().get(2).getItemName());
	  			b4.setText(user.getInventory().get(3).getItemName());
	  			b5.setText("Back");
	  		}
	  		else {
	  			defaultAction();
	  		}
	  	}
	  }
	
	/* 
	 * Method designed to perform actions based on the player's inventory and active quests.
	 */
	public void inventoryAction(int buttonNumber) {
	  boolean act = false;
	  boolean[] questActive = new boolean[quests.EVENT_SIZE];
	  
	  for (int i = 0; i < quests.events.size(); i++) {
		if (quests.events.get(i).getIsActive()) {
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
		  case  1: quests.endEvent01();
		           break;
		  case  2: quests.endEvent02();
		           break;
		  case  3: quests.endEvent03();
		           break;
		  case  4: quests.endEvent04();
		           break;
		  case  5: quests.endEvent05();
		           break;
		  case  6: quests.endEvent06();
		           break;
		  case  7: quests.endEvent07();
		           break;
		  case  8: quests.endEvent08();
			       break;
		  case  9: quests.endEvent09();
		           break;
		  case 10: quests.endEvent10();
		           break;
	      default: break;
		}
	  } else {
	    ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
	  }
	}
	
	// Method to ask a question and change the buttons to the according answers.
	public void questionAction() {
	  if (!floor.getList().get(roomNum).getHasCleared()) {
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
	  } else {
		  ta.appendText("You have answered course already.");
	  }
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
		  if (!teachs.getList().get(roomNum).getRewarded() && teachs.getList().get(roomNum).getReward() > 0) {
			ta.appendText(teachs.getList().get(roomNum).getTeacherName() +
					": \"Here's a little something else for your good work.\n");
			user.addItem(teachs.getList().get(roomNum).getReward());
			teachs.getList().get(roomNum).setRewarded(true);
			floor.getList().get(roomNum).setHasCleared(true);
		  }
		}
	  }
	}
	
	// Method to induct an action of the map is being used.
	public void mapAction() {
	  if (roomNum <= 12) {
	  ta.appendText("You are currently at "+ location + ".\n");
	  b1.setText(floor.getList().get(roomNum+1).getRoomName());
	  b2.setText(floor.getList().get(roomNum+2).getRoomName());
	  b3.setText(floor.getList().get(0).getRoomName());
	  b4.setText("Back");
	  }
	}
	
	// Method to induct an action when "Observe" is clicked.
	public void observeAction() {
	  String temp = floor.getList().get(roomNum).getRoomDescription();
	  int index = 0;
	  
	  Random rand = new Random();
	  
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
	  
	  if (floor.getList().get(roomNum).getHasCleared()) {
		ta.appendText("There is nothing of interest in this room.\n");
	  } else {
		if (floor.getList().get(roomNum).getHasEntered() && !floor.getList().get(roomNum).getHasCleared()) {
		  if (floor.getList().get(roomNum).puzzle == -1) {
			ta.appendText("A teacher appears to be in this room.\n");
		  } else {
			ta.appendText("A student appears to be in this room.\n");
		  }
		} else if (!floor.getList().get(roomNum).getHasEntered()) {
		  if (rand.nextInt(2) == 0 && rand.nextInt(100) > 49) {
			while (floor.getList().get(roomNum).puzzle == -1) {
			  int hold = rand.nextInt(10);
			  if (!quests.events.get(hold).getIsActive() && !quests.events.get(hold).getIsCompleted() &&
			    quests.events.get(hold).getIsAvailable()) {
			    floor.getList().get(roomNum).puzzle = hold;
			    quests.events.get(hold).setIsActive(true);
			    quests.events.get(hold).setIsAvailable(false);
			  }
			}
			ta.appendText("A student appears to be in this room.\n");
		  } else if (rand.nextInt(100) > 49) {
			while (floor.getList().get(roomNum).teacher == -1) {
			  if (teachs.getList().get(teacherNum).room == -1) {
				floor.getList().get(roomNum).teacher = teacherNum;
				teachs.getList().get(teacherNum).room = roomNum;
				teacherNum++;
			  }
			}
		    ta.appendText("A teacher appears to be in this room.\n");
		  }
		} else {
		  ta.appendText("There is nothing of interest in this room.\n");
		  floor.getList().get(roomNum).setHasCleared(true);
	    }
	  }
	}
	
	//Method that displays the player's status
	public void statusAction() {
	  ta.appendText("Total Credits Earned: " + score + "\n");
	  ta.appendText("Total Number of Bonus Credits: " + user.getBonus() + "\n");
	  ta.appendText("\nPlayer's Current Location: " + location + "\n\n");
	}
	
	// Method to set the main buttons to their default statements.
	public void defaultAction() {
	  b1.setText(b1Text);
	  b2.setText(b2Text);
	  b3.setText(b3Text);
	  b4.setText(b4Text);
	  b5.setText(b5Text);
	  b6.setText(b6Text);
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
