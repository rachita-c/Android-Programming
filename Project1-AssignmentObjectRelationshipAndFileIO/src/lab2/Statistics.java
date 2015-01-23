package lab2;

import java.math.BigDecimal;
import java.util.Arrays;

class Statistics
{
  int [] lowscores = new int [5];
  int [] highscores = new int [5];
  float [] avgscores = new float [5];
  public void findlow(Student [] a){
      //This method will find lowest score and store it in an array names lowscores
	  
	  // Set initial lowscores to be the first student's scores

	  lowscores[0] = lowscores[1] = lowscores[2] = lowscores[3] = lowscores[4] = 100;
	  int[] scores = new int[5];
	  //Go through each student
	  for (int i=0; i<a.length; i++ ){
		  
		 // Get all scores of that student 
		 scores = a[i].getScores();
		 
		 //Go through each quartile score for that student
		 for (int j=0; j<scores.length; j++){
			 //Check if that quartile score is less than the lowscore of that quarile
			 if (scores[j] < lowscores[j]){
				lowscores[j] = scores[j];	
			 }
		 }
	 }  
  }
 
  public void findhigh(Student [] a){
      //This method will find highest score and store it in an array names highscores
	  highscores[0] = highscores[1] = highscores[2] = highscores[3] = highscores[4] = 0;
	  int[] scores = new int[5];
	  for (int i=0; i<a.length; i++){
		 scores = a[i].getScores();
		 for (int j=0; j<scores.length; j++){
			 if (scores[j] > highscores[j]){
				 highscores[j] = scores[j];
			 }
		 }
	 }
  }

  public void findavg(Student [] a){
       //This method will find avg score for each quiz and store it in an array names avgscores
	  float[] sumscores = new float[5];
	  
	  // Loop through Each student 
	  for (int i=0; i<a.length; i++){	
		 // Get scores for each student
		 int[] scores = a[i].getScores();

		 // Quartile array
		 for (int j=0; j<scores.length; j++){
			 sumscores[j] += scores[j];
		 }
	 }
	 for (int i=0; i<5; i++){
	        BigDecimal bd = new BigDecimal(Float.toString(sumscores[i]/a.length));	 
	        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
	        avgscores[i] = bd.floatValue();
	 }
  }
  
  void printLowScores(){
	  System.out.print("Low Score" + "\t");

	  for (int i=0; i<lowscores.length; i++){
		  System.out.print(lowscores[i] + "\t");
	  }
	  System.out.println("");
  }
  
  void printHighScores(){
	  System.out.print("High score" + "\t");
	  for (int i=0; i<highscores.length; i++){
		  System.out.print(highscores[i] +"\t");
	  }
	  System.out.println("");
  }
  
  void printAvgScores(){
	  System.out.print("Average score" + "\t");
	  for (int i=0; i<avgscores.length; i++){
		  System.out.print(avgscores[i] + "\t");
	  }
	  System.out.println("");
  }
}