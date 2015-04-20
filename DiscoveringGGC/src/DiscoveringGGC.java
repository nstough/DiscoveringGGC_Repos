
public class DiscoveringGGC
{
	
	public static void main(String[] args)
	{
	GameGui.launch(GameGui.class);
	
	FloorGenerator floor = new FloorGenerator(); 
	floor.layout();
	
	
	}


}
