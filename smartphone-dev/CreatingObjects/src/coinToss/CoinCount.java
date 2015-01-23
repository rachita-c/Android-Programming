package coinToss;

public class CoinCount{
	public static void main(String[] args){
	Coin newCoin = new Coin();
	System.out.println("Side initially up");
	System.out.println(newCoin.getSideUp());
	int headsCounter = 0;
	int tailsCounter = 0;
	for (int i=0; i<=19; i++){
		newCoin.toss();
		System.out.println("Side facing up after toss");
		System.out.println(newCoin.getSideUp());
		if (newCoin.getSideUp() == "heads"){
			headsCounter ++;
		} else if (newCoin.getSideUp() == "tails"){
			tailsCounter ++;
		}
	}
	
	System.out.println("Number of times heads is facing up: " + headsCounter);
	System.out.println("Number of times tails is facing up: " + tailsCounter);
	
	}
}