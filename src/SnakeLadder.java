
public class SnakeLadder {

	final static int winPoint = 100;
	final static int startPosition=0;
	final static int noPlay=1;
	final static int ladder=2;
	final static int snake=3;
	static int user1Position=startPosition;
    static int user2Position=startPosition;
    static int noOfDiceThrown=0;
	
    public static int getUser1Position() {
        return user1Position;
    }

    public static void setUser1Position(int user1Position) {
        SnakeLadder.user1Position = user1Position;
    }

    public static int getUser2Position() {
        return user2Position;
    }

    public static void setUser2Position(int user2Position) {
        SnakeLadder.user2Position = user2Position;
    }
    
    public static int rollDice() {
    	int diceValue = (int)(Math.floor(Math.random()*10)%6)+1;
    	return diceValue;
    }
    
    public static int playerOption() {
    	int option = (int)(Math.floor(Math.random()*10)%3)+1;
    	return option;
    }
    
    public static int player1move() {

		int diceNumber = rollDice();
		int option = playerOption();
		
		noOfDiceThrown++;
	
		if(option == noPlay) {
			setUser1Position(getUser1Position());
		}
		else if(option == ladder) {
			if(getUser1Position()+diceNumber > 100) {
				setUser1Position(getUser1Position());
			}
			else {
				setUser1Position(getUser1Position() + diceNumber);
			}
		}
		else if(option == snake) {
			setUser1Position(getUser1Position() - diceNumber);
		}
		
		if(getUser1Position() < 0) {
			setUser1Position(startPosition);
		}
		
		System.out.println("No of Times of Dice Thrown: " + noOfDiceThrown + "\t Position of Player 1:" +getUser1Position());

		if(option == ladder && getUser1Position() != 100) {
			player1move();
		}
			
		return user1Position;
    }
    
    public static int player2move() {

		int diceNumber = rollDice();
		int option = playerOption();
		
		noOfDiceThrown++;
	
		if(option == noPlay) {
			setUser2Position(getUser2Position());
		}
		else if(option == ladder) {
			if(getUser2Position()+diceNumber > 100) {
				setUser2Position(getUser2Position());
			}
			else {
				setUser2Position(getUser2Position() + diceNumber);
			}
		}
		else if(option == snake) {
			setUser2Position(getUser2Position() - diceNumber);
		}
		
		if(getUser2Position() < 0) {
			setUser2Position(startPosition);
		}
		
		System.out.println("No of Times of Dice Thrown: " + noOfDiceThrown + "\t Position of Player 2:" +getUser2Position());

		if(option == ladder && getUser2Position() != 100) {
			player2move();
		}
		
		return user2Position;
    }
    
    public void startPlay() {
    	while(user1Position != 100 && user2Position != 100)
    	{
    		player1move();
    		if(user1Position != 100) {
    			player2move();
    		}
    	}
    }
    
    public static void main(String[] args) {
    	
    	SnakeLadder snakeLadder = new SnakeLadder();
    	snakeLadder.startPlay();
		
    	if(user1Position == 100) {
    		System.out.println("Player 1 Win");
    		System.out.println("Total number of time thrown dice : " +noOfDiceThrown);
   		}
   		else if(user2Position == 100) {
   			System.out.println("Player 2 Win");
   			System.out.println("Total number of time thrown dice : " +noOfDiceThrown);
   		}
	}
}
