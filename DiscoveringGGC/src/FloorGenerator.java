import java.util.ArrayList;
import java.util.Random;

/*
 * Floor Generator - A way to generate a map of GGC in the game Discovering GGC
 * Description: Will have two ways to create the map. One with a set amount of rooms, another with a random amount. (within a limit)
 * It will also set the chances of each teacher and item appearing in the map. 
 * Author: John Holcombe
 */
public class FloorGenerator
{
	
	ArrayList<Room> list = new ArrayList<Room>(); // an arraylist of all the rooms that the floor will create
	String admString = "The administration building. Finacial aid is available here";
	int[] admnext = new int[4];
	
		Room adminisrationBuilding = new Room(1,admString,admnext);
		Room gym = new Room(2);
		Room aBuilding= new Room(3);
		Room aDiningHall= new Room(4);
		Room hBuilding= new Room(5);
		Room Library= new Room(6);
		Room AEC= new Room(7);
		Room CTE= new Room(8);
		Room studentCenter= new Room(9);
		Room cBuilding = new Room(10);
		Room Auditorium = new Room(11);
		Room bBuilding1stFloor= new Room(12);
		Room bBuilding2ndFloor= new Room(13);
		Room bBuilding3rdFloor= new Room(14);
		Room presidentsOffice = new Room(15);
		
		public void layout() // creates the GGC campus. It creates the rooms for the game and designates which rooms lead to another.
		{
			list.add(0,adminisrationBuilding);
			list.add(1,gym);
			admnext[0] = 2;
			admnext[1] = 3;
			admnext[2] = 4;
			admnext[3] = 5;
		}
		
		public void layout(Random random) //Creates a GGC campus with more random elements.
		{
			
		}
		
		

		public void printList()
		{
			for(int i = 0; i<list.size();i++)
			{
				System.out.println(list.get(i).getRoomInfo());
			}
}
}
