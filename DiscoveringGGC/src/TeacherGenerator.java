/*
 * Teacher generator creates all the teachers you can encounter in the game
 * Author: John Holcombe
 */



import java.util.ArrayList;


public class TeacherGenerator {
	
	ArrayList<Teacher> teachList = new ArrayList<Teacher>();
	
	Teacher CynthiaJohnson = new Teacher("Cynthia Johnson",0);
	Teacher VictoriaJohnson = new Teacher("Victoria Johnson",1);
	Teacher CathyMoore = new Teacher("Cathy Moore",2);
	Teacher DianeWhite = new Teacher("Diane White",3);
	Teacher AdolfoSantos = new Teacher("Adolfo Santos",4);
	Teacher TomMundie = new Teacher("Tom Mundie",5);
	Teacher JustinJernigan = new Teacher("Justin Jernigan",6);
	Teacher RolandoMarquez = new Teacher("Rolanda Marquez",7);
	Teacher President = new Teacher("President Stanlay Preczewski",8);
	
	public void createTeacherList() 
	{
		teachList.add(0,CynthiaJohnson);
		CynthiaJohnson.setReward(1);
		teachList.add(1,VictoriaJohnson);
		teachList.add(2,CathyMoore);
		teachList.add(3,DianeWhite);
		teachList.add(4,AdolfoSantos);
		teachList.add(5,TomMundie);
		TomMundie.setReward(6);
		teachList.add(6,JustinJernigan);
		teachList.add(7,RolandoMarquez);
		RolandoMarquez.setReward(10);
		teachList.add(8,President);
		CynthiaJohnson.setDialogue("Wants some extra credit? Answer me this:");
		VictoriaJohnson.setDialogue("Think you have what it takes to graduate?");
		CathyMoore.setDialogue("I CHALLENGE YOU WITH THIS QUESTION");
		DianeWhite .setDialogue("Are you smarter than a fifth grader?");
		AdolfoSantos.setDialogue("Want to be a millionare?");
		TomMundie.setDialogue("Answer me this and i'll let you have something");
		JustinJernigan.setDialogue("hgjfdhlkhsjfhfd?");
		RolandoMarquez.setDialogue("You can have this if you answer my question correctly");
		President.setDialogue("THIS ISN'T EVEN MY FINAL FORM");
	}
	public ArrayList<Teacher> getList() 
	{
		return teachList;
		
	}
	
}

