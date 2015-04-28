/* Title:       "Discovering GGC - PuzzleEvents Class"
 * Description: This class is designed to provide the methods of all available events that the
 *              player can encounter, as well as populating their location of encounter.
 * Author:      Tim Nguyen
 * Version:     0.2 (April 9, 2015 @ 11:25 PM)
 */

import java.util.ArrayList;

public class PuzzleEvents{
  static ArrayList<Puzzles> events = new ArrayList<Puzzles>();
  final static int EVENT_SIZE = 10;
  
  String text = "";
  
  // Base constructor to populate the possible events list with generic IDs.
  public PuzzleEvents() {
	for (int i = 0; i < EVENT_SIZE; i++) {
      events.add(new Puzzles((i + 1)));
    }
  }
  
  // Event 01 - Michael needs help finding his binder.
  public void helpEvent01() {
	// ID = 1
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(0).getIsAvailable() && !events.get(0).getIsCompleted()) {
	  events.get(0).setIsActive(true);
	  
	  wordWrap("Michael: Hey there, do you mind doing me a favor? I can't seem to find my " +
	         "binder anywhere. If you see it, could you bring it to me? It has my name on " +
	    	 "it, Michael.");
	}
	wordWrap("=====");
  }
  
  // Event 01 End Method
  public static void endEvent01() {
	// ID = 1
	  if (hasRequirement(new Items(1))) {
	    wordWrap("Michael: Oh hey! You found my binder. Thanks for the help. You can have " +
		  		"these scantrons. Some teachers will require you to have them to take their " +
		   		"tests.");
		for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
		  Items temp = new Items(1);
		  
		  if (GameGui.user.getInventory().get(i).getID() == temp.getID()) {
			  GameGui.user.getInventory().get(i).setID(2);
			break;
		  }
		}
		wordWrap("You have traded Michael's Binder for some scantrons.");
		events.get(0).setIsAvailable(false);
		events.get(0).setIsActive(false);
		events.get(0).setIsCompleted(true);
	}
	wordWrap("=====");
  }
  
  // Event 02 - Allen is hungry and wants to join her friends in the dining hall.
  public void helpEvent02() {
	// ID = 2
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(1).getIsAvailable() && !events.get(1).getIsCompleted()) {
	  events.get(1).setIsActive(true);
	  wordWrap("Allen: Hey dude, sorry to bother you, but can you help a brother out? "+ 
			  "I wanna join my friends in the dining hall, but I've got no cash, do you " +
			  "think you can spot me?");
	}
	wordWrap("=====");
  }
  
  // Event 02 End Method
  public static void endEvent02() {
	if (hasRequirement(new Items(3))) {
	  wordWrap("Allen: You actually got me a ticket for the dining hall? Thanks. Tell " + 
	          "you what, you're taking a class that I've already passed. I'll help you " +
		      "pass that class.");
		for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
		  Items temp = new Items(3);
		  
		  if (GameGui.user.getInventory().get(i).getID() == temp.getID()) {
			  GameGui.user.getInventory().get(i).setID(0);
			  GameGui.user.setBonus(GameGui.user.getBonus() + 1);
			break;
		  }
		}
	  events.get(1).setIsAvailable(false);
	  events.get(1).setIsActive(false);
	  events.get(1).setIsCompleted(true);
	}
	wordWrap("=====");
  }
  
  // Event 03 - Nicole needs scantrons for her class.
  public void helpEvent03() {
	// ID - 3
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(2).getIsAvailable() && !events.get(2).getIsCompleted()) {
      events.get(2).setIsActive(true);
	  wordWrap("Nicole: Excuse me, but do you mind doing me a favor? I have a test in " +
	          "my class and I don't have any scantrons. Do you think you could get a few " +
			  "for me?");
	}
	wordWrap("=====");
  }
  
  // Event 03 End Method
  public static void endEvent03() {
    if (hasRequirement(new Items(2))) {
      wordWrap("Nicole: Oh, thanks for finding me some scantrons. Tell you what, if you " +
              "ever take this class, I'll help you out.");
      for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
    	Items temp = new Items(2);
    	
    	if (GameGui.user.getInventory().get(i).getID() == temp.getID()) {
    		GameGui.user.getInventory().get(i).setID(0);
    		GameGui.user.setBonus(GameGui.user.getBonus() + 1);
    	  break;
    	}
      }
      events.get(2).setIsAvailable(false);
      events.get(2).setIsActive(false);
      events.get(2).setIsCompleted(true);
	}
	wordWrap("=====");
  }
  
  // Event 04 - Ren has a gym class and can't find his claw card.
  public void helpEvent04() {
	// ID - 4
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(3).getIsAvailable() && !events.get(3).getIsCompleted()) {
	  events.get(3).setIsActive(true);
      wordWrap("Ren: Hey bro, you mind doing me a favor? I seemed to have misplaced " +
              "my claw card and I have gym class later today. Can you help me look for it?");
	}
	wordWrap("=====");
  }
  
  // Event 04 End Method
  public static void endEvent04() {
    if (hasRequirement(new Items(4))) {
      wordWrap("Ren: Dude, thanks for finding my claw card. I would of been in " +
              "trouble if I couldn't find it. Stop by Chick-fil-A in the A Building when " +
              "you get the chance. I'll hook you up.");
      for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
    	Items temp = new Items(4);
    	
    	if (GameGui.user.getInventory().get(i).getID() == temp.getID()) {
    		GameGui.user.getInventory().get(i).setID(7);
    	  break;
    	}
      }
      wordWrap("You have received a chicken sandwich for your efforts.");
      events.get(3).setIsAvailable(false);
      events.get(3).setIsActive(false);
      events.get(3).setIsCompleted(true);
    }
	wordWrap("=====");
  }
  
  // Event 05 - Susan brought her umbrella and can't find it.
  public void helpEvent05() {
	// ID - 5
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(4).getIsAvailable() && !events.get(4).getIsCompleted()) {
      events.get(4).setIsActive(true);
	  wordWrap("Susan: Hey you! Can you help me for a sec? It looks like its gonna rain " +
              "and I can't seem to find my umbrella. If you see it, can you bring it to me? " +
    	      "It's a blue umbrella if you find it.");
	}
	wordWrap("=====");
  }
  
  // Event 05 End Method
  public static void endEvent05() {
    if (hasRequirement(new Items(5))) {
      wordWrap("Susan: Oh hey! You found my umbrella. Thanks for the help. I have this " +
              "ticket for a free meal in the dining hall. I don't eat there, so you can " +
    	      "have it.");
      for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
    	Items temp = new Items(5);
    	
    	if (GameGui.user.getInventory().get(i).getID() == temp.getID()) {
    		GameGui.user.getInventory().get(i).setID(3);
    	  break;
    	}
      }
      wordWrap("You have been gifted a coupon for the dining hall.");
      events.get(4).setIsAvailable(false);
      events.get(4).setIsActive(false);
      events.get(4).setIsCompleted(true);
    }
	wordWrap("=====");
  }
  
  // Event 06 - David is thirsty, but doesn't have a drink. 
  public void helpEvent06() {
	// ID - 6
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(5).getIsAvailable() && !events.get(5).getIsCompleted()) {
      events.get(5).setIsActive(true);
	  wordWrap("David: Hey, do you think you can do me a favor? I'm about to tutor " +
              "someone and I'm really thirsty. I don't wanna get up since I think they'll " +
    	      "accidentally miss me. You mind getting me something to drink?");
	}
	wordWrap("=====");
  }
  
  // Event 06 End Method
  public static void endEvent06() {
    if (hasRequirement(new Items(6))) {
      wordWrap("David: Thanks for the water. As I said, I'm a tutor, so I'll help you " +
    		  " in one of your classes. And here's my card, if you need help again.");
      for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
    	Items temp = new Items(6);
    	
    	if (GameGui.user.getInventory().get(i).getID() == temp.getID()) {
    		GameGui.user.getInventory().get(i).setID(8);
    		GameGui.user.setBonus(GameGui.user.getBonus() + 1);
    	  break;
    	}
      }
      wordWrap("You have been given a tutor's card.");
      events.get(5).setIsAvailable(false);
      events.get(5).setIsActive(false);
      events.get(5).setIsCompleted(true);
    }
	wordWrap("=====");
  }
  
  // Event 07 - Alice has a test next week and needs tutoring.
  public void helpEvent07() {
	// ID - 7
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(6).getIsAvailable() && !events.get(6).getIsCompleted()) {
      events.get(6).setIsActive(true);
	  wordWrap("Alice: Hey, you think you can help me out? I've got a test next week " +
              "and I think I'm gonna bomb. Oh, you haven't taken this class yet? Shame. " +
    		  "Oh well, thanks for your help.");
	}
	wordWrap("=====");
  }
  
  // Event 07 End Method
  public static void endEvent07() {
    if (hasRequirement(new Items(8))) {
      wordWrap("Alice: What's this? Tutoring? That would definitely help. I'll give " +
              "them a call and set up a date. I found this umbrella earlier and was gonna" +
    		  " bring it to lost and found. You think you can do that for me?");
      for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
    	Items temp = new Items(8);
    	
    	if (GameGui.user.getInventory().get(i).getID() == temp.getID()) {
    		GameGui.user.getInventory().get(i).setID(5);
    	  break;
    	}
      }
      wordWrap("You have found someone's blue umbrella.");
      events.get(6).setIsAvailable(false);
      events.get(6).setIsActive(false);
      events.get(6).setIsCompleted(true);
	}
	wordWrap("=====");
  }
  
  // Event 08 - Andrew doesn't have any money for food.
  public void helpEvent08() {
	// ID - 8
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(7).getIsAvailable() && !events.get(7).getIsCompleted()) {
      events.get(7).setIsActive(true);
	  wordWrap("Andrew: Dude, you mind getting me something to eat? I'm hungry and got " +
              "nothing left on my claw card.");
	}
	wordWrap("=====");
  }
  
  // Event 08 End Method
  public static void endEvent08() {
    if (hasRequirement(new Items(7))) {
      wordWrap("Andrew: That smells like chicken. Wait, is that for me? BOSS! Thanks man. " +
              "Tell you what: for helping me, I'll call my friend and he'll tutor you for " +
    	      "one of your classes.");
      for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
    	Items temp = new Items(7);
    	
        if (GameGui.user.getInventory().get(i).getID() == temp.getID()) {
        	GameGui.user.getInventory().get(i).setID(0);
        	GameGui.user.setBonus(GameGui.user.getBonus() + 1);
    	  break;
    	}
      }
      events.get(7).setIsAvailable(false);
      events.get(7).setIsActive(false);
      events.get(7).setIsCompleted(true);
    }
	wordWrap("=====");
  }
  
  // Event 09 - Jessica is about to study for her test.
  public void helpEvent09() {
	// ID - ?
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(8).getIsAvailable() && !events.get(8).getIsCompleted()) {
	  events.get(8).setIsActive(true);
      wordWrap("Jessica: Hey there. Sorry, I'm trying to study for a test and I can't be " +
              "bothered right now.");
	}
  }
  
  // Event 09 End Method
  public static void endEvent09() {
    if (hasRequirement(new Items(9))) {
      wordWrap("Jessica: Gum? I heard that chewing gum while studying and then chewing gum " +
              "while taking a test will improve one's memory. I guess this could help. " +
    		  "Thanks. Here, someone left their claw card behind. Help them out like you helped " +
              "me.");
      for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
    	Items temp = new Items(9);
    	
        if (GameGui.user.getInventory().get(i).getID() == temp.getID()) {
        	GameGui.user.getInventory().get(i).setID(4);
    	  break;
    	}
      }
      wordWrap("You have sold your pack of gum for a dollar.");
      events.get(8).setIsAvailable(false);
      events.get(8).setIsActive(true);
      events.get(8).setIsCompleted(true);
	}
	wordWrap("=====");
  }
  
  // Event 10 - Carl wants help finding his phone.
  public void helpEvent10() {
	// ID - 10
	// If-Statement that will only allow the event to trigger if the event is available.
	if (events.get(9).getIsAvailable() && !events.get(9).getIsCompleted()) {
	  events.get(9).setIsActive(true);
  	  wordWrap("Carl: Hey dude, can you help me out? I just got out of class and can't " +
		      "find my phone. Can you help me find it?");
	}
	wordWrap("=====");
  }
  
  // Event 10 End Method
  public static void endEvent10() {
    if (hasRequirement(new Items(10))) {
      wordWrap("Carl: Hey, you found my phone. Thanks man. Don't really have much for " +
              "a reward, but here's some gum.");
      for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
    	Items temp = new Items(10);
    	
    	if (GameGui.user.getInventory().get(i).getID() == temp.getID()) {
    		GameGui.user.getInventory().get(i).setID(9);
    	  break;
    	}
      }
      wordWrap("You have received a pack of gum.");
      events.get(9).setIsAvailable(false);
      events.get(9).setIsActive(false);
      events.get(9).setIsCompleted(true);
	}
	wordWrap("=====");
  }
  
  // Method to indicate whether the player's inventory has the required item.
  public static boolean hasRequirement(Items item) {
	boolean hasItem = false;
	
	for (int i = 0; i < GameGui.user.getInventory().size(); i++) {
	  if (GameGui.user.getInventory().get(i).getItemName() == item.getItemName()) {
		hasItem = true;
		break;
	  }
	}
	
	return hasItem;
  }
  
  public static void wordWrap(String text) {
	String temp = text;
	int index = -1;
	
	while (temp.length() > 0) {
	  if (temp.length() < 80) {
	    GameGui.ta.appendText(temp + "\n");
		temp = "";
	  } else {
		index = temp.lastIndexOf(" ", 80);
		GameGui.ta.appendText(temp.substring(0, index) + "\n");
		temp = temp.substring(index + 1);
	  }
    }
  }
}
