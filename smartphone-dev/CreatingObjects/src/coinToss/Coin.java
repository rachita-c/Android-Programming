package coinToss;
import java.util.Random;

public class Coin {
	private String sideUp;
		
	public Coin(){
		toss();
	}
	
	void toss(){
		Random generator = new Random();
		int randomSide = generator.nextInt(2);
		if (randomSide == 0)
			sideUp = "heads";
		else
			sideUp = "tails";		
	}
	
	String getSideUp(){
		return sideUp;
	}
	
	
}
