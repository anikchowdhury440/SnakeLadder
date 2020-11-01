
public class SnakeLadder {

	final static int winPoint = 100;
	final static int startPosition=0;
	final static int NumberOfPlayer=1;
	final static int noPlay=1;
	final static int ladder=2;
	final static int snake=3;
	static int userPosition = startPosition;
	
	public static int getUserPosition() {
		return userPosition;
	}
	
	public static void setUserPosition(int userPosition) {
		SnakeLadder.userPosition = userPosition;
	}
    
    public static int rollDice() {
    	int diceValue = (int)(Math.floor(Math.random()*10)%6)+1;
    	return diceValue;
    }
    
    public static int playerOption() {
    	int option = (int)(Math.floor(Math.random()*10)%3)+1;
    	return option;
    }
    
    public static void main(String[] args) {
    	
    	int noOfDiceThrown = 0;
    	
    	while(getUserPosition() != winPoint) 
    	{
    		int diceNumber = rollDice();
    		int option = playerOption();
    		
    		noOfDiceThrown++;
		
    		if(option == noPlay) {
    			setUserPosition(getUserPosition());
    		}
    		else if(option == ladder) {
    			if(getUserPosition()+diceNumber > 100) {
    				setUserPosition(getUserPosition());
    			}
    			else {
    				setUserPosition(getUserPosition() + diceNumber);
    			}
    		}
    		else if(option == snake) {
    			setUserPosition(getUserPosition() - diceNumber);
    		}
    		
    		if(getUserPosition() < 0) {
    			setUserPosition(startPosition);
    		}
    		
    		System.out.println(" Times of Dice Thrown : " + noOfDiceThrown + "\t Position of User :" +getUserPosition());
    	}
    	
    	System.out.println("Total No of Dice Thrown: " + noOfDiceThrown);
	}
}
