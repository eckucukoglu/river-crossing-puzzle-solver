/**
 * @author Emre Can Kucukoglu
 * 
 */
public class RCPuzzleGoalTest implements GoalTest {
	static final RCPuzzleState goal = new RCPuzzleState(new char[] {',', 'R', 'A', 'B', 'C', 'D', 'M', 'F', 'P', 'T'});

	public boolean isGoalState(Object state) {
		RCPuzzleState river = (RCPuzzleState) state;
		return river.equals(goal);
	}
}