import javafx.application.Application;
import javafx.stage.Stage;

public class DiscoveringGGC extends Application {
	
	GameGui gui = new GameGui();
	
	public static void main(String[] args)
	{
	
	FloorGenerator floor = new FloorGenerator(); 
	floor.layout();
	
	
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
