
public class SnakeLadder {

	final static int startPosition=0;
    final static int NumberOfPlayer=1;
    
    public static int rollDice() {
    	int diceValue = (int)(Math.floor(Math.random()*10)%6)+1;
    	return diceValue;
    }
	public static void main(String[] args) {
			System.out.println(rollDice());
	}
}
