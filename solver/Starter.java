import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Starter {
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Filepath needed.");
			return;
		}
		
		String filepath = args[0];
		
		try {
			RCPuzzleState initialState = new RCPuzzleState(analyzeFile(filepath));
			RCPuzzleActionsFunction actionsFunction = new RCPuzzleActionsFunction();
			RCPuzzleResultFunction resultFunction = new RCPuzzleResultFunction();
			RCPuzzleGoalTest goalTest = new RCPuzzleGoalTest();
			
			// Generate problem
			Problem rcpuzzle = new Problem(initialState, actionsFunction, resultFunction, goalTest);
			// Search with breadth first search and store list of actions
			BreadthFirstSearch bfs = new BreadthFirstSearch();
			List<Action> actions = bfs.search(rcpuzzle);
			
			// Check No Solution case
			if (actions.size() == 0) {
				System.out.println("No solution exists.");
				System.out.println(bfs.getMetrics().toString());
			} else {
				RCPuzzlePrinter printer = new RCPuzzlePrinter("Solution.txt");
				
				RCPuzzleState tempState = initialState.clone();
				printer.printToFile(tempState.toString() + "\n" + "\n", false);
				printer.printToFile(String.valueOf(actions.size()) + "\n", true);
				for (Action element : actions) {
					tempState = (resultFunction.result(tempState, element)).clone();
					printer.printToFile(tempState.toString() + "\n", true);
				}
				System.out.println("Optimal solution found.");
				System.out.println(bfs.getMetrics().toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open and read the input file and return char array for given notation.
	 * Example content: "MABPTRFCD,"
	 */
	public static char[] analyzeFile(String filepath) throws IOException {
		char[] river = new char[10];
		int riverIndex = 0;
		
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String line = null;
		while ((line = reader.readLine()) != null) {
			int length = line.length();
			
			//	Copy String to char array
			char[] _line = new char[length];
			line.getChars(0, length, _line, 0);
			
		    for (int i = 0; i < length; i++) {
		    	if (_line[i] != '\n' && _line[i] != ' ' && _line[i] != '\t')
		    		river[riverIndex++] = _line[i];
		    }
		}
		
		if (riverIndex != 10)
			return null;
		
		return river;
	}
}
