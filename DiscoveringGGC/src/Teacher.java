/*
 *  Teacher - The enemies in the game Discovering GGC
 *  Description: Teachers ask the player questions, which are multiple choice
 *  Author: John Holcombe
 */
public class Teacher
{
	String teacherName; // this is the teachers name
	int teacherID; //this is an identifier for the teacher
	int spawnChance; //This is the percent chance that you will encounter this teacher
	int[] questionIDBank; //this is an array of possible questions that the teacher may ask 
	
	public void setTeacherName(String name) //A method to set the teachers name
	{
		teacherName = name;
	}
	
	public void setTeacherID(int ID) //A method to set the teachers ID number
	{
		teacherID = ID;
	}
	
	public void setSpawnChance(int chance) // a method to set the encounter chance of the teacher
	{
		spawnChance = chance;
	}
	
	public void setQuestionBank(int[] questionlist) //A method which sets the question back that the teacher can use
	{
		questionIDBank = questionlist;
	}
	
	public String getTeacherName(String name) //A method to get the teachers name
	{
		return teacherName;
	}
	
	public int getTeacherID(int ID) //A method to get the teachers ID number
	{
		return teacherID;
	}
	
	public int getSpawnChance(int chance) // a method to get the encounter chance of the teacher
	{
		return spawnChance;
	}
	
	public int[] getQuestionBank(int[] questionlist) //A method which gets the question back that the teacher can use
	{
		return questionIDBank;
	}
	
	
}
