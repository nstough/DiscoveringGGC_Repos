/* Title:       "Discovering GGC - QuestionBank"
 * Description: This class is designed to hold the different questions that can be asked in
 *              the game. Enemies in the game will ask questions from these banks. Each question
 *              will have 4 different answers, only one of which is correct.
 * Author:      Tim Nguyen
 * Version:     0.2 (April 9, 2015 @ 11:25 PM)
 */

public class QuestionBank {
  Question[] ggcList = new Question[5]; // Simple questions that ask about GGC
  Question[] easyList = new Question[5]; // Basic questions that are taught in early schooling.
  Question[] interList = new Question[5]; // Basic questions that are taught in early schooling.
  Question[] hardList = new Question[5]; // Basic questions that most elementary schoolers know.
  Question bonusQuestion = new Question("");
  
  // Base constructor to populate each array with questions and answers.
  public QuestionBank() {
	for (int i = 0; i < 5; i++) {
	  ggcList[i] = new Question();
	  easyList[i] = new Question();
	  interList[i] = new Question();
	  hardList[i] = new Question();
	}
	
	ggcList[0].setQuery("\"What is the name of this college?\"");
	ggcList[0].setAns1("Gwinnett Technical College");
	ggcList[0].setAns2("Georgia Technical College");
	ggcList[0].setAns3("Georgia Gwinnett College");
	ggcList[0].setAns4("University of Georgia");
	ggcList[0].setCorrectAnswer(3);
	
	ggcList[1].setQuery("\"Which building is the admission building?\"");
	ggcList[1].setAns1("A Building");
	ggcList[1].setAns2("B Building");
	ggcList[1].setAns3("C Building");
	ggcList[1].setAns4("D Building");
	ggcList[1].setCorrectAnswer(4);
	
	ggcList[2].setQuery("\"Where are the dormitories?\"");
	ggcList[2].setAns1("In the B Building");
	ggcList[2].setAns2("Behind the C Building");
	ggcList[2].setAns3("Past the Sports Field");
	ggcList[2].setAns4("We don't have any");
	ggcList[2].setCorrectAnswer(2);
	
	ggcList[3].setQuery("\"How many restaurants are in the A Building?\"");
	ggcList[3].setAns1("0");
	ggcList[3].setAns2("1");
	ggcList[3].setAns3("2");
	ggcList[3].setAns4("3");
	ggcList[3].setCorrectAnswer(2);
	
	ggcList[4].setQuery("\"What is another term that this college uses for their Student IDs?\"");
	ggcList[4].setAns1("Claw Card");
	ggcList[4].setAns2("Campus Pass");
	ggcList[4].setAns3("Grizzly Card");
	ggcList[4].setAns4("None of the Above");
	ggcList[4].setCorrectAnswer(1);
	
	easyList[0].setQuery("\"Sam has 5 tickets to a concert. If he sells each ticket for $2 and " +
            "keeps one for himself, how much money could Sam have?\"");
	easyList[0].setAns1("$4");
	easyList[0].setAns2("$6");
	easyList[0].setAns3("$8");
	easyList[0].setAns4("$10");
	easyList[0].setCorrectAnswer(3);

	easyList[1].setQuery("\"What year did the Declaration of Independence get signed?\"");
	easyList[1].setAns1("1770");
	easyList[1].setAns2("1780");
	easyList[1].setAns3("1774");
	easyList[1].setAns4("1776");
	easyList[1].setCorrectAnswer(4);

	easyList[2].setQuery("\"What punctuation is used to represent the end of a sentence?\"");
	easyList[2].setAns1("Comma (,)");
	easyList[2].setAns2("Quotation (\")");
	easyList[2].setAns3("Period (.)");
	easyList[2].setAns4("Asterick (*)");
	easyList[2].setCorrectAnswer(3);

	easyList[3].setQuery("\"Adam walks 3 miles West and then 4 miles East. Where is Adam in " +
	        "comparison to his starting location?\"");
	easyList[3].setAns1("2 miles West");
	easyList[3].setAns2("1 mile West");
	easyList[3].setAns3("1 mile East");
	easyList[3].setAns4("2 miles East");
	easyList[3].setCorrectAnswer(3);

	easyList[4].setQuery("\"Which of the following is not an input device for a computer?\"");
	easyList[4].setAns1("Monitor");
	easyList[4].setAns2("Mouse");
	easyList[4].setAns3("Keyboard");
	easyList[4].setAns4("Microphone");
	easyList[4].setCorrectAnswer(1);
	
	interList[0].setQuery("\"Michelle has 10 coins, which totals to $2. How many quarters does " +
	        "she have?\"");
	interList[0].setAns1("6");
	interList[0].setAns2("7");
	interList[0].setAns3("8");
	interList[0].setAns4("9");
	interList[0].setCorrectAnswer(2);
	
	interList[1].setQuery("\"Who was the first President of the United States?\"");
	interList[1].setAns1("John Adams");
	interList[1].setAns2("George Washington");
	interList[1].setAns3("James Madison");
	interList[1].setAns4("Thomas Jefferson");
	interList[1].setCorrectAnswer(2);
	
	interList[2].setQuery("\"Which of these is not a noun?\"");
	interList[2].setAns1("A Thing");
	interList[2].setAns2("A Place");
	interList[2].setAns3("An Action");
	interList[2].setAns4("A Person");
	interList[2].setCorrectAnswer(3);
	
	interList[3].setQuery("\"What is the 3rd planet from the sun?\"");
	interList[3].setAns1("Mars");
	interList[3].setAns2("Mercury");
	interList[3].setAns3("Venus");
	interList[3].setAns4("Earth");
	interList[3].setCorrectAnswer(4);
	
	interList[4].setQuery("\"Which of the following is not a major technology company?\"");
	interList[4].setAns1("Rubi");
	interList[4].setAns2("Microsoft");
	interList[4].setAns3("Google");
	interList[4].setAns4("IBM");
	interList[4].setCorrectAnswer(1);
	
	hardList[0].setQuery("\"Cindy has $10. If she loans half of it to her friend, who promises " +
			"to pay back double what was borrowed, how much will Cindy have when she gets " +
			"paid back?\"");
    hardList[0].setAns1("$10");
	hardList[0].setAns2("$15");
	hardList[0].setAns3("$20");
	hardList[0].setAns4("$25");
	hardList[0].setCorrectAnswer(2);
	
	hardList[1].setQuery("\"What continent is the country of France a part of?\"");
    hardList[1].setAns1("Asia");
	hardList[1].setAns2("Europe");
	hardList[1].setAns3("South America");
	hardList[1].setAns4("Antarctica");
	hardList[1].setCorrectAnswer(3);
	
	hardList[2].setQuery("\"What is another term for \"meat eater\"?\"");
    hardList[2].setAns1("Herbivore");
	hardList[2].setAns2("Omnivore");
	hardList[2].setAns3("Carnivore");
	hardList[2].setAns4("None of the Above");
	hardList[2].setCorrectAnswer(3);
	
	hardList[3].setQuery("\"What is the process in which a plant creates its source of food?\"");
    hardList[3].setAns1("Water Cycle");
	hardList[3].setAns2("Photosynthesis");
	hardList[3].setAns3("Pollination");
	hardList[3].setAns4("Energize");
	hardList[3].setCorrectAnswer(2);
	
	hardList[4].setQuery("\"Microsoft's virtual assistant, Cortana, is based on a fictional " +
			"intelligence from which of their games?\"");
    hardList[4].setAns1("Dungeon Siege");
	hardList[4].setAns2("Halo");
	hardList[4].setAns3("Fable");
	hardList[4].setAns4("Age of Emires");
	hardList[4].setCorrectAnswer(2);
	
	bonusQuestion.setQuery("\"Which of the following is not a programming language?\"");
	bonusQuestion.setAns1("Emerald");
	bonusQuestion.setAns2("Ruby");
	bonusQuestion.setAns3("Sapphire");
	bonusQuestion.setAns4("None of the Above");
	bonusQuestion.setCorrectAnswer(3);
  }
  
  // Method to check if the user choice for a question is right or wrong. True is right, false is wrong.
  public boolean isCorrect(Question query, int choice, int bonus) {
	if (query.getCorrectAnswer() == choice) {
	  return true;
	} else if (bonus > 0) {
	  return true;
	} else {
	  return false;
	}
  }
  
  // Method to print out whether the user is right or wrong.
  public String isCorrectString(Question query, int choice, int bonus) {
	if (query.getCorrectAnswer() == choice) {
	  return "You are correct.";
	} else if (bonus > 0) {
	  return "That help paid off.";
	} else {
	  return "You are incorrect.";
	}
  }
  
  // Method to check if one of the player's help points was used.
  public boolean usedHelp(Question query, int choice, int bonus) {
	if (query.getCorrectAnswer() != choice && bonus > 0) {
	  return true;
	} else {
	  return false;
	}
  }
}