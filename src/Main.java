import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); // Scanner¿‡
		System.out.println("Please input a int number(value between 5 and 20:");
		int num = in.nextInt();
		if (num < 5 || num > 20) {
			return;
		}
		double min = 11.0, max = 0, sum = 0;
		double[] list = new double[20];
		for (int i = 0; i < num; i++) {
			System.out.println("Please input the value of judge" + i + ":");
			double value = in.nextDouble();
			if (min - value > 0.0) {
				min = value;
			}
			if (value - max > 0.0) {
				max = value;
			}
			list[i] = value;
			sum += value;
		}
		in.nextInt();
		
		System.out.println(min + " " + max);

		double result = (sum - min - max) / (num - 2);
		double re = 11.0, temp;
		int fin = 0;
		for (int i = 0; i < num; i++) {
			temp = Math.abs(list[i] - result);
			if (re - temp > 0.0) {
				re = temp;
				fin = i;
			}
		}
		
		System.out.println(fin + 1);
	}
}
