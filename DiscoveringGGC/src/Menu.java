import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
					
					File file = new File("c:\\newfile.txt");
					out = new PrintWriter(new FileWriter(file, true));
		  			out.println("Stuff to Get Saved");
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
	  			System.out.println("Loading");
	  			
	  		stage.close();
	  	}
	  }
	}