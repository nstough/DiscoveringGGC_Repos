
public class DiscoveringGGC
{
	//The four strings that will determine what pressing a button does.
		public String b1Results;
		public String b2Results;
		public String b3Results;
		public String b4Results;
		
		//The display strings for the buttons
		public String b1Text;
		public String b2Text;
		public String b3Text;
		public String b4Text;
		
		/**
		 * Default Game Constructor
		 */
		public DiscoveringGGC(){
			this.b1Results = "";
			this.b2Results = "";
			this.b3Results = "";
			this.b4Results = "";
			
			this.b1Text = "";
			this.b2Text = "";
			this.b3Text = "";
			this.b4Text = "";
		}

		/**
		 * @return the b1Text
		 */
		public String getB1Text()
		{
			return b1Text;
		}

		/**
		 * @return the b2Text
		 */
		public String getB2Text()
		{
			return b2Text;
		}

		/**
		 * @return the b3Text
		 */
		public String getB3Text()
		{
			return b3Text;
		}

		/**
		 * @return the b4Text
		 */
		public String getB4Text()
		{
			return b4Text;
		}

		/**
		 * @param b1Text the b1Text to set
		 */
		public void setB1Text(String b1Text)
		{
			this.b1Text = b1Text;
		}

		/**
		 * @param b2Text the b2Text to set
		 */
		public void setB2Text(String b2Text)
		{
			this.b2Text = b2Text;
		}

		/**
		 * @param b3Text the b3Text to set
		 */
		public void setB3Text(String b3Text)
		{
			this.b3Text = b3Text;
		}

		/**
		 * @param b4Text the b4Text to set
		 */
		public void setB4Text(String b4Text)
		{
			this.b4Text = b4Text;
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
		
	
	public static void main(String[] args)
	{
		GameGui game = new GameGui();
		
	GameGui.launch(GameGui.class);
	
	
	
	FloorGenerator floor = new FloorGenerator(); 
	floor.layout();
	
	
	
	}
	
	


}
