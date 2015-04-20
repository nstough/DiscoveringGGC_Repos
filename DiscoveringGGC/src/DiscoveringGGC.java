import javafx.application.Application;
import javafx.stage.Stage;

public class DiscoveringGGC
{
	
	GameGui gui = new GameGui();
	
	public static void main(String[] args)
	{
	
	FloorGenerator floor = new FloorGenerator(); 
	floor.layout();
	
	DiscoveringGGC.run(gui);
	}


}
