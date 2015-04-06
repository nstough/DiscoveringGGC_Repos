import javafx.application.Application;
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


/**Class: GameGui
 * @author Nick Stough
 * @version 1.0
 * Course : ITEC 2150 Fall 2013
 * Written: Apr 5, 2015
 *
 * This class describe
 *
 * Purpose: This purpose is ....
 */

/**
 * @author Nick
 *
 */
public class GameGui extends Application
{
	//Just change as you go
	public String version = "0.5";
	
	//The text that is displayed on the buttons
	public String b1Text = "Investigate";
	public String b2Text = "Talk to";
	public String b3Text = "Walk forward";
	public String b4Text = "Pick Up";
	public String b5Text = "Inventory";
	public String b6Text = "Menu";
	
	Button b1 = new Button();
	Button b2 = new Button();
	Button b3 = new Button();
	Button b4 = new Button();
	Button b5 = new Button();
	Button b6 = new Button();
	
	TextArea ta = new TextArea();
	
	public void start(Stage primaryStage)
	{	
		b1Action handler1 = new b1Action();
		b2Action handler2 = new b2Action();
		b3Action handler3 = new b3Action();
		b4Action handler4 = new b4Action();
		b5Action handler5 = new b5Action();
		Menu handler6 = new Menu();
		
		ta.setPrefWidth(480);
		ta.setPrefHeight(270);
		ta.setLayoutX(10);
		ta.setLayoutY(10);		
		ta.setEditable(false);
		
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
			
			b1.setPrefWidth(145);
			b1.setPrefHeight(35);
			b1.setLayoutX(15);
			b1.setLayoutY(300);
			b1.setOnAction(handler1);
		
			b2.setPrefWidth(145);
			b2.setPrefHeight(35);
			b2.setLayoutX(15);
			b2.setLayoutY(350);
			b2.setOnAction(handler2);

			b3.setPrefWidth(145);
			b3.setPrefHeight(35);
			b3.setLayoutX(170);
			b3.setLayoutY(300);
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
		
			
		b1.setText(b1Text);
		b2.setText(b2Text);
		b3.setText(b3Text);
		b4.setText(b4Text);
		b5.setText(b5Text);
		b6.setText(b6Text);
			
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

		Scene scene = new Scene(pane, 500, 400);
		primaryStage.setTitle("Discovering GGC | Version " + version); 
		primaryStage.setScene(scene); 
		primaryStage.setResizable(false);
		primaryStage.show(); 
		
		
		ta.appendText("You walk into an empty room\n");
	}

	public static void main(String[] args)
	{		
		
		launch(args);
	}
	
	  class b1Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{
	  		ta.appendText("There doesn't seem to be anything here\n");
	  	}
	  }
	  
	  class b2Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{
	  		ta.appendText("There is no one here to talk to\n");
	  	}
	  }
	  
	  class b3Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{
	  		ta.appendText("There doesn't seem to be a way forward\n");
	  	}
	  }
	  
	  class b4Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{
	  		ta.appendText("You couldn't find anything to pick up\n");
	  	}
	  }
	  
	  class b5Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{
	  		if(b5Text.equalsIgnoreCase("inventory")){
	  			b5Text = "Back";
	  			
	  			b1Text = "Water Bottle";
	  			b2Text = "Notebook";
	  			b3Text = "Wallet";
	  			b4Text = "Rock";
	  			
	  			b1.setText(b1Text);
	  			b2.setText(b2Text);
	  			b3.setText(b3Text);
	  			b4.setText(b4Text);
	  			b5.setText(b5Text);
	  			b6.setText(b6Text);
	  		}
	  		else if(b5Text.equalsIgnoreCase("back")){
	  			b5Text = "Inventory";
	  			
	  			b1Text = "Investigate";
	  			b2Text = "Talk to";
	  			b3Text = "Walk Forward";
	  			b4Text = "Pick Up";
	  			
	  			b1.setText(b1Text);
	  			b2.setText(b2Text);
	  			b3.setText(b3Text);
	  			b4.setText(b4Text);
	  			b5.setText(b5Text);
	  			b6.setText(b6Text);
	  		}
	  	}
	  }
	  
	  class b6Action implements EventHandler<ActionEvent>
	  {
	  	@Override
	  	public void handle(ActionEvent e)
	  	{

	  	}
	  }
}
