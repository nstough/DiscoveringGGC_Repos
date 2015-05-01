import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
	private boolean isLoadedGame = false;
	
	//Instance of Game
	public Game myGame = new Game();
	
	//Instance of Player
	static Player user = new Player();
	
	//Creates a question bank for the game
	QuestionBank bank = new QuestionBank();
	
	//Instance of PuzzleEvents
	PuzzleEvents quests = new PuzzleEvents();
	
	//Score for the player.
	int score = 0;
	
	//Creates a multiple booleans so the buttons know what they need to display
	boolean isQuestion = false;
	boolean isDirection = false;
	boolean isEnd = false;
	
	//Create the Floor
	static FloorGenerator floor = new FloorGenerator();
	
	static TeacherGenerator teachs = new TeacherGenerator();
	
	//Know which room you are in
	int roomNum = 0;
	
	//current teacher in use
	int teacherNum = 0;
	
	//current quesiton in use
	int questionNum = 0;

	// player's current location.
	String location = floor.getList().get(roomNum).getRoomName();
	
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
		ta.appendText("Welcome to Discovering GGC!!!\n");
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
	  		if (b5.getText().equalsIgnoreCase("back")) {
	  		    inventoryAction(1);
	  		} else if (isQuestion) {
		        defaultAction();
	  		    answerAction(1);
	  		    isQuestion = false;
	  		} else if (isDirection) {
	  		  if (roomNum < floor.getList().size() - 1) {
	  			roomNum = roomNum + 1;
		  		isDirection = false;
		  		location = b1.getText();
		  		ta.appendText("You have travelled to " + location + ".\n=====\n");
		  		defaultAction();
	  		  }
	  		} else if (isEnd) {
	  			endGame();
	  			System.exit(0);
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
	  		if (b5.getText().equalsIgnoreCase("back")) {
		  		  inventoryAction(2);
		  		} else if (isQuestion) {
		  			defaultAction();
		  			answerAction(2);
		  			isQuestion = false;
		  		} else if (isDirection) {
		  			if (roomNum < floor.getList().size() - 2) {
		  			  roomNum = roomNum + 2;
			  		  isDirection = false;
			  		  location = b2.getText();
				  	  ta.appendText("You have travelled to " + location + ".\n=====\n");
			  		  defaultAction();
		  			}
		  		} else if (isEnd) {
		  			endGame();
		  			System.exit(0);
		  		} else {
		  		    // if someone is in the room, talks to the person
		  			if (floor.getList().get(roomNum).getHasCleared()) {
		  			  ta.appendText("Nobody is in this room.\n");
		  			} else if (floor.getList().get(roomNum).puzzle != -1) {
		  			  switch (floor.getList().get(roomNum).puzzle) {
		  			    case  1: quests.events.get(0).setIsAvailable(true);
		  			    	     quests.helpEvent01();
		  			    		 break;
		  			    case  2: quests.events.get(1).setIsAvailable(true);
		  			             quests.helpEvent02();
 			    		 		 break;
		  			    case  3: quests.events.get(2).setIsAvailable(true);
		  			             quests.helpEvent03();
 			    		 		 break; 
		  			    case  4: quests.events.get(3).setIsAvailable(true);
		  			             quests.helpEvent04();
 			    		 		 break;
		  			    case  5: quests.events.get(4).setIsAvailable(true);
		  			             quests.helpEvent05();
 			    		 		 break;
		  			    case  6: quests.events.get(5).setIsAvailable(true);
		  			             quests.helpEvent06();
 			    		 		 break;
		  			    case  7: quests.events.get(6).setIsAvailable(true);
		  			             quests.helpEvent07();
		  			    		 break;
		  			    case  8: quests.events.get(7).setIsAvailable(true);
		  			             quests.helpEvent08();
		  			    		 break;
		  			    case  9: quests.events.get(8).setIsAvailable(true);
		  			             quests.helpEvent09();
		  			    		 break;
		  			    case 10: quests.events.get(9).setIsAvailable(true);
		  			    	     quests.helpEvent10();
 			    				 break;
		  		        default: ta.appendText("Student Print Error.\n");
		  		        	     break;
		  			  }
		  			} else if (floor.getList().get(roomNum).teacher != -1 && floor.getList().get(roomNum).puzzle == -1) {
		  			  isQuestion = true;
		  			  System.out.println("Question activated");
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
	  		if (b5.getText().equalsIgnoreCase("back")) {
		  		  inventoryAction(3);
		  		} else if (isQuestion) {
		  			defaultAction();
		  			answerAction(3);
		  			isQuestion = false;
		  		} else if (isDirection) {
		  			isDirection = false;
		  			roomNum = 0;
		  			location = b3.getText();
			  		ta.appendText("You have travelled to " + location + ".\n=====\n");
		  			defaultAction();
		  		} else if (isEnd) {
		  		    endGame();
		  		    System.exit(0);
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
	  		if (b5.getText().equalsIgnoreCase("back")) {
		  		  inventoryAction(4);
		  		} else if (isQuestion) {
		  			defaultAction();
		  			answerAction(4);
		  			isQuestion = false;
		  		} else if (isDirection) {
		  			isDirection = false;
		  			defaultAction();
		  		} else if (isEnd) {
		  			endGame();
		  			System.exit(0);
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
	  		if (!isQuestion) {
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
	  
	  if (user.getInventory().get(buttonNumber - 1).getID() != 0) {
		if (questActive[user.getInventory().get(buttonNumber - 1).getQuestID() - 1]) {
		  act = true;
		}
	  }
	  
	  if (act) {
		switch(user.getInventory().get(buttonNumber - 1).getQuestID()) {
		  case  1: if (floor.getList().get(roomNum).puzzle == 1) {
			         quests.endEvent01();
		           } else {
		        	   ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
		           }
		           break;
		  case  2: if (floor.getList().get(roomNum).puzzle == 2) {
			         quests.endEvent02();
		           } else {
		        	   ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
		           }
		           break;
		  case  3: if (floor.getList().get(roomNum).puzzle == 3) {
			         quests.endEvent03();
		           } else {
		        	   ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
		           }
		           break;
		  case  4: if (floor.getList().get(roomNum).puzzle == 4) {
			         quests.endEvent04();
		           } else {
		        	   ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
		           }
		           break;
		  case  5: if (floor.getList().get(roomNum).puzzle == 5) {
			         quests.endEvent05();
		           } else {
		        	   ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
		           }
		           break;
		  case  6: if (floor.getList().get(roomNum).puzzle == 6) {
			         quests.endEvent06();
		           } else {
		        	   ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
		           }
		           break;
		  case  7: if (floor.getList().get(roomNum).puzzle == 7) {
			         quests.endEvent07();
		           } else {
		        	   ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
		           }
		           break;
		  case  8: if (floor.getList().get(roomNum).puzzle == 8) {
			         quests.endEvent08();
		           } else {
		        	   ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
		           }
			       break;
		  case  9: if (floor.getList().get(roomNum).puzzle == 9) {
			         quests.endEvent09();
		           } else {
		        	   ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
		           }
		           break;
		  case 10: if (floor.getList().get(roomNum).puzzle == 10) {
			         quests.endEvent10();
		           } else {
		        	   ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
		           }
		           break;
	      default: break;
		}
		floor.getList().get(roomNum).setHasCleared(true);
	  } else {
	    ta.appendText(user.getInventory().get(buttonNumber - 1).getItemName() + "\n");
	  }
	  defaultAction();
	}
	
	// Method to ask a question and change the buttons to the according answers.
	public void questionAction() {
	  Random rand = new Random();
	  
	  if (roomNum == floor.getList().size() - 1) {
		  teacherNum = 8;
	  } else {
	      teacherNum = rand.nextInt(8);
	  }
	  
	  ta.appendText(teachs.getList().get(teacherNum).getTeacherName() + ": " +
	          teachs.getList().get(teacherNum).getDialogue() + "\n=====\n");
	  
	  do {
		questionNum = rand.nextInt(bank.getList().length);
	  } while (bank.getList()[questionNum].getIsUsed());
	  
	  if (!floor.getList().get(roomNum).getHasCleared()) {
		  wrapText(bank.getList()[questionNum].getQuery());
		  
		  ta.appendText("A) " + bank.getList()[questionNum].getAns1() + "\nB) " +
		          bank.getList()[questionNum].getAns2() + "\nC) " + bank.getList()[questionNum].getAns3() +
				  "\nD) " + bank.getList()[questionNum].getAns4() + "\n");
		  b1.setText("A");
		  b2.setText("B");
		  b3.setText("C");
		  b4.setText("D");
		  
		  bank.getList()[questionNum].setIsUsed(true);
	  } else {
		  ta.appendText("You have answered this course already.\n=====\n");
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
		
		ta.appendText(bank.isCorrectString(bank.getList()[questionNum], guess, user.getBonus()) +
				"\n=====\n");
		
		if (bank.isCorrect(bank.getList()[questionNum], guess, user.getBonus())) {
		  score++;
		  if (bank.usedHelp(bank.getList()[questionNum], guess, user.getBonus())) {
			user.setBonus(user.getBonus() - 1);
		  }
		  if (!teachs.getList().get(teacherNum).getRewarded() && teachs.getList().get(teacherNum).getReward() > 0) {
			ta.appendText(teachs.getList().get(teacherNum).getTeacherName() +
					": \"Here's a little something else for your good work.\"\n=====\n");
			user.addItem(teachs.getList().get(teacherNum).getReward());
			teachs.getList().get(teacherNum).setRewarded(true);
		  }
		}
		floor.getList().get(roomNum).setHasCleared(true);
	  }
	  
	  if (roomNum == floor.getList().size() - 1) {
		ta.appendText("You have completed \"Discovering GGC!\"\n");
		ta.appendText("Credits Earned: " + (score + user.getBonus()) + "\n");
		
		String result = "";
		int rating = -1;
		
		if ((score + user.getBonus()) <= 3) {
		  rating = 0; // failure
		} else if ((score + user.getBonus()) <= 5) {
	      rating = 1; // diploma
		} else if ((score + user.getBonus()) <= 7) {
		  rating = 2; // degree
		} else if ((score + user.getBonus()) <= 9) {
		  rating = 3; // masters
		} else if ((score + user.getBonus()) > 9) {
		  rating = 4; // doctorates
		} else {
		  rating = 5; // error?
		}
		
		switch (rating) {
		  case  0: result = "You barely passed with minimal scoring.";
		           break;
		  case  1: result = "You have passed and earned your Diploma. Congratulations!";
		           break;
		  case  2: result = "You have passed and earned your Degree. Congratulations!";
		           break;
		  case  3: result = "You have passed and earned your Masters. Congratulations!";
		           break;
		  case  4: result = "You have passed and earned your Doctorates. Congratulations!";
		           break;
		  default: break;
		}
		
		wrapText(result);
		endGame();
	  }
	}
	
	// Method to induct an action of the map is being used.
	public void mapAction() {
	  ta.appendText("You are currently at " + location + ".\n=====\n");
	  
	  b3.setText(floor.getList().get(0).getRoomName());
	  b4.setText("Back");
	  
	  if (roomNum >= floor.getList().size() - 2) {
		b2.setText("");
		if (roomNum == floor.getList().size() - 1) {
		  b1.setText("");
		} else {
		  b1.setText(floor.getList().get(roomNum + 1).getRoomName());
		}
	  } else {
		b1.setText(floor.getList().get(roomNum + 1).getRoomName());
		b2.setText(floor.getList().get(roomNum + 2).getRoomName());
	  }
	}
	
	// Method to induct an action when "Observe" is clicked.
	public void observeAction() {
	  Random rand = new Random();
	  
	  wrapText(floor.getList().get(roomNum).getRoomDescription());
	  
	  if (floor.getList().get(roomNum).getHasCleared()) {
		ta.appendText("There is nothing of interest in this room.\n=====\n");
	  } else {
		if (floor.getList().get(roomNum).getHasEntered()) {
		  if (roomNum == floor.getList().size() - 1){
			  ta.appendText("The president of GGC is in this room.\n=====\n");
		  } else if (floor.getList().get(roomNum).puzzle == -1) {
			ta.appendText("A teacher appears to be in this room.\n=====\n");
		  } else {
			ta.appendText("A student appears to be in this room.\n=====\n");
		  }
		} else {
		  if (roomNum == floor.getList().size() - 1) {
			  floor.getList().get(roomNum).teacher = 8;
			  ta.appendText("The president of GGC is in this room.\n=====\n");
		  } else {
			  switch (rand.nextInt(2)) {
			    case  0: floor.getList().get(roomNum).teacher = rand.nextInt(8);
			             ta.appendText("A teacher appears to be in this room.\n=====\n");
			             break;
			    case  1: do {
			    	       floor.getList().get(roomNum).puzzle = rand.nextInt(10) + 1;
			             } while (quests.events.get(floor.getList().get(roomNum).puzzle - 1).getIsAvailable());
			             ta.appendText("A student appears to be in this room.\n=====\n");
			             break;
			    default: break;
		      }
		  }
		  
		  floor.getList().get(roomNum).setHasEntered(true);
		}
	  }
	}
	
	//Method that displays the player's status
	public void statusAction() {
	  ta.appendText("Total Credits Earned: " + score + "\n");
	  ta.appendText("Total Number of Bonus Credits: " + user.getBonus() + "\n");
	  ta.appendText("\nPlayer's Current Location: " + location + "\n=====\n");
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
	
	// Method to end the game
	public void endGame() {
	  isEnd = true;
	  b1.setText("");
	  b2.setText("");
	  b3.setText("");
	  b4.setText("");
	  b5.setText("");
	  b6.setText("Menu");
	}
	
	// Method to wrap text in the text area.
	public void wrapText(String text) {
	  String temp = text;
	  int index = -1;
	  
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
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		launch();
		
	}
	
	/**Class: Menu
	 * @author Nick Stough
	 *
	 */
	class Menu implements EventHandler<ActionEvent>{
		
		  Stage stage = new Stage();
		  
		  /**
		   * Method: handle
		   * 
		   * creates the Gui
		   */
		  @Override
		  public void handle(ActionEvent e) {
			  
		    GridPane pane = new GridPane();
		    pane.setAlignment(Pos.CENTER);
		    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		    pane.setHgap(5.5);
		    pane.setVgap(5.5);

		    //Save Button
		    Button btSave = new Button("Save");
		    pane.add(btSave, 0, 0);
		    GridPane.setHalignment(btSave, HPos.RIGHT);
		    
		    //Load Button
		    Button btLoad = new Button("Load");
		    pane.add(btLoad, 1, 0);
		    GridPane.setHalignment(btSave, HPos.RIGHT);
		    
		    //Events
		    writeFile writeF = new writeFile();
		    CloseMenu closeF = new CloseMenu();
		    loadFile loadF = new loadFile();
		    
		    //Close Button
		    Button btClose = new Button("Cancel");
		    pane.add(btClose, 2, 0);
		    GridPane.setHalignment(btSave, HPos.RIGHT);
		    
		    //Actions
		    btClose.setOnAction(closeF);
		    btSave.setOnAction(writeF);
		    btLoad.setOnAction(loadF);

		    Scene scene = new Scene(pane);
		    stage.setTitle("Menu"); 
		    stage.setScene(scene); 
		    stage.setResizable(false);
		    stage.show(); 
		  }
		  
		  /**Class: CloseMenu
		   * @author Nick Stough
		   * 
		   */
		  class CloseMenu implements EventHandler<ActionEvent>
		  {
		  	@Override
		  	public void handle(ActionEvent e)
		  	{
		  	    stage.close();
		  	}
		  }
		  
		  /**Class: writeFile
		   * @author Nick Stough
		   *
		   */
		  class writeFile implements EventHandler<ActionEvent>
		  {
		  	@Override
		  	public void handle(ActionEvent e)
		  	{
		  			System.out.println("Saving");
		  			PrintWriter out;
					try
					{
						
						File file = new File("SaveFile.txt");
						out = new PrintWriter(new FileWriter(file, false));
			  			out.println(roomNum);
			  			out.println(score);
			  			out.println(user.getBonus());
			  			
						int[] inventorySave = {user.getInventory().get(0).getID(),user.getInventory().get(1).getID(),
								user.getInventory().get(2).getID(),user.getInventory().get(3).getID()};
						
						Boolean[] questionsAnsw = {bank.getList()[0].getIsUsed(),
								bank.getList()[1].getIsUsed(),
								bank.getList()[2].getIsUsed(),
								bank.getList()[3].getIsUsed(),
								bank.getList()[4].getIsUsed(),
								bank.getList()[5].getIsUsed(),
								bank.getList()[6].getIsUsed(),
								bank.getList()[7].getIsUsed(),
								bank.getList()[8].getIsUsed(),
								bank.getList()[9].getIsUsed(),
								bank.getList()[10].getIsUsed(),
								bank.getList()[11].getIsUsed(),
								bank.getList()[12].getIsUsed(),
								bank.getList()[13].getIsUsed(),
								bank.getList()[14].getIsUsed(),
								bank.getList()[15].getIsUsed(),
								bank.getList()[16].getIsUsed(),
								bank.getList()[17].getIsUsed(),
								bank.getList()[18].getIsUsed(),
								bank.getList()[19].getIsUsed(),
								bank.getList()[20].getIsUsed(),
						};
						
						Boolean[] roomsCleared = {
							floor.getList().get(0).getHasCleared(),
							floor.getList().get(1).getHasCleared(),
							floor.getList().get(2).getHasCleared(),
							floor.getList().get(3).getHasCleared(),
							floor.getList().get(4).getHasCleared(),
							floor.getList().get(5).getHasCleared(),
							floor.getList().get(6).getHasCleared(),
							floor.getList().get(7).getHasCleared(),
							floor.getList().get(8).getHasCleared(),
							floor.getList().get(9).getHasCleared(),
							floor.getList().get(10).getHasCleared(),
							floor.getList().get(11).getHasCleared(),
							floor.getList().get(12).getHasCleared(),
							floor.getList().get(13).getHasCleared(),
							floor.getList().get(14).getHasCleared()
						};
						out.print(inventorySave[0]+"|");
						out.print(inventorySave[1]+"|");
						out.print(inventorySave[2]+"|");
						out.println(inventorySave[3]);
						
						out.print(questionsAnsw[0]+"|");
						out.print(questionsAnsw[1]+"|");
						out.print(questionsAnsw[2]+"|");
						out.print(questionsAnsw[3]+"|");
						out.print(questionsAnsw[4]+"|");
						out.print(questionsAnsw[5]+"|");
						out.print(questionsAnsw[6]+"|");
						out.print(questionsAnsw[7]+"|");
						out.print(questionsAnsw[8]+"|");
						out.print(questionsAnsw[9]+"|");
						out.print(questionsAnsw[10]+"|");
						out.print(questionsAnsw[11]+"|");
						out.print(questionsAnsw[12]+"|");
						out.print(questionsAnsw[13]+"|");
						out.print(questionsAnsw[14]+"|");
						out.print(questionsAnsw[15]+"|");
						out.print(questionsAnsw[16]+"|");
						out.print(questionsAnsw[17]+"|");
						out.print(questionsAnsw[18]+"|");
						out.print(questionsAnsw[19]+"|");
						out.println(questionsAnsw[20]);
						
						out.print(roomsCleared[0]+"|");
						out.print(roomsCleared[1]+"|");
						out.print(roomsCleared[2]+"|");
						out.print(roomsCleared[3]+"|");
						out.print(roomsCleared[4]+"|");
						out.print(roomsCleared[5]+"|");
						out.print(roomsCleared[6]+"|");
						out.print(roomsCleared[7]+"|");
						out.print(roomsCleared[8]+"|");
						out.print(roomsCleared[9]+"|");
						out.print(roomsCleared[10]+"|");
						out.print(roomsCleared[11]+"|");
						out.print(roomsCleared[12]+"|");
						out.print(roomsCleared[13]+"|");
						out.print(roomsCleared[14]);
						
			  			out.close();
			  			
					} catch (IOException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		  		
		  		stage.close();
		  	}
		  }
		  
		  /**
		   * Class: loadFile
		   * @author Nick
		   *
		   */
		  class loadFile implements EventHandler<ActionEvent>
		  {
		  	@Override
		  	public void handle(ActionEvent e)
		  	{
				File mediaFile = new File("SaveFile.txt");
				
				String room = "0";
				String sscore = "0";
				String bonuses = "0";
				String[] inventory = {};
				String[] questionsAnsw = {};
				String[] roomsCleared = {};
				
				  Scanner mediaReader = null;
				  try{
				     mediaReader = new Scanner(mediaFile);
				   } catch (FileNotFoundException ex){
				     System.out.println("No Save file found");
				   }
				  
				  while (mediaReader != null && mediaReader.hasNext()){
				      room = mediaReader.nextLine();
				      sscore = mediaReader.nextLine();
				      bonuses = mediaReader.nextLine();
				      inventory = mediaReader.nextLine().split("[|]");
				      questionsAnsw = mediaReader.nextLine().split("[|]");
				      roomsCleared = mediaReader.nextLine().split("[|]");

				  }  
		  		
		  		System.out.println("Loading");
		  		
		  		
		  		user.addItem(Integer.parseInt(inventory[0]));
		  		user.addItem(Integer.parseInt(inventory[1]));
		  		user.addItem(Integer.parseInt(inventory[2]));
		  		user.addItem(Integer.parseInt(inventory[3]));
		  		
		  		System.out.println(user.getInventory().toString());
		  		score = Integer.parseInt(sscore);
		  		user.setBonus(Integer.parseInt(bonuses));
		  		
		  		roomNum = Integer.parseInt(room);
		  		location = floor.getList().get(roomNum).getRoomName();
		  		
		  		
		  		for(int i = 0; i < questionsAnsw.length; i++){
		  			bank.getList()[i].setIsUsed(Boolean.parseBoolean(questionsAnsw[i]));
		  		}
		  		
		  		for(int i = 0; i < roomsCleared.length; i++){
		  			floor.getList().get(i).setHasCleared(Boolean.parseBoolean(roomsCleared[i]));
		  		}
		  		
		  		stage.close();
		  	}
		  }
		}
}
