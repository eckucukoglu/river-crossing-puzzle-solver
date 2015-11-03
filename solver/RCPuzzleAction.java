/**
 * @author Emre Can Kucukoglu
 * 
 */
public class RCPuzzleAction extends DynamicAction {
	public static final char RIGHT = '>';
	public static final char LEFT = '<';
	
	
	private char passenger1 = RCPuzzleState.UNKNOWN, passenger2 = RCPuzzleState.UNKNOWN;
	private char direction = '-';
	
	public boolean isNoOp() {
		return false;
	}

	public RCPuzzleAction(char passenger1, char passenger2, char direction) {
		super("" + direction + passenger1 + passenger2);
		setPassenger1(passenger1);
		setPassenger2(passenger2);
		setDirection(direction);
	}

	public char getPassenger2() {
		return passenger2;
	}

	private void setPassenger2(char passenger2) {
		this.passenger2 = passenger2;
	}

	public char getPassenger1() {
		return passenger1;
	}

	private void setPassenger1(char passenger1) {
		this.passenger1 = passenger1;
	}

	public char getDirection() {
		return direction;
	}

	private void setDirection(char direction) {
		this.direction = direction;
	}
}
