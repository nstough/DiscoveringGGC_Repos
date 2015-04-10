
public class TeacherTester {
	
	public static void main(String[]args)
	{
	Teacher test = new Teacher();
	int[] array = new int[4];
			array[0] = 1;
			array[1] = 2;
			array[2] = 3;
			array[3] = 4;
	test.setTeacherName("John");
	System.out.println(test.getTeacherName());
	test.setTeacherID(0);
	System.out.println(test.getTeacherID());
	test.setSpawnChance(50);
	System.out.println(test.getSpawnChance());
	test.setQuestionBank(array);
	System.out.println(test.getQuestionBank());
	test.setItemID(1);
	System.out.println(test.getItemID());

}
}
