package lab2;
class Student {
  private int SID;
  private int scores[] = new int[5];
  
  //write public get and set methods for
  //SID and scores
  //add methods to print values of instance variables.
  public int getSID(){
	  return SID;
  }
  
  public void setSID(int SID){
	  this.SID = SID;
  }
  
  public int[] getScores(){
	  return scores;
  }
  
  public void setScores(int[] scores){
	  this.scores = scores;
  }
  
  //print values of instance variable
  public void printSID(){
	  System.out.println(this.SID);
  }
  
  public void printScores(){
	  for (int i=0; i<scores.length; i++){
		  System.out.println(scores[i]);
	  }
	  
  }
}