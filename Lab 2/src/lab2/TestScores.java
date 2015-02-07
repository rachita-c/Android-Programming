package lab2;
import java.io.IOException;

import exception.TooManyRecordsException;

public class TestScores{
	public static void main(String[] args) throws IOException,
			TooManyRecordsException {
		try {
			Student lab2[] = new Student[40];
			lab2 = Util.readFile("src/lab2/File.txt", lab2);
			Statistics statlab2 = new Statistics();
			for (int i = 0; i < lab2.length; i++) {
				System.out.print(lab2[i].getSID() + "\t\t");

				for (int j = 0; j < lab2[i].getScores().length; j++) {
					System.out.print(lab2[i].getScores()[j] + "\t");
				}

				System.out.println("");
			}
			statlab2.findlow(lab2);
			statlab2.findhigh(lab2);
			statlab2.findavg(lab2);
			statlab2.printLowScores();
			statlab2.printHighScores();
			statlab2.printAvgScores();
		} catch (TooManyRecordsException e) {
			e.printStackTrace();
		}

	}
}