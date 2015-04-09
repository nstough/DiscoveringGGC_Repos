/* Title:       "Discovering GGC - Items Class"
 * Description: This class is designed to hold the different items available in the game. Each
 *              item will have their own ID, which assigns a specific name.
 * Author:      Tim Nguyen
 * Version:     0.1 (April 6, 2015 @ 11:42 AM)
 */

public class Items {
  private int itemID;
  
  // Base constructor for an item.  
  public Items() {
    itemID = 0;
  }
  
  // Base constructor for a specific item.
  public Items(int _itemID) {
	itemID = _itemID;
  }
  
  // Set-Method to set an item's ID.
  public void setID(int _itemID) {
	itemID = _itemID;
  }
  
  // Get-Method to retrieve item's ID.
  public int getID() {
	return itemID;
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
	  case 10: name = "One Dollar";
	           break;
	  case 11: name = "Carl's Phone";
	           break;
	  default: name = "null";
	           break;
	}
	
	return name;
  }
}