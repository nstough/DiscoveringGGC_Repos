/* Title:       "Discovering GGC - Items Class"
 * Description: This class is designed to hold the different items available in the game. Each
 *              item will have their own ID, which assigns a specific name.
 * Author:      Tim Nguyen
 * Version:     0.2 (April 9, 2015 @ 11:25 PM)
 */

public class Items {
  private int itemID = 0;
  private int questID = 0;
  
  // Base constructor for an item.  
  public Items() {
    itemID = 0;
    questID = 0;
  }
  
  // Base constructor for a specific item.
  public Items(int itemID) {
	this.itemID = itemID;
  }
  
  // Set-Method to set an item's ID.
  public void setID(int itemID) {
	this.itemID = itemID;
  }
  
  // Set-Method to set an item's quest ID.
  public void setQuestID() {
	switch(itemID) {
	  case  1: questID = 1;
		       break;
	  case  2: questID = 3;
	           break;
	  case  3: questID = 2;
	           break;
	  case  4: questID = 4;
	           break;
	  case  5: questID = 5;
	           break;
	  case  6: questID = 6;
	           break;
	  case  7: questID = 8;
	           break;
	  case  8: questID = 7;
	           break;
	  case  9: questID = 9;
	           break;
	  case 10: questID = 10;
	           break;
	  default: break;
	}
  }
  
  // Get-Method to retrieve item's ID.
  public int getID() {
	return itemID;
  }
  
  // Get-Method to retrieve the item's quest ID.
  public int getQuestID() {
	return questID;
  }
  
  // Populating the available Item IDs with names.
  public String getItemName() {
	String name = "";
	
	switch(itemID) {
	  case 1:  name = "Michael's Binder";
	           break;
	  case 2:  name = "Scantron";
	           break;
	  case 3:  name = "Dining Hall Coupon";
	           break;
	  case 4:  name = "Ren's Claw Card";
	           break;
	  case 5:  name = "Blue Umbrella";
	           break;
	  case 6:  name = "Bottle of Water";
	           break;
	  case 7:  name = "Chicken Sandwich";
	           break;
	  case 8:  name = "Tutor's Business Card";
	           break;
	  case 9:  name = "Pack of Gum";
	           break;
	  case 10: name = "Carl's Phone";
	           break;
	  default: name = "==EMPTY==";
	           break;
	}
	
	return name;
  }
}
