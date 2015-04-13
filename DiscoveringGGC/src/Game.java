/**Class: Game
 * @author Nick Stough
 * @version 1.0
 * Course : Soft Dev
 * Written: Apr 7, 2015
 *
 * This class sets up the constructors for Game objects
 *
 * Purpose: The purpose is to gather information from the various game aspects
 * and output it to a Gui
 */

/**
 * @author Nick
 *
 */
public class Game
{
	//The four strings that will determine what pressing a button does.
	public String b1Results;
	public String b2Results;
	public String b3Results;
	public String b4Results;
	
	/**
	 * Default Game Constructor
	 */
	public Game(){
		this.b1Results = "";
		this.b2Results = "";
		this.b3Results = "";
		this.b4Results = "";
	}

	/**
	 * @return the b1Results
	 */
	public String getB1Results()
	{
		return b1Results;
	}

	/**
	 * @return the b2Results
	 */
	public String getB2Results()
	{
		return b2Results;
	}

	/**
	 * @return the b3Results
	 */
	public String getB3Results()
	{
		return b3Results;
	}

	/**
	 * @return the b4Results
	 */
	public String getB4Results()
	{
		return b4Results;
	}

	/**
	 * @param b1Results the b1Results to set
	 */
	public void setB1Results(String b1Results)
	{
		this.b1Results = b1Results;
	}

	/**
	 * @param b2Results the b2Results to set
	 */
	public void setB2Results(String b2Results)
	{
		this.b2Results = b2Results;
	}

	/**
	 * @param b3Results the b3Results to set
	 */
	public void setB3Results(String b3Results)
	{
		this.b3Results = b3Results;
	}

	/**
	 * @param b4Results the b4Results to set
	 */
	public void setB4Results(String b4Results)
	{
		this.b4Results = b4Results;
	}
	
	
	
	
}