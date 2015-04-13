/* Title:       "Discovering GGC - Question"
 * Description: This class is designed to list the details of the questions available in the
 *              game. Each question has a bank of 4 questions, only 1 of which is correct.
 * Author:      Tim Nguyen
 * Version:     0.2 (April 9, 2015 @ 11:25 PM)
 */

public class Question {
  private String query = ""; // Question that is to be asked.
  private String ans1 = ""; // One of the answers for the question.
  private String ans2 = ""; // One of the answers for the question.
  private String ans3 = ""; // One of the answers for the question.
  private String ans4 = ""; // One of the answers for the question.
  private int correctAnswer = 5; // Value to indicate the correct answer.
  private boolean used = false;
  
  // Base constructor to provide a blank question.
  public Question() {
	query = "";
  }
  
  // Specific constructor to provide a question.
  public Question(String _query) {
	query = _query;
  }
  
  // Set-method to provide a query.
  public void setQuery(String _query) {
	query = _query;
  }
  
  // Set-method to provide an answer.
  public void setAns1(String ans) {
	ans1 = ans; 
  }
  
  // Set-method to provide an answer.
  public void setAns2(String ans) {
	ans2 = ans;
  }
  
  // Set-method to provide an answer.
  public void setAns3(String ans) {
	ans3 = ans;
  }
  
  // Set-method to provide an answer.
  public void setAns4(String ans) {
	ans4 = ans;
  }
  
  // Set-method to make a certain answer a correct answer.
  public void setCorrectAnswer(int val) {
	correctAnswer = val;
  }
  
  // set-method to determine if the question is used.
  public void setUsed(boolean _used) {
	used = _used;
  }
  
  // Get-method to retrieve the query.
  public String getQuery() {
	return query;
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
  
  // Get-method to retrieve the correct answer value. (i.e. if correctAnswer = 3, ans3 is right)
  public int getCorrectAnswer() {
	return correctAnswer;
  }
  
  // Get-method to retrieve if the question is usable.
  public boolean getUsed() {
	return used;
  }
}