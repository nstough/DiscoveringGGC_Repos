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
	int roomID; //This is the room id so that we know which room the player is in.
	int[] puzzles; //This is a list of possible puzzles in this room
	int[] teachers; // this is a list of possible teachers
	int[] adjacentRooms; //This is an array of rooms that the player may enter from this room
	Random random = new Random();
	
	public String getRoomDescription() //method allowing the room description to be given to the player
	{
		return roomDes;
	}
	
	public boolean encounterTeacher(int chance, boolean hasMet) //chance to encounter the teacher and a method to check if you run into them
	{
		if( (chance >= random.nextInt(100) + 1) && hasMet == false) //if statement to roll your chance
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean encounterPuzzle(int chance, boolean hasFound) //chance to encounter a puzzle if you did not encounter a teacher
	{
		if( (chance >= random.nextInt(100) + 1) && hasFound == false) //if statement to roll your chance
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

	public Room(int ID,String des,int[] nextRooms) //Room generator. not much else to say
	{
		roomDes = des;
		roomID = ID;
		adjacentRooms = nextRooms;
	
	}
		
	public String getRoomInfo() //Method that gives the room information is string form
	{
	return (roomDes + "\n" + roomID);
	}

	public void setPuzzles(int[] puzzlelist) //need team members piece to flesh out
	{
	puzzles = puzzlelist;
	}

	public void setTeachers(int[] teacherlist) //Method to set the possible teachers
	{
	teachers = teacherlist;
	}

}
