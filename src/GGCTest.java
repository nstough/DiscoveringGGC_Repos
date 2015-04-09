public class GGCTest {
  public static void main(String[] args) {
	PuzzleEvents quests = new PuzzleEvents();
	String currentLocation;
	
	
	currentLocation = quests.events.get(0).getPuzzleLocation();
	
	for (int i = 0; i < quests.events.size(); i++) {
	  System.out.println("Location of Quest " + (i + 1) + " is " +
	          quests.events.get(i).getPuzzleLocation());
		
	  if (quests.events.get(i).getPuzzleLocation().equals(currentLocation) &&
			  !quests.events.get(i).getIsCompleted()) {
		quests.events.get(i).setIsAvailable(true);
	  }
	}
	
	System.out.println("=====");
	for (int i = 0; i < quests.events.size(); i++) {
	  System.out.print("Quest " + (i + 1) + " is ");
	  if (!quests.events.get(i).getIsAvailable()) {
		System.out.print("not ");
	  }
	  System.out.println("available.");
	}
  }
}