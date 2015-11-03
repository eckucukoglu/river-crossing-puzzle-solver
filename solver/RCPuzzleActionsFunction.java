import java.util.HashSet;
import java.util.Set;


/**
 * @author Emre Can Kucukoglu
 * 
 */
public class RCPuzzleActionsFunction implements ActionsFunction {

	public Set<Action> actions(Object s) {
		Set<Action> actions = new HashSet<Action>();
		
		RCPuzzleState state = (RCPuzzleState) s;
		
		boolean leftRaft = state.getRaftPosition() < state.getRiverPosition();
		boolean leftMother = state.getMotherPosition() < state.getRiverPosition();
		boolean leftFather = state.getFatherPosition() < state.getRiverPosition();
		boolean leftPolice = state.getPolicePosition() < state.getRiverPosition();
		
		boolean leftSon1 = state.getSon1Position() < state.getRiverPosition();
		boolean leftSon2 = state.getSon2Position() < state.getRiverPosition();
		boolean leftDaughter1 = state.getDaughter1Position() < state.getRiverPosition();
		boolean leftDaughter2 = state.getDaughter2Position() < state.getRiverPosition();
		boolean leftThief = state.getThiefPosition() < state.getRiverPosition();
				
		if (leftRaft) {
			if (leftMother && leftFather) {
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.F, RCPuzzleAction.RIGHT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			if (leftMother && leftPolice) {
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.P, RCPuzzleAction.RIGHT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			if (leftPolice && leftFather) {
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.F, RCPuzzleAction.RIGHT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			
			if (leftMother) {
				if (leftSon1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.C, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (leftSon2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.D, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (leftDaughter1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.A, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);		
				}
				if (leftDaughter2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.B, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.UNKNOWN, RCPuzzleAction.RIGHT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			
			if (leftFather) {
				if (leftSon1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.F, RCPuzzleState.C, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (leftSon2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.F, RCPuzzleState.D, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (leftDaughter1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.F, RCPuzzleState.A, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);			
				}
				if (leftDaughter2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.F, RCPuzzleState.B, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.F, RCPuzzleState.UNKNOWN, RCPuzzleAction.RIGHT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			
			if (leftPolice) {
				if (leftSon1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.C, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (leftSon2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.D, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (leftDaughter1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.A, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);		
				}
				if (leftDaughter2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.B, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (leftThief) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.T, RCPuzzleAction.RIGHT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.UNKNOWN, RCPuzzleAction.RIGHT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			
			
		} else { // raft is on the right side
			if ((!leftMother) && (!leftFather)) {
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.F, RCPuzzleAction.LEFT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			if ((!leftMother) && (!leftPolice)) {
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.P, RCPuzzleAction.LEFT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			if ((!leftPolice) && (!leftFather)) {
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.F, RCPuzzleAction.LEFT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			
			
			if (!leftMother) {
				if (!leftSon1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.C, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (!leftSon2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.D, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (!leftDaughter1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.A, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);			
				}
				if (!leftDaughter2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.B, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.M, RCPuzzleState.UNKNOWN, RCPuzzleAction.LEFT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			
			if (!leftFather) {
				if (!leftSon1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.F, RCPuzzleState.C, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (!leftSon2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.F, RCPuzzleState.D, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (!leftDaughter1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.F, RCPuzzleState.A, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);			
				}
				if (!leftDaughter2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.F, RCPuzzleState.B, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.F, RCPuzzleState.UNKNOWN, RCPuzzleAction.LEFT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			
			if (!leftPolice) {
				if (!leftSon1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.C, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (!leftSon2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.D, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (!leftDaughter1) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.A, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);			
				}
				if (!leftDaughter2) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.B, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				if (!leftThief) {
					RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.T, RCPuzzleAction.LEFT);
					if (checkResultantStateValidity(state, action))
						actions.add(action);
				}
				RCPuzzleAction action = new RCPuzzleAction(RCPuzzleState.P, RCPuzzleState.UNKNOWN, RCPuzzleAction.LEFT);
				if (checkResultantStateValidity(state, action))
					actions.add(action);
			}
			
			
		}
		
		// Return only applicable actions. 
		// i.e. Mother or Father and Thief can't ride the boat same time.
		return actions;
	}
	
	public boolean checkResultantStateValidity (RCPuzzleState state, RCPuzzleAction action) {
		RCPuzzleResultFunction resultFunction = new RCPuzzleResultFunction();
		
		return (resultFunction.result(state, action)).isValidState();		
	}
}