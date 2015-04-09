/* Title:       "Discovering GGC - Question"
 * Description: This class is designed to list the details of the questions available in the
 *              game. Each question has a bank of 4 questions, only 1 of which is correct.
 * Author:      Tim Nguyen
 * Version:     0.1 (April 9, 2015 @ 12:15 PM)
 */

public class Question {
  private String query = ""; // Question that is to be asked.
  private String ans1 = ""; // One of the answers for the quesiton.
  private String ans2 = ""; // One of the answers for the quesiton.
  private String ans3 = ""; // One of the answers for the quesiton.
  private String ans4 = ""; // One of the answers for the quesiton.
  private int correctAnswer = 1; // Value to indicate the correct answer.
  
  // Base constructor to provide a question.
  public Question(String _query) {
	query = _query;
  }
  
  // Set-method to provide an answer.
  public void setAns1(String ans) {
	ans1 = ans; 
  }
  
  // Set-method to provide an answer.
  public void setAns2(Stirng ans) {
	ans2 = ans;
  }
  
  // Set-method to provide an answer.
  public void setAns3(Stirng ans) {
	ans3 = ans;
  }
  
  // Set-method to provide an answer.
  public void setAns4(Stirng ans) {
	ans4 = ans;
  }
  
  // Set-method to make a certain answer a correct answer.
  public void setCorrectAnswer(int val) {
	correctAnswer = val;
  }
  
  // Get-method to retrieve an answer.
  public String getAns1() {
	return ans1;
  }
  
  // Get-method to retrieve an answer.
  public String getAns2() {
	return ans2;
  }

  // Get-method to retrieve an answer.
  public String getAns3() {
	return ans3;
  }

  // Get-method to retrieve an answer.
  public String getAns4() {
	return ans4;
  }
  
  // Get-method to retrieve the correct answer value.
  public int getCorrectAnswer() {
	return correctAnswer;
  }
}