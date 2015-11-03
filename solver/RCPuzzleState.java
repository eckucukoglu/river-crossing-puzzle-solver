import java.util.Arrays;

/**
 * River Crossing Puzzle state implementation
 * 
 * @author Emre Can Kucukoglu
 * 
 */
public class RCPuzzleState implements Cloneable {
	//	Daughters
	public static final char A = 'A';
	public static final char B = 'B';
	//	Sons
	public static final char C = 'C';
	public static final char D = 'D';
	//	Mother
	public static final char M = 'M';
	//	Father
	public static final char F = 'F';
	//	Policeman
	public static final char P = 'P';
	//	Thief
	public static final char T = 'T';
	//	Raft
	public static final char R = 'R';
	//	River
	public static final char X = ',';
	//	Unknown
	public static final char UNKNOWN = 'U';

	/**
	 * From left to right, positions of people and the raft.
	 */
	private char[] river = new char[] { UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN,
			UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN };

	public RCPuzzleState(char[] _river) {
		for (int i = 0; i < 10; i++) {
			river[i] = _river[i];
		};
		
	}

	/**
	 * Checks that this state is proper for game rules.
	 */
	public boolean isValidState() {
		return checkRuleA() && checkRuleB() && checkRuleC();
	}
	
	/**
	 * The  father (F) has  trouble  handling  the 
	 * daughters (A, B) if the mother is not present. 
	 */
	private boolean checkRuleA() {
		int fatherPos = 0, motherPos = 0, d1Pos = 0, d2Pos = 0, riverPos = 0;
		
		for (int i = 0; i < 10; i++) {
			if (river[i] == 'F') {
				fatherPos = i;
			} else if (river[i] == M) {
				motherPos = i;
			} else if (river[i] == A) {
				d1Pos = i;
			} else if (river[i] == B) {
				d2Pos = i;
			} else if (river[i] == X) {
				riverPos = i;
			}
		}
		
		if (((fatherPos < riverPos) && (motherPos > riverPos) && (d1Pos < riverPos || d2Pos < riverPos)) || 
			((fatherPos > riverPos) && (motherPos < riverPos) && (d1Pos > riverPos || d2Pos > riverPos)))
			return false;
		
		return true;
	}
	
	/**
	 * The  mother (M) has  trouble  handling  the 
	 * sons (C, D) if the father is not present. 
	 */
	private boolean checkRuleB() {
		int motherPos = 0, fatherPos = 0, s1Pos = 0, s2Pos = 0, riverPos = 0;
		
		for (int i = 0; i < 10; i++) {
			if (river[i] == 'F') {
				fatherPos = i;
			} else if (river[i] == M) {
				motherPos = i;
			} else if (river[i] == C) {
				s1Pos = i;
			} else if (river[i] == D) {
				s2Pos = i;
			} else if (river[i] == X) {
				riverPos = i;
			}
		}
		
		if (((motherPos < riverPos) && (fatherPos > riverPos) && (s1Pos < riverPos || s2Pos < riverPos)) || 
			((motherPos > riverPos) && (fatherPos < riverPos) && (s1Pos > riverPos || s2Pos > riverPos)))
			return false;
		
		return true;
	}
	
	/**
	 * It is dangerous for  any  family member  to  be  around the thief if the 
	 * policeman is not  keeping a close eye on.
	 */
	private boolean checkRuleC() {
		int motherPos = 0, fatherPos = 0, 
				s1Pos = 0, s2Pos = 0, 
				d1Pos = 0, d2Pos = 0,
				policePos = 0, thiefPos = 0, riverPos = 0;
		
		for (int i = 0; i < 10; i++) {
			if (river[i] == 'F') {
				fatherPos = i;
			} else if (river[i] == M) {
				motherPos = i;
			} else if (river[i] == A) {
				d1Pos = i;
			} else if (river[i] == B) {
				d2Pos = i;
			} else if (river[i] == C) {
				s1Pos = i;
			} else if (river[i] == D) {
				s2Pos = i;
			} else if (river[i] == P) {
				policePos = i;
			} else if (river[i] == T) {
				thiefPos = i;
			} else if (river[i] == X) {
				riverPos = i;
			}
		}
		
		if( 
			(
				((policePos < riverPos) && (thiefPos > riverPos)) && (
																		(motherPos > riverPos) || (fatherPos > riverPos) || 
																		(s1Pos > riverPos) || (s2Pos > riverPos) || 
																		(d1Pos > riverPos) || (d2Pos > riverPos)
																 	 ) 
			) 
			||
			( 
				((policePos > riverPos) && (thiefPos < riverPos)) && (
																		(motherPos < riverPos) || (fatherPos < riverPos) || 
																		(s1Pos < riverPos) || (s2Pos < riverPos) || 
																		(d1Pos < riverPos) || (d2Pos < riverPos)
																	 ) 
			) 
		)
			return false;
		
		return true;
	}

	@Override
	public RCPuzzleState clone() {
		RCPuzzleState copy = null;
		try {
			copy = (RCPuzzleState) super.clone();
			copy.river = Arrays.copyOf(river, river.length);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace(); // should never happen...
		}
		return copy;
	}

	@Override
	public boolean equals(Object anObj) {
		if (anObj != null && anObj.getClass() == getClass()) {
			RCPuzzleState anotherState = (RCPuzzleState) anObj;
			
			int myfatherPos = 0, mymotherPos = 0, myd1Pos = 0, myd2Pos = 0, mys1Pos = 0, mys2Pos = 0, 
			 mypolicePos = 0, mythiefPos = 0, myriverPos = 0, myraftPos = 0;
			
			int fatherPos = 0, motherPos = 0, d1Pos = 0, d2Pos = 0, s1Pos = 0, s2Pos = 0, 
			 policePos = 0, thiefPos = 0, riverPos = 0, raftPos = 0;
			for (int i = 0; i < 10; i++) {
				if (river[i] == 'F') {
					myfatherPos = i;
				} else if (river[i] == M) {
					mymotherPos = i;
				} else if (river[i] == A) {
					myd1Pos = i;
				} else if (river[i] == B) {
					myd2Pos = i;
				} else if (river[i] == C) {
					mys1Pos = i;
				} else if (river[i] == D) {
					mys2Pos = i;
				} else if (river[i] == P) {
					mypolicePos = i;
				} else if (river[i] == T) {
					mythiefPos = i;
				} else if (river[i] == X) {
					myriverPos = i;
				} else if (river[i] == R) {
					myraftPos = i;
				}
				
				if (anotherState.river[i] == 'F') {
					fatherPos = i;
				} else if (anotherState.river[i] == M) {
					motherPos = i;
				} else if (anotherState.river[i] == A) {
					d1Pos = i;
				} else if (anotherState.river[i] == B) {
					d2Pos = i;
				} else if (anotherState.river[i] == C) {
					s1Pos = i;
				} else if (anotherState.river[i] == D) {
					s2Pos = i;
				} else if (anotherState.river[i] == P) {
					policePos = i;
				} else if (anotherState.river[i] == T) {
					thiefPos = i;
				} else if (anotherState.river[i] == X) {
					riverPos = i;
				} else if (anotherState.river[i] == R) {
					raftPos = i;
				}
			}

			return (sayMyName(myfatherPos, mymotherPos, myd1Pos, myd2Pos, mys1Pos, mys2Pos, 
					 mypolicePos, mythiefPos, myriverPos, myraftPos,
					 fatherPos, motherPos, d1Pos, d2Pos, s1Pos, s2Pos, 
					 policePos, thiefPos, riverPos, raftPos));
		}
		return false;
	}
	
	public boolean sayMyName(int myfatherPos, int mymotherPos, int myd1Pos, int myd2Pos, 
							int mys1Pos, int mys2Pos, int mypolicePos, 
							int mythiefPos, int myriverPos, int myraftPos, 
							int fatherPos, int motherPos, int d1Pos, int d2Pos, 
							int s1Pos, int s2Pos, int policePos, 
							int thiefPos, int riverPos, int raftPos) {
		if (
				// Check position of the river
				(myriverPos != riverPos) || 
				// Check position of the raft
				(((myraftPos < myriverPos) && (raftPos > riverPos)) || 
					((myraftPos > myriverPos) && (raftPos < riverPos)) ) ||
				// Check mother positions
				(((mymotherPos < myriverPos) && (motherPos > riverPos)) || 
						((mymotherPos > myriverPos) && (motherPos < riverPos)) ) ||
				// Check father positions
				(((myfatherPos < myriverPos) && (fatherPos > riverPos)) || 
						((myfatherPos > myriverPos) && (fatherPos < riverPos)) ) ||
				// Check son 1 positions
				(((mys1Pos < myriverPos) && (s1Pos > riverPos)) || 
						((mys1Pos > myriverPos) && (s1Pos < riverPos)) ) ||
				// Check son 2 positions
				(((mys2Pos < myriverPos) && (s2Pos > riverPos)) || 
						((mys2Pos > myriverPos) && (s2Pos < riverPos)) ) ||
				// Check daughter 1 positions
				(((myd1Pos < myriverPos) && (d1Pos > riverPos)) || 
						((myd1Pos > myriverPos) && (d1Pos < riverPos)) ) ||
				// Check daughter 2 positions
				(((myd2Pos < myriverPos) && (d2Pos > riverPos)) || 
						((myd2Pos > myriverPos) && (d2Pos < riverPos)) ) ||
				// Check police positions
				(((mypolicePos < myriverPos) && (policePos > riverPos)) || 
						((mypolicePos > myriverPos) && (policePos < riverPos)) ) ||
				// Check thief positions
				(((mythiefPos < myriverPos) && (thiefPos > riverPos)) || 
						((mythiefPos > myriverPos) && (thiefPos < riverPos)) )
				
				)
			return false;
		else
			return true;
		
	}
	
	@Override
	public int hashCode() {
		// Need to ensure equal objects have equivalent hash code. (Issue 77).
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		String retVal = "";
		int i = 0;
		for (; i < 9; i++) {
			retVal = retVal + river[i] + " ";
		}
		
		retVal = retVal + river[i];
		
		return retVal;
	}
	
	public int getMotherPosition() {
		for (int i = 0; i < 10; i++) {
			if (river[i] == M) {
				return i;
			}
		}
		return -1;
	}
	
	public int getFatherPosition() {
		for (int i = 0; i < 10; i++) {
			if (river[i] == F) {
				return i;
			}
		}
		return -1;
	}
	
	public int getSon1Position() {
		for (int i = 0; i < 10; i++) {
			if (river[i] == C) {
				return i;
			}
		}
		return -1;
	}
	
	public int getSon2Position() {
		for (int i = 0; i < 10; i++) {
			if (river[i] == D) {
				return i;
			}
		}
		return -1;
	}
	
	public int getDaughter1Position() {
		for (int i = 0; i < 10; i++) {
			if (river[i] == A) {
				return i;
			}
		}
		return -1;
	}
	
	public int getDaughter2Position() {
		for (int i = 0; i < 10; i++) {
			if (river[i] == B) {
				return i;
			}
		}
		return -1;
	}
	
	public int getPolicePosition() {
		for (int i = 0; i < 10; i++) {
			if (river[i] == P) {
				return i;
			}
		}
		return -1;
	}
	
	public int getThiefPosition() {
		for (int i = 0; i < 10; i++) {
			if (river[i] == T) {
				return i;
			}
		}
		return -1;
	}
	
	public int getRiverPosition() {
		for (int i = 0; i < 10; i++) {
			if (river[i] == X) {
				return i;
			}
		}
		return -1;
	}
	
	public int getRaftPosition() {
		for (int i = 0; i < 10; i++) {
			if (river[i] == R) {
				return i;
			}
		}
		return -1;
	}
}
