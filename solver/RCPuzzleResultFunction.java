/**
 * @author Emre Can Kucukoglu
 * 
 */
public class RCPuzzleResultFunction implements ResultFunction {

	public RCPuzzleState result(Object s, Action a) {
		char[] river = new char[10];
		
		RCPuzzleState state = (RCPuzzleState) s;
		RCPuzzleAction action = (RCPuzzleAction) a;
		
		int countOfPassengers = 0;
		
		if (action.getPassenger1() != RCPuzzleState.UNKNOWN)
			countOfPassengers++;
		if (action.getPassenger2() != RCPuzzleState.UNKNOWN)
			countOfPassengers++;
		
		int leftIndexer = 0;
		int rightIndexer = 0;
		
		if (action.getDirection() == RCPuzzleAction.LEFT) {
			// Place the river.
			river[state.getRiverPosition() + (countOfPassengers + 1)] = RCPuzzleState.X;
			rightIndexer = state.getRiverPosition() + (countOfPassengers + 1);
			
			// Place the raft.
			river[state.getRiverPosition() + (countOfPassengers)] = RCPuzzleState.R;
			leftIndexer = state.getRiverPosition() + (countOfPassengers);
			
			// Place passenger 1 if exists.
			if (action.getPassenger1() != RCPuzzleState.UNKNOWN) {
				river[--leftIndexer] = action.getPassenger1();
			}
			// Place passenger 2 if exists.
			if (action.getPassenger2() != RCPuzzleState.UNKNOWN) {
				river[--leftIndexer] = action.getPassenger2();
			}
			
		} else {
			// Place the river.
			river[state.getRiverPosition() - (countOfPassengers + 1)] = RCPuzzleState.X;
			leftIndexer = state.getRiverPosition() - (countOfPassengers + 1);
			
			// Place the raft.
			river[state.getRiverPosition() - (countOfPassengers)] = RCPuzzleState.R;
			rightIndexer = state.getRiverPosition() - (countOfPassengers);
			
			// Place passenger 1 if exists.
			if (action.getPassenger1() != RCPuzzleState.UNKNOWN) {
				river[++rightIndexer] = action.getPassenger1();
			}
			// Place passenger 2 if exists.
			if (action.getPassenger2() != RCPuzzleState.UNKNOWN) {
				river[++rightIndexer] = action.getPassenger2();
			}
		}
		
		// Place father if not passenger.
		if ((action.getPassenger1() != RCPuzzleState.F) && (action.getPassenger2() != RCPuzzleState.F)) {
			if (state.getFatherPosition() < state.getRiverPosition())
				river[--leftIndexer] = RCPuzzleState.F;
			else
				river[++rightIndexer] = RCPuzzleState.F;
		}
		
		// Place mother if not passenger.
		if ((action.getPassenger1() != RCPuzzleState.M) && (action.getPassenger2() != RCPuzzleState.M)) {
			if (state.getMotherPosition() < state.getRiverPosition())
				river[--leftIndexer] = RCPuzzleState.M;
			else
				river[++rightIndexer] = RCPuzzleState.M;
		}
		
		// Place daughter 1 if not passenger.
		if ((action.getPassenger1() != RCPuzzleState.A) && (action.getPassenger2() != RCPuzzleState.A)) {
			if (state.getDaughter1Position() < state.getRiverPosition())
				river[--leftIndexer] = RCPuzzleState.A;
			else
				river[++rightIndexer] = RCPuzzleState.A;
		}
		
		// Place daughter 1 if not passenger.
		if ((action.getPassenger1() != RCPuzzleState.B) && (action.getPassenger2() != RCPuzzleState.B)) {
			if (state.getDaughter2Position() < state.getRiverPosition())
				river[--leftIndexer] = RCPuzzleState.B;
			else
				river[++rightIndexer] = RCPuzzleState.B;
		}
		
		// Place son 1 if not passenger.
		if ((action.getPassenger1() != RCPuzzleState.C) && (action.getPassenger2() != RCPuzzleState.C)) {
			if (state.getSon1Position() < state.getRiverPosition())
				river[--leftIndexer] = RCPuzzleState.C;
			else
				river[++rightIndexer] = RCPuzzleState.C;
		}
		
		// Place son 2 if not passenger.
		if ((action.getPassenger1() != RCPuzzleState.D) && (action.getPassenger2() != RCPuzzleState.D)) {
			if (state.getSon2Position() < state.getRiverPosition())
				river[--leftIndexer] = RCPuzzleState.D;
			else
				river[++rightIndexer] = RCPuzzleState.D;
		}
		
		// Place police if not passenger.
		if ((action.getPassenger1() != RCPuzzleState.P) && (action.getPassenger2() != RCPuzzleState.P)) {
			if (state.getPolicePosition() < state.getRiverPosition())
				river[--leftIndexer] = RCPuzzleState.P;
			else
				river[++rightIndexer] = RCPuzzleState.P;
		}
		
		// Place thief if not passenger.
		if ((action.getPassenger1() != RCPuzzleState.T) && (action.getPassenger2() != RCPuzzleState.T)) {
			if (state.getThiefPosition() < state.getRiverPosition())
				river[--leftIndexer] = RCPuzzleState.T;
			else
				river[++rightIndexer] = RCPuzzleState.T;
		}
		
		return new RCPuzzleState(river);
	}
}