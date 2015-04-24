/* Title:       "Discovering GGC - QuestionBank"
 * Description: This class is designed to hold the different questions that can be asked in
 *              the game. Enemies in the game will ask questions from these banks. Each question
 *              will have 4 different answers, only one of which is correct.
 * Author:      Tim Nguyen
 * Version:     0.2 (April 9, 2015 @ 11:25 PM)
 */

public class QuestionBank {
  Question[] list = new Question[21]; // list of questions
  
  // Base constructor to populate each array with questions and answers.
  public QuestionBank() {
	for (int i = 0; i < list.length; i++) {
	  list[i] = new Question();
	}
	
	list[0].setQuery("\"What is the name of this college?\"");
	list[0].setAns1("Gwinnett Technical College");
	list[0].setAns2("Georgia Technical College");
	list[0].setAns3("Georgia Gwinnett College");
	list[0].setAns4("University of Georgia");
	list[0].setCorrectAnswer(3);
	
	list[1].setQuery("\"Which building is the admission building?\"");
	list[1].setAns1("A Building");
	list[1].setAns2("B Building");
	list[1].setAns3("C Building");
	list[1].setAns4("D Building");
	list[1].setCorrectAnswer(4);
	
	list[2].setQuery("\"Where are the dormitories?\"");
	list[2].setAns1("In the B Building");
	list[2].setAns2("Behind the C Building");
	list[2].setAns3("Past the Sports Field");
	list[2].setAns4("We don't have any");
	list[2].setCorrectAnswer(2);
	
	list[3].setQuery("\"How many restaurants are in the A Building?\"");
	list[3].setAns1("0");
	list[3].setAns2("1");
	list[3].setAns3("2");
	list[3].setAns4("3");
	list[3].setCorrectAnswer(2);
	
	list[4].setQuery("\"What is another term that this college uses for their Student IDs?\"");
	list[4].setAns1("Claw Card");
	list[4].setAns2("Campus Pass");
	list[4].setAns3("Grizzly Card");
	list[4].setAns4("None of the Above");
	list[4].setCorrectAnswer(1);
	
	list[5].setQuery("\"Sam has 5 tickets to a concert. If he sells each ticket for $2 and " +
            "keeps one for himself, how much money could Sam have?\"");
	list[5].setAns1("$4");
	list[5].setAns2("$6");
	list[5].setAns3("$8");
	list[5].setAns4("$10");
	list[5].setCorrectAnswer(3);

	list[6].setQuery("\"What year did the Declaration of Independence get signed?\"");
	list[6].setAns1("1770");
	list[6].setAns2("1780");
	list[6].setAns3("1774");
	list[6].setAns4("1776");
	list[6].setCorrectAnswer(4);

	list[7].setQuery("\"What punctuation is used to represent the end of a sentence?\"");
	list[7].setAns1("Comma (,)");
	list[7].setAns2("Quotation (\")");
	list[7].setAns3("Period (.)");
	list[7].setAns4("Asterick (*)");
	list[7].setCorrectAnswer(3);

	list[8].setQuery("\"Adam walks 3 miles West and then 4 miles East. Where is Adam in " +
	        "comparison to his starting location?\"");
	list[8].setAns1("2 miles West");
	list[8].setAns2("1 mile West");
	list[8].setAns3("1 mile East");
	list[8].setAns4("2 miles East");
	list[8].setCorrectAnswer(3);

	list[9].setQuery("\"Which of the following is not an input device for a computer?\"");
	list[9].setAns1("Monitor");
	list[9].setAns2("Mouse");
	list[9].setAns3("Keyboard");
	list[9].setAns4("Microphone");
	list[9].setCorrectAnswer(1);
	
	list[10].setQuery("\"Michelle has 10 coins, which totals to $2. How many quarters does " +
	        "she have?\"");
	list[10].setAns1("6");
	list[10].setAns2("7");
	list[10].setAns3("8");
	list[10].setAns4("9");
	list[10].setCorrectAnswer(2);
	
	list[11].setQuery("\"Who was the first President of the United States?\"");
	list[11].setAns1("John Adams");
	list[11].setAns2("George Washington");
	list[11].setAns3("James Madison");
	list[11].setAns4("Thomas Jefferson");
	list[11].setCorrectAnswer(2);
	
	list[12].setQuery("\"Which of these is not a noun?\"");
	list[12].setAns1("A Thing");
	list[12].setAns2("A Place");
	list[12].setAns3("An Action");
	list[12].setAns4("A Person");
	list[12].setCorrectAnswer(3);
	
	list[13].setQuery("\"What is the 3rd planet from the sun?\"");
	list[13].setAns1("Mars");
	list[13].setAns2("Mercury");
	list[13].setAns3("Venus");
	list[13].setAns4("Earth");
	list[13].setCorrectAnswer(4);
	
	list[14].setQuery("\"Which of the following is not a major technology company?\"");
	list[14].setAns1("Rubi");
	list[14].setAns2("Microsoft");
	list[14].setAns3("Google");
	list[14].setAns4("IBM");
	list[14].setCorrectAnswer(1);
	
	list[15].setQuery("\"Cindy has $10. If she loans half of it to her friend, who promises " +
			"to pay back double what was borrowed, how much will Cindy have when she gets " +
			"paid back?\"");
    list[15].setAns1("$10");
	list[15].setAns2("$15");
	list[15].setAns3("$20");
	list[15].setAns4("$25");
	list[15].setCorrectAnswer(2);
	
	list[16].setQuery("\"What continent is the country of France a part of?\"");
    list[16].setAns1("Asia");
	list[16].setAns2("Europe");
	list[16].setAns3("South America");
	list[16].setAns4("Antarctica");
	list[16].setCorrectAnswer(3);
	
	list[17].setQuery("\"What is another term for \"meat eater\"?\"");
    list[17].setAns1("Herbivore");
	list[17].setAns2("Omnivore");
	list[17].setAns3("Carnivore");
	list[17].setAns4("None of the Above");
	list[17].setCorrectAnswer(3);
	
	list[18].setQuery("\"What is the process in which a plant creates its source of food?\"");
    list[18].setAns1("Water Cycle");
	list[18].setAns2("Photosynthesis");
	list[18].setAns3("Pollination");
	list[18].setAns4("Energize");
	list[18].setCorrectAnswer(2);
	
	list[19].setQuery("\"Microsoft's virtual assistant, Cortana, is based on a fictional " +
			"intelligence from which of their games?\"");
    list[19].setAns1("Dungeon Siege");
	list[19].setAns2("Halo");
	list[19].setAns3("Fable");
	list[19].setAns4("Age of Emires");
	list[19].setCorrectAnswer(2);
	
	list[20].setQuery("\"Which of the following is not a programming language?\"");
	list[20].setAns1("Emerald");
	list[20].setAns2("Ruby");
	list[20].setAns3("Sapphire");
	list[20].setAns4("None of the Above");
	list[20].setCorrectAnswer(3);
  }
  
  // Get-Method to retrieve the list array.
  public Question[] getList() {
	return list;
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