/*
 *  Teacher - The enemies in the game Discovering GGC
 *  Description: Teachers ask the player questions, which are multiple choice
 *  Author: John Holcombe
 */
public class Teacher
{
	String teacherName; // this is the teachers name
	int teacherID; //this is an identifier for the teacher 
	int reward; //This is the ItemID if the teacher gives a reward to the player
	String teacherDialogue = "";
	
	public Teacher(String name, int ID) {
		teacherName = name;
		teacherID = ID;
	
	}
	
	public void setTeacherName(String name) //A method to set the teachers name
	{
		teacherName = name;
	}
	
	public void setTeacherID(int ID) //A method to set the teachers ID number
	{
		teacherID = ID;
	}
	
	
	public String getTeacherName() //A method to get the teachers name
	{
		return teacherName;
	}
	
	public int getTeacherID() //A method to get the teachers ID number
	{
		return teacherID;
	}
	
	
	public void setReward (int item) // sets the reward to an item
	{
		reward = item;
	}
	
	public int getReward () // gets the item ID
	{
		return reward;
	}
	
	public void setDialogue(String s) //Teachers text when spoken to
	{
		teacherDialogue = s;
	}
	
	public String getDialogue() {
		return teacherDialogue;
	}
}
