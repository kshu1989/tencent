package one;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(
				new FileInputStream("1.txt")));
		String[] temp = read.readLine().split(" ");
		int num = Integer.parseInt(temp[0]);
		if (num < 5 || num > 20) {
			return;
		}
		
		double min = 11.0, max = 0, sum = 0;
		double[] list = new double[20];
		
		for (int i = 0; i < num; i++) {
			double value = Double.parseDouble(temp[i + 1]);
			if (min - value > 0.0) {
				min = value;
			}
			if (value - max > 0.0) {
				max = value;
			}
			list[i] = value;
			sum += value;
		}
		String end = read.readLine();
		if(!end.equals("" + 0)){
			return;
		}
//		System.out.println(min + " " + max);

		double result = (sum - min - max) / (num - 2);
		double re = 11.0, tempD;
		int fin = 0;
		for (int i = 0; i < num; i++) {
			tempD = Math.abs(list[i] - result);
			if (re - tempD > 0.0) {
				re = tempD;
				fin = i;
			}
		}
		
		System.out.println(fin + 1);
	}
}
