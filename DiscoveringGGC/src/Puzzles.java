/* Title:       "Discovering GGC - Puzzles Class"
 * Description: This class is designed to hold the base values of the puzzles that the player
 *              will encounter. Each puzzle will have their own ID, as well as toggles as to
 *              whether they have been encountered, completed, and succeeded.
 * Author:      Tim Nguyen
 * Version:     0.2 (April 9, 2015 @ 11:25 PM)
 */

public class Puzzles {
  private int puzzleID; // The unique ID of the puzzle.
  private boolean isAvailable = false; // Value to indicate if the puzzle is available.
  private boolean isActive = false;  // Value to indicate if the puzzle is currently in-use.
  private boolean isCompleted = false; // Value to indicate if the puzzle is completed.
  
  // Base constructor for a puzzle event.
  public Puzzles (int puzzleID) {
	this.puzzleID = puzzleID;
  }
  
  // Set-Method for the puzzle ID.
  public void setPuzzleID(int puzzleID) {
	this.puzzleID = puzzleID;
  }
  
  // Set-Method for if the puzzle is available.
  public void setIsAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
  }
  
  // Set-Method for if the puzzle is currently in-use.
  public void setIsActive(boolean isActive) {
	this.isActive = isActive;
  }
  
  // Set-Method for if the puzzle is completed.
  public void setIsCompleted(boolean isCompleted) {
	this.isCompleted = isCompleted;
  }
  
  // Get-Method to obtain the puzzle ID.
  public int getPuzzleID() {
	return puzzleID;
  }
  
  // Get-Method to obtain if the puzzle is available.
  public boolean getIsAvailable() {
	return isAvailable;
  }
  
  // Get-Method to obtain if the puzzle is currently in-use.
  public boolean getIsActive() {
	return isActive;
  }
  
  // Get-Method to obtain if the puzzle is completed.
  public boolean getIsCompleted() {
	return isCompleted;
  }
}
