/*
 * Room - The class that creates a room in the game Discovering GGC
 * Description: Rooms can have teachers, items, or puzzles. Rooms will be real locations at GGC
 * Author: John Holcombe 
 */
public class Room 
{
	String roomDes; //This is the description of the room. The player will read it when he/she enters the room
	int roomID; //This is the room id so that we know which room the player is in.
	int[] ajacentRooms; //This is an array of rooms that the player may enter from this room
	
	public String getRoomDescription()
	{
		return roomDes;
	}
	
}
