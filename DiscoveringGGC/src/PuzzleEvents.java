/* Title:       "Discovering GGC - PuzzleEvents Class"
 * Description: This class is designed to provide the methods of all available events that the
 *              player can encounter, as well as populating their location of encounter.
 * Author:      Tim Nguyen
 * Version:     0.2 (April 9, 2015 @ 11:25 PM)
 */

import java.util.ArrayList;
import java.util.Random;

public class PuzzleEvents extends Player{
  static ArrayList<Puzzles> events = new ArrayList<Puzzles>();
  final static int EVENT_SIZE = 10;
  
  // Base constructor to populate the possible events list with generic IDs.
  public PuzzleEvents() {
    Random rand = new Random();
	
	for (int i = 0; i < EVENT_SIZE; i++) {
      events.add(new Puzzles((i + 1), "A Building"));
      
      // Switch-Statement that uses a random integer generator to set random locations to
      // each puzzle.
      switch(rand.nextInt(3)) {
        case 0:  events.get(i).setPuzzleLocation("A Building");
                 break;
        case 1:  events.get(i).setPuzzleLocation("B Building");
                 break;
        case 2:  events.get(i).setPuzzleLocation("C Building");
                 break;
        default: events.get(i).setPuzzleLocation("B Building");
                 break;
      }
    }
  }
  
  // Event 01 - Michael needs help finding his binder.
  public void helpEvent01() {
	// ID = 1
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(0).getIsAvailable() && !events.get(0).getIsCompleted()) {
	  events.get(0).setIsActive(true);
	  GameGui.ta.appendText("Hey there, do you mind doing me a favor? I can't seem to find my " +
	          "binder anywhere. If you see it, could you bring it to me? It has my name on " +
	    	  "it, Michael.");
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 01 End Method
  public static void endEvent01() {
	// ID = 1
	  if (hasRequirement(new Items(1))) {
	    GameGui.ta.appendText("Oh hey! You found my binder. Thanks for the help. You can have " +
		  		"these scantrons. Some teachers will require you to have them to take their " +
		   		"tests.");
		for (int i = 0; i < getInventory().size(); i++) {
		  if (hasRequirement(new Items(1))) {
			getInventory().get(i).setID(2);
			break;
		  }
		}
		GameGui.ta.appendText("You have traded Michael's Binder for some scantrons.");
		events.get(0).setIsAvailable(false);
		events.get(0).setIsActive(false);
		events.get(0).setIsCompleted(true);
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 02 - Allen is hungry and wants to join her friends in the dining hall.
  public void helpEvent02() {
	// ID = 2
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(1).getIsAvailable() && !events.get(1).getIsCompleted()) {
	  events.get(1).setIsActive(true);
	  GameGui.ta.appendText("Hey dude, sorry to bother you, but can you help a brother out? "+ 
			  "I wanna join my friends in the dining hall, but I've got no cash, do you " +
			  "think you can spot me?");
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 02 End Method
  public static void endEvent02() {
	if (hasRequirement(new Items(3))) {
	  GameGui.ta.appendText("You actually got me a ticket for the dining hall? Thanks. Tell " + 
	          "you what, you're taking a class that I've already passed. I'll help you " +
		      "pass that class.");
		for (int i = 0; i < getInventory().size(); i++) {
		  if (hasRequirement(new Items(3))) {
			removeItem(i);
		    setBonus(getBonus() + 1);
			break;
		  }
		}
	  events.get(1).setIsAvailable(false);
	  events.get(1).setIsActive(false);
	  events.get(1).setIsCompleted(true);
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 03 - Nicole needs scantrons for her class.
  public void helpEvent03() {
	// ID - 3
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(2).getIsAvailable() && !events.get(2).getIsCompleted()) {
      events.get(2).setIsActive(true);
	  GameGui.ta.appendText("Excuse me, but do you mind doing me a favor? I have a test in " +
	          "my class and I don't have any scantrons. Do you think you could get a few " +
			  "for me?");
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 03 End Method
  public static void endEvent03() {
    if (hasRequirement(new Items(2))) {
      GameGui.ta.appendText("Oh, thanks for finding me some scantrons. Tell you what, if you " +
              "ever take this class, I'll help you out.");
      for (int i = 0; i < getInventory().size(); i++) {
    	if (hasRequirement(new Items(2))) {
    	  removeItem(i);
		  setBonus(getBonus() + 1);
    	  break;
    	}
      }
      events.get(2).setIsAvailable(false);
      events.get(2).setIsActive(false);
      events.get(2).setIsCompleted(true);
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 04 - Ren has a gym class and can't find his claw card.
  public void helpEvent04() {
	// ID - 4
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(3).getIsAvailable() && !events.get(3).getIsCompleted()) {
	  events.get(3).setIsActive(true);
      GameGui.ta.appendText("Hey bro, you mind doing me a favor? I seemed to have misplaced " +
              "my claw card and I have gym class later today. Can you help me look for it?");
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 04 End Method
  public static void endEvent04() {
    if (hasRequirement(new Items(4))) {
      GameGui.ta.appendText("Dude, thanks for finding my claw card. I would of been in " +
              "trouble if I couldn't find it. Stop by Chick-fil-A in the A Building when " +
              "you get the chance. I'll hook you up.");
      for (int i = 0; i < getInventory().size(); i++) {
    	if (hasRequirement(new Items(4))) {
    	  getInventory().get(i).setID(7);
    	  break;
    	}
      }
      GameGui.ta.appendText("You have received a chicken sandwich for your efforts.");
      events.get(3).setIsAvailable(false);
      events.get(3).setIsActive(false);
      events.get(3).setIsCompleted(true);
    }
	GameGui.ta.appendText("=====");
  }
  
  // Event 05 - Susan brought her umbrella and can't find it.
  public void helpEvent05() {
	// ID - 5
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(4).getIsAvailable() && !events.get(4).getIsCompleted()) {
      events.get(4).setIsActive(true);
	  GameGui.ta.appendText("Hey you! Can you help me for a sec? It looks like its gonna rain " +
              "and I can't seem to find my umbrella. If you see it, can you bring it to me? " +
    	      "It's a blue umbrella if you find it.");
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 05 End Method
  public static void endEvent05() {
    if (hasRequirement(new Items(5))) {
      GameGui.ta.appendText("Oh hey! You found my umbrella. Thanks for the help. I have this " +
              "ticket for a free meal in the dining hall. I don't eat there, so you can " +
    	      "have it.");
      for (int i = 0; i < getInventory().size(); i++) {
    	if (hasRequirement(new Items(5))) {
    	  getInventory().get(i).setID(3);
    	  break;
    	}
      }
      GameGui.ta.appendText("You have been gifted a coupon for the dining hall.");
      events.get(4).setIsAvailable(false);
      events.get(4).setIsActive(false);
      events.get(4).setIsCompleted(true);
    }
	GameGui.ta.appendText("=====");
  }
  
  // Event 06 - David is thirsty, but doesn't have a drink. 
  public void helpEvent06() {
	// ID - 6
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(5).getIsAvailable() && !events.get(5).getIsCompleted()) {
      events.get(5).setIsActive(true);
	  GameGui.ta.appendText("Hey, do you think you can do me a favor? I'm about to tutor " +
              "someone and I'm really thirsty. I don't wanna get up since I think they'll " +
    	      "accidentally miss me. You mind getting me something to drink?");
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 06 End Method
  public static void endEvent06() {
    if (hasRequirement(new Items(6))) {
      GameGui.ta.appendText("Thanks for the water. As I said, I'm a tutor, so I'll help you " +
    		  " in one of your classes. And here's my card, if you need help again.");
      for (int i = 0; i < getInventory().size(); i++) {
    	if (hasRequirement(new Items(6))) {
    	  getInventory().get(i).setID(8);
  		  setBonus(getBonus() + 1);
    	  break;
    	}
      }
      GameGui.ta.appendText("You have been given a tutor's card.");
      events.get(5).setIsAvailable(false);
      events.get(5).setIsActive(false);
      events.get(5).setIsCompleted(true);
    }
	GameGui.ta.appendText("=====");
  }
  
  // Event 07 - Alice has a test next week and needs tutoring.
  public void helpEvent07() {
	// ID - 7
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(6).getIsAvailable() && !events.get(6).getIsCompleted()) {
      events.get(6).setIsActive(true);
	  GameGui.ta.appendText("Hey, you think you can help me out? I've got a test next week " +
              "and I think I'm gonna bomb. Oh, you haven't taken this class yet? Shame. " +
    		  "Oh well, thanks for your help.");
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 07 End Method
  public static void endEvent07() {
    if (hasRequirement(new Items(8))) {
      GameGui.ta.appendText("What's this? Tutoring? That would definitely help. I'll give " +
              "them a call and set up a date. I found this umbrella earlier and was gonna" +
    		  "bring it to lost and found. You think you can do that for me?");
      for (int i = 0; i < getInventory().size(); i++) {
    	if (hasRequirement(new Items(8))) {
    	  getInventory().get(i).setID(5);
    	  break;
    	}
      }
      GameGui.ta.appendText("You have found someone's blue umbrella.");
      events.get(6).setIsAvailable(false);
      events.get(6).setIsActive(false);
      events.get(6).setIsCompleted(true);
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 08 - Andrew doesn't have any money for food.
  public void helpEvent08() {
	// ID - 8
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(7).getIsAvailable() && !events.get(7).getIsCompleted()) {
      events.get(7).setIsActive(true);
	  GameGui.ta.appendText("Dude, you mind getting me something to eat? I'm hungry and got " +
              "nothing left on my claw card.");
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 08 End Method
  public static void endEvent08() {
    if (hasRequirement(new Items(7))) {
      GameGui.ta.appendText("That smells like chicken. Wait, is that for me? BOSS! Thanks man. " +
              "Tell you what: for helping me, I'll call my friend and he'll tutor you for " +
    	      "one of your classes.");
      for (int i = 0; i < getInventory().size(); i++) {
        if (hasRequirement(new Items(7))) {
    	  getInventory().get(i).setID(0);
  		  setBonus(getBonus() + 1);
    	  break;
    	}
      }
      events.get(7).setIsAvailable(false);
      events.get(7).setIsActive(false);
      events.get(7).setIsCompleted(true);
    }
	GameGui.ta.appendText("=====");
  }
  
  // Event 09 - Jessica is about to study for her test.
  public void helpEvent09() {
	// ID - ?
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(8).getIsAvailable() && !events.get(8).getIsCompleted()) {
	  events.get(8).setIsActive(true);
      GameGui.ta.appendText("Hey there. Sorry, I'm trying to study for a test and I can't be " +
              "bothered right now.");
	}
  }
  
  // Event 09 End Method
  public static void endEvent09() {
    if (hasRequirement(new Items(9))) {
      GameGui.ta.appendText("Gum? I heard that chewing gum while studying and then chewing gum " +
              "while taking a test will improve one's memory. I guess this could help. " +
    		  "Thanks. Here, someone left their claw card behind. Help them out like you helped " +
              "me.");
      for (int i = 0; i < getInventory().size(); i++) {
        if (hasRequirement(new Items(9))) {
    	  getInventory().get(i).setID(4);
    	  break;
    	}
      }
      GameGui.ta.appendText("You have sold your pack of gum for a dollar.");
      events.get(8).setIsAvailable(false);
      events.get(8).setIsActive(true);
      events.get(8).setIsCompleted(true);
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 10 - Carl wants help finding his phone.
  public void helpEvent10() {
	// ID - 10
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(9).getIsAvailable() && !events.get(9).getIsCompleted()) {
	  events.get(9).setIsActive(true);
  	  GameGui.ta.appendText("Hey dude, can you help me out? I just got out of class and can't " +
		      "find my phone. Can you help me find it?");
	}
	GameGui.ta.appendText("=====");
  }
  
  // Event 10 End Method
  public static void endEvent10() {
    if (hasRequirement(new Items(10))) {
      GameGui.ta.appendText("Hey, you found my phone. Thanks man. Don't really have much for " +
              "a reward, but here's some gum.");
      for (int i = 0; i < getInventory().size(); i++) {
    	if (hasRequirement(new Items(10))) {
    	  getInventory().get(i).setID(9);
    	  break;
    	}
      }
      GameGui.ta.appendText("You have received a pack of gum.");
      events.get(9).setIsAvailable(false);
      events.get(9).setIsActive(false);
      events.get(9).setIsCompleted(true);
	}
	GameGui.ta.appendText("=====");
  }
  
  // Method to indicate whether the player's inventory has the required item.
  public static boolean hasRequirement(Items item) {
	boolean hasItem = false;
	
	for (int i = 0; i < getInventory().size(); i++) {
	  if (getInventory().get(i).getItemName() == item.getItemName()) {
		hasItem = true;
		break;
	  }
	}
	
	return hasItem;
  }
}
