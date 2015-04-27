/*
 * Room - The class that creates a room in the game Discovering GGC
 * Description: Rooms can have teachers, items, or puzzles. Rooms will be real locations at GGC
 * Author: John Holcombe 
 */
import java.util.Random; //needed to handle the random chance of encountering a teacher.

public class Room 
{
	//Ryan was here
	String roomDes; //This is the description of the room. The player will read it when he/she enters the room
	String roomName; // Names the room
	int roomID; //This is the room id so that we know which room the player is in.
	int puzzle = -1; //ID of the puzzle that is located in the room.
	int teacher = -1; //ID of the teacher that is located in the room.
	int[] adjacentRooms; //This is an array of rooms that the player may enter from this room
	Random random = new Random();
	boolean hasEntered = false; //value of whether the room has been entered
	boolean hasCleared = false; //value of whether the room has been cleared
	
	public String getRoomDescription() //method allowing the room description to be given to the player
	{
		return roomDes;
	}
	public String getRoomName() {
		return roomName;
		
	}
	
	public int getRoomID() {
		return roomID;
	}

	public Room(int ID,String des,int[] nextRooms,String name) //Room generator. not much else to say
	{
		roomDes = des;
		roomID = ID;
		adjacentRooms = nextRooms;
		roomName = name;
	
	}
		
	public String getRoomInfo() //Method that gives the room information is string form
	{
	return (roomDes + "\n" + roomID);
	}
	
	public void setPuzzle(int id) {
	  if (teacher == -1 && !hasEntered) {
		puzzle = id;
	  }
	}
	
	public void setTeacher(int id) {
	  if (puzzle == -1 && !hasEntered) {
		teacher = id;
	  }
	}
	
	public void setHasEntered(boolean entered) {
		hasEntered = entered;
	}
	
	public void setHasCleared(boolean cleared) {
		hasCleared = cleared;
	}
	
	public boolean getHasEntered() {
		return hasEntered;
	}
	
	public boolean getHasCleared() {
		return hasCleared;
	}
}
