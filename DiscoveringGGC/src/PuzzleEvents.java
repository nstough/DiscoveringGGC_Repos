import java.util.ArrayList;

public class PuzzleEvents extends Player{
  ArrayList<Puzzles> events = new ArrayList<Puzzles>();
  
  // Base constructor to populate the possible events list with generic IDs.
  public PuzzleEvents() {
    for (int i = 0; i < 10; i++) {
      events.add(new Puzzles((i + 1), "A Building"));
    }
  }
  
  // Event 01 - Michael needs help finding his binder.
  public void helpMichaelEvent() {
	// ID = 1
	if (events.get(1).getIsAvailable()) {
	  if (inventory.contains(new Items(1))) {
	  System.out.print("Oh hey! You found my binder. Thanks for the help. You can have these " +
	                   "scantrons. Some teachers will require you to have them to take their " + 
			           "tests.");
	  for (int i = 0; i < inventory.size(); i++) {
		if (inventory.get(i).getID() == 1) {
		  inventory.get(i).setID(2);
		  break;
		}
	  }
	  
	  System.out.println("You have traded Michael's Binder for some scantrons.");
	  events.get(1).setIsAvailable(false);
	  events.get(1).setIsCompleted(true);
	  events.get(1).setSuccess(true);
	  } else {
	    System.out.println("Hey there, do you mind doing me a favor? I can't seem to find my " +
	                       "binder anywhere. If you see it, could you bring it to me? It has " +
	    		           "name on it, Michael.");
	  }
    }
  }
}
