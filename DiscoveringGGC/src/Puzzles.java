/* Title:       "Discovering GGC - Puzzles Class"
 * Description: This class is designed to hold the base values of the puzzles that the player
 *              will encounter. Each puzzle will have their own ID, as well as toggles as to
 *              whether they have been encountered, completed, and succeeded.
 * Author:      Tim Nguyen
 * Version:     0.2 (April 9, 2015 @ 11:25 PM)
 */

public class Puzzles {
  private int puzzleID; // The unique ID of the puzzle.
  private String puzzleLocation = "null"; // Value to indicate the location of the puzzle.
  private boolean isAvailable = false; // Value to indicate if the puzzle is available.
  private boolean isCompleted = false; // Value to indicate if the puzzle is completed.
  
  // Base constructor for a puzzle event.
  public Puzzles (int _puzzleID, String _puzzleLocation) {
	puzzleID = _puzzleID;
	puzzleLocation = _puzzleLocation;
  }
  
  // Set-Method for the puzzle ID.
  public void setPuzzleID(int _puzzleID) {
	puzzleID = _puzzleID;
  }
  
  // Set-Method for the puzzle's location.
  public void setPuzzleLocation(String _puzzleLocation) {
	puzzleLocation = _puzzleLocation;
  }
  
  // Set-Method for if the puzzle is available.
  public void setIsAvailable(boolean _isAvailable) {
	isAvailable = _isAvailable;
  }
  
  // Set-Method for if the puzzle is completed.
  public void setIsCompleted(boolean _isCompleted) {
	isCompleted = _isCompleted;
  }
  
  // Get-Method to obtain the puzzle ID.
  public int getPuzzleID() {
	return puzzleID;
  }
  
  // Get-Method to obtain the puzzle's location.
  public String getPuzzleLocation() {
	return puzzleLocation;
  }
  
  // Get-Method to obtain if the puzzle is available.
  public boolean getIsAvailable() {
	return isAvailable;
  }
  
  // Get-Method to obtain if the puzzle is completed.
  public boolean getIsCompleted() {
	return isCompleted;
  }
}
