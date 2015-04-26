import java.util.ArrayList;
import java.util.Random;

/*
 * Floor Generator - A way to generate a map of GGC in the game Discovering GGC
 * Description: Will have two ways to create the map. One with a set amount of rooms, another with a random amount. (within a limit)
 * It will also set the chances of each teacher and item appearing in the map. 
 * Author: John Holcombe
 * NOTE:This is a basic Floor generator. I may need to split this class into multiple. There is still the random generation which i need to 
 * finish. Comments are lessened due to them being redundant and cripples readability. Final class/classes will uphold better coding standards
 */

public class FloorGenerator
{
	
	ArrayList<Room> list = new ArrayList<Room>(); // an arraylist of all the rooms that the floor will create
	
	String admString = "The administration building. Finacial aid is available here" + "\n"; // administration building Description
	int[] admpaths = new int[2]; //administration bulding's path after the room is finished
	Room administrationBuilding = new Room(1,admString,admpaths,"Administration Building"); //method that creates the room 
		
	String gymString = "The Gym. College isn't just for exercising your brain"+ "\n"; 
	int[] gympaths = new int[2];
	Room gym = new Room(2,gymString,gympaths,"The Gym");
		
	String aBString = "The A-Building. There are many classrooms here. People seem to get lost in these hallways"+ "\n";
	int[] aBpaths = new int[2];
	Room aBuilding= new Room(3,aBString,aBpaths,"The A-Builfing");
	
	String aDString = "The A-Building Dining Hall. The lines are always long"+ "\n";
	int[] aDpaths = new int[2];
	Room aDiningHall= new Room(4,aDString,aDpaths,"The A-Building Dining Hall");
	
	String hString = "The H-Building. The newest building on campus."+ "\n";
	int[] hpaths = new int[2];
	Room hBuilding= new Room(5,hString,hpaths,"The H-Building");
	
	String lString = "The Library. Shhh, people are studying"+ "\n";
	int[] lpaths = new int[2];
	Room Library= new Room(6,lString,lpaths,"The Library");
	
	String aecString = "The Academic Enhancement Center. Here you can get some help if you are struggling"+ "\n";
	int[] aecpaths = new int[2];
	Room AEC= new Room(7,aecString,aecpaths,"The AEC");
	
	String cteString = "The Center of Teaching Excellence. This is where teachers go if they need help."+ "\n";
	int[] ctepaths = new int[2];
	Room CTE= new Room(8,cteString,ctepaths,"The CTE");
	
	String sCString = "The Student Center. This building has a dining hall and gaming room in the basement"+ "\n";
	int[] sCpaths = new int[2];
	Room studentCenter= new Room(9,sCString,sCpaths,"The Students Center");
	
	String cBString = "The C-Building. Easiest building to navigate"+ "\n";
	int[] cBpaths = new int[2];
	Room cBuilding = new Room(10,cBString,cBpaths,"The C-Building");
	
	String AudString = "The Auditorium. Extra credit activities are usually held here."+ "\n";
	int[] Audpaths = new int[2];
	Room Auditorium = new Room(11,AudString,Audpaths,"The Auditorium");
	
	String b1String = "B-Bulding's first floor. Some people love it, others avoid it at all cost."+ "\n";
	int[] b1paths = new int[2];
	Room bBuilding1stFloor= new Room(12,b1String,b1paths,"The B-Building's First Floor");
	
	String b2String = "B-Bulding's second floor. Classrooms and offices are on this floor"+ "\n";
	int[] b2paths = new int[2];
	Room bBuilding2ndFloor= new Room(13,b2String,b2paths,"The B-Building's Second Floor");
	
	String b3String = "B-Bulding's third floor. Many offices are on this floor"+ "\n";
	int[] b3paths = new int[2];
	Room bBuilding3rdFloor= new Room(14,b3String,b3paths,"The B-Building's Third Floor");
	
	String presString = "The Presidents Office. The Final Battle!"+ "\n";
	int[] end = new int[2];
	Room presidentsOffice = new Room(15,presString,end,"The Presidents Office");
		
		public void layout() // creates the GGC campus. It creates the rooms for the game and designates which rooms lead to another.
		{
			list.add(0,administrationBuilding); //adding the administration building
			admpaths[0] = 2; //add the administrations available paths
			admpaths[1] = 3;
			
			list.add(1,gym);
			gympaths[0] = 3;
			gympaths[1] = 4;
			
			list.add(2,aBuilding);
			aBpaths[0] = 4;
			aBpaths[1] = 5;
			
			list.add(3,aDiningHall);
			aDpaths[0] = 5;
			aDpaths[1] = 6;
			
			list.add(4,hBuilding);
			hpaths[0] = 6;
			hpaths[1] = 7;
			
			list.add(5,Library);
			lpaths[0] = 7;
			lpaths[1] = 8;
			
			list.add(6,AEC);
			aecpaths[0] = 8;
			aecpaths[1] = 9;
			
			list.add(7,CTE);
			ctepaths[0] = 9;
			ctepaths[1] = 10;
			
			list.add(8,studentCenter);
			sCpaths[0] = 10;
			sCpaths[1] = 11;
			
			list.add(9,cBuilding);
			cBpaths[0] = 11;
			cBpaths[1] = 12;
			
			list.add(10,Auditorium);
			Audpaths[0] = 12;
			Audpaths[1] = 12;

			list.add(11,bBuilding1stFloor);
			b1paths[0] = 13;
			b1paths[1] = 13;
			
			list.add(12,bBuilding2ndFloor);
			b2paths[0] = 14;
			b2paths[1] = 14;
			
			list.add(13,bBuilding3rdFloor);
			b3paths[0] = 15;
			b3paths[1] = 15;
			
			list.add(14,presidentsOffice);
			end[0] = 15;
			end[1] = 15;
		}
		
//		public void layout(Random random) //Creates a GGC campus with more random elements.
//		{
//			will create when the team connects the pieces of the project
//		}
		public ArrayList<Room> getList() 
		{
			return list;
			
		}
		

		public void printList() //prints the location list for testing
		{
			for(int i = 0; i<list.size();i++)
			{
				System.out.println(list.get(i).getRoomInfo());
			}
}
}
