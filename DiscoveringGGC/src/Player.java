/* Title:       "Discovering GGC - Player Class"
 * Description: This class is designed to hold the methods of the player's held items. It allows
 *              the player to add, remove, or display their inventory.
 * Author:      Tim Nguyen
 * Version:     0.2 (April 9, 2015 @ 11:25 PM)
 */

import java.util.ArrayList;

public class Player {
  private static ArrayList<Items> inventory = new ArrayList<Items>();
  private final int MAX_INVENTORY_SIZE = 4;
  private static int bonus = 0; // "Free Miss"
  
  // Base constructor for the Player class, which allows the inventory to be properly populated
  // as empty.
  public Player() {
	for (int i = 0; i < MAX_INVENTORY_SIZE; i++) {
	  inventory.add(new Items());
	}
  }
  
  // Complex constructor to which the variables are set to copy a pre-defined player-object.
  public Player(Player player) {
	inventory = player.getInventory();
	bonus = player.getBonus();
  }
  
  // Set-method to set the inventory to a pre-defined list.
  public void setInventory(ArrayList<Items> inventory) {
	this.inventory = inventory;
  }
  
  // Set-method to set the number of bonus credits.
  public static void setBonus(int _bonus) {
	bonus = _bonus;
  }
  
  // Get-method to retrieve the full detail of the player.
  public Player getPlayer() {
	Player user = new Player();
	
	user.inventory = this.inventory;
	user.bonus = this.bonus;
	
	return user;
  }
  
  // Get-method to retrieve the inventory.
  public static ArrayList<Items> getInventory() {
	return inventory;
  }
  
  // Get-method to retrieve the maximum inventory size.
  public int getMaxInventorySize() {
	return MAX_INVENTORY_SIZE;
  }
  
  // Get-method to retrieve the number of bonus credits.
  public static int getBonus() {
	return bonus;
  }
  
  // Method to add an item to the player's inventory.
  public void addItem(int ID) {
	boolean add = false;
	
	// For-Loop to check each available slot in the player's inventory.
	for (int i = 0; i < MAX_INVENTORY_SIZE && i < inventory.size(); i++) {
	  if (inventory.get(i).getID() == 0) {
		inventory.get(i).setID(ID);
		add = true;
		GameGui.ta.appendText(inventory.get(i).getItemName() + " added to inventory.\n=====\n");
		break;
	  }
	}
	
	// Displays a message if whether the item is added or not.
	if (!add) {
	  GameGui.ta.appendText("Cannot add item to inventory. Inventory full.\n=====\n");
	}
  }
  
  // Method to remove an item from the player's inventory.
  public static void removeItem(int index) {
	inventory.get(index - 1).setID(0);
	
	GameGui.ta.appendText("Item has been disposed.\n=====\n");
  }
  
  // Method to display the player's inventory.
  public void displayInventory() {
	for (int i = 0; i < MAX_INVENTORY_SIZE; i++) {
	  System.out.print("Slot " + (i + 1) + " - ");
	  if (inventory.get(i).getID() > 0) {
		GameGui.ta.appendText(inventory.get(i).getItemName() + "\n");
	  } else {
		GameGui.ta.appendText("==EMPTY==\n");
	  }
	}
	GameGui.ta.appendText("=====\n");
  }
}
