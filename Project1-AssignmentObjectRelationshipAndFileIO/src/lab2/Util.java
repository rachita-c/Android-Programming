package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import exception.TooManyRecordsException;

class Util {
	static Student[] readFile(String filename, Student[] stu)
			throws IOException, TooManyRecordsException {
		int j = 0;
		// stu = new Student[40];
		File file = new File(filename);
		FileReader reader1 = null;
		try {
			reader1 = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader in1 = new BufferedReader(reader1);
		int lines = 0;
		while (in1.readLine() != null)
			lines++;

		// First line is extra and needs to not be counted
		stu = new Student[lines - 1];
		try {
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			String token;
			// Ignore first line
			in.readLine();
			while ((token = in.readLine()) != null) {
				stu[j] = new Student();
				StringTokenizer st = new StringTokenizer(token);
				stu[j].setSID(Integer.parseInt(st.nextToken()));
				int[] s = new int[5];
				for (int j1 = 0; j1 < s.length; j1++) {
					s[j1] = Integer.parseInt(st.nextToken());
				}
				stu[j].setScores(s);
				j++;

			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stu;

	}

	public static void main(String[] args) throws IOException,
			TooManyRecordsException {
		try {
			Student lab2[] = new Student[40];
			lab2 = Util.readFile("src/lab2/File.txt", lab2);
			Statistics statlab2 = new Statistics();
			for (int i = 0; i < lab2.length; i++) {
				if (i >= 40) {
					throw new TooManyRecordsException(
							"More than 40 records in file");
				}
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
