/* Title:       "Discovering GGC - TestTim"
 * Description: This class is designed to test the different functionalities of the author's classes. 
 * Author:      Tim Nguyen
 * Version:     0.1 (April 9, 2015 @ 11:24 PM)
 */

import java.util.Scanner;

public class TestTim {
  public static void main(String[] args) {
	PuzzleEvents quests = new PuzzleEvents();
	QuestionBank bank = new QuestionBank();
	int totalCredits = 0; // In-game score. Higher points are better.
    
	Scanner input = new Scanner(System.in); // Scanner object to allow user-timed pauses
	
	System.out.println("*** Test to display inventory. ***");
	quests.user.displayInventory();
	input.nextLine();
	
	System.out.println("*** Test to add item. ***");
	quests.user.addItem(1);
	input.nextLine();
	
	System.out.println("*** Test to add items to full capacity. Unlikely for game to have scenario of over-capacity. ***");
	quests.user.addItem(2);
	quests.user.addItem(3);
	quests.user.addItem(4);
	quests.user.addItem(5);
	input.nextLine();
	
	System.out.println("*** Test to show added items in inventory. ***");
	quests.user.displayInventory();
	input.nextLine();
	
	System.out.println("*** Test to remove item from inventory. Value in method indicates inventory slot. " +
			"Unlikely that the player will want to remove item, but option is available. ***");
	quests.user.removeItem(1);
	quests.user.displayInventory();
	input.nextLine();
	
	System.out.println("*** Inventory test complete. Emptying inventory for puzzle tests. ***");
	quests.user.inventory.get(0).setID(0);
	quests.user.inventory.get(1).setID(0);
	quests.user.inventory.get(2).setID(0);
	quests.user.inventory.get(3).setID(0);
	quests.user.displayInventory();
	input.nextLine();
	
	System.out.println("*** Testing puzzle availability of Event 1. ***");
	System.out.println("Event 1 is " + quests.events.get(0).getIsAvailable());
	input.nextLine();
	
	System.out.println("*** Testing false availability action of Event 1. No dialogue should appear (other than line breaks). ***");
	quests.helpEvent01();
	input.nextLine();
	
	System.out.println("*** Force change of Event 1 to be available. ***");
	quests.events.get(0).setIsAvailable(true);
	System.out.println("Event 1 is " + quests.events.get(0).getIsAvailable());
	input.nextLine();
	
	System.out.println("*** Testing true availability of Event 1. Defaults to a help dialogue from NPC. ***");
	quests.helpEvent01();
	input.nextLine();
	
	System.out.println("*** Displaying boolean values for Event 1 (before quest complete). ***");
	System.out.println("Available: " + quests.events.get(0).getIsAvailable());
	System.out.println("Completed: " + quests.events.get(0).getIsCompleted());
	input.nextLine();
	
	System.out.println("*** Adding Event-Related item to players inventory and repeating event. A different " +
			"dialogue should occur with a new action. ***");
	quests.user.addItem(1);
	System.out.println("*** Displaying inventory to show item. ***");
	quests.user.displayInventory();
	input.nextLine();
	
	quests.helpEvent01();
	input.nextLine();
	
	System.out.println("*** Event 1 has provided an item. Displaying inventory to reveal a change in items. ***");
	quests.user.displayInventory();
	input.nextLine();
	
	System.out.println("*** Displaying boolean values for Event 1 (after quest complete). ***");
	System.out.println("Available: " + quests.events.get(0).getIsAvailable());
	System.out.println("Completed: " + quests.events.get(0).getIsCompleted());
	input.nextLine();
	
	System.out.println("*** Event 1 is now unavailable. If forced to be available, it should not occur again since it " +
	        "is complete. ***");
	quests.events.get(0).setIsAvailable(true);
	quests.helpEvent01();
	input.nextLine();
	
	System.out.println("*** Event test complete. Resetting for question test. ***");
	quests.user.inventory.get(0).setID(0);
	quests.events.get(0).setIsAvailable(false);
	quests.events.get(0).setIsCompleted(false);
	input.nextLine();
	
	System.out.println("*** Displaying credits earned. ***");
	System.out.println("Current Score: " + totalCredits);
	System.out.println("Bonus Help Earned: " + quests.user.getBonus());
	input.nextLine();
	
	System.out.println("*** Testing Question 1 of the Basic List. ***");
	System.out.println(bank.ggcList[0].getQuery());
	System.out.println("1 - " + bank.ggcList[0].getAns1());
	System.out.println("2 - " + bank.ggcList[0].getAns2());
	System.out.println("3 - " + bank.ggcList[0].getAns3());
	System.out.println("4 - " + bank.ggcList[0].getAns4());
	input.nextLine();
	
	System.out.println("*** Testing incorrect answer. ***");
	System.out.println("Entered Choice: 0 (for testing purposes)");
	System.out.println("Correct Choice: " + bank.ggcList[0].getCorrectAnswer());
	System.out.println(bank.isCorrectString(bank.ggcList[0], 0, quests.user.getBonus()));
	if (bank.isCorrect(bank.ggcList[0], 0, quests.user.getBonus())) {
	  totalCredits++;
	}
	System.out.println("Current Score: " + totalCredits + " (this is cumulative for the purpose of this test)");
	input.nextLine();
	
	System.out.println("*** Testing correct answer for same question. ***");
	System.out.println("Entered Choice: " + bank.ggcList[0].getCorrectAnswer());
	System.out.println("Correct Choice: " + bank.ggcList[0].getCorrectAnswer());
	System.out.println(bank.isCorrectString(bank.ggcList[0], bank.ggcList[0].getCorrectAnswer(), quests.user.getBonus()));
	if (bank.isCorrect(bank.ggcList[0], bank.ggcList[0].getCorrectAnswer(), quests.user.getBonus())) {
	  totalCredits++;
	}
	System.out.println("Current Score: " + totalCredits);
	input.nextLine();
	
	System.out.println("*** Testing incorrect answer for same question, but with helper point. ***");
	quests.user.setBonus(2);
	System.out.println("Bonus Help Earned: " + quests.user.getBonus());
	input.nextLine();
	
	System.out.println("Entered Choice: 0");
	System.out.println("Correct Choice: " + bank.ggcList[0].getCorrectAnswer());
	System.out.println(bank.isCorrectString(bank.ggcList[0], 0, quests.user.getBonus()));
	if (bank.isCorrect(bank.ggcList[0], 0, quests.user.getBonus())) {
	  totalCredits++;
	}
	System.out.println("Current Score: " + totalCredits);
	input.nextLine();
	
	System.out.println("Bonus Help Earned (before): " + quests.user.getBonus());
	if (bank.usedHelp(bank.ggcList[0], 0, quests.user.getBonus())) {
	  quests.user.setBonus(quests.user.getBonus() - 1);
	}
	System.out.println("Bonus Help Earned (after): " + quests.user.getBonus());
	input.nextLine();
	
	System.out.println("*** All tests have been encountered. Please retrieve notes. Ending simulation. ***");
	
	input.close(); // Close the scanner.
	System.exit(0); // End the test.
  }
}

/* Author's Note:
 * - "user" object from "PuzzleEvents" class needs to transfer to main file after each action.
 * - Find a better way to decrement "bonus" variable.
 */