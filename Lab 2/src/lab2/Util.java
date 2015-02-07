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

		if (lines > 40){
			throw new TooManyRecordsException(
					"More than 40 records in file");
		}
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


}
