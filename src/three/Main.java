package three;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(
				new FileInputStream("3.txt")));
		int num = Integer.parseInt(read.readLine());
		if (num < 1 || num > 100) {
			return;
		}

		for (int q = 0; q < num; q++) {
			String[] temp = read.readLine().split(" ");

			int n = Integer.parseInt(temp[0]);
			if (n < 1 || n > 200) {
				return;
			}
			int t = Integer.parseInt(temp[1]);
			if (t < 1 || t > 1000) {
				return;
			}

			String[][] datas1 = new String[t][n];
			String[][] datas2 = new String[t][n];
			String line = "";
			for (int i = 0; i < t; i++) {
				line = read.readLine();
				temp = line.split(" ");
				String tttt = temp[0].replaceAll("\\+", ",").toString();
				String[] nums = tttt.split(",");
				if (temp[1].equals("" + 1)) {
					for (int j = 0; j < nums.length; j++) {
						datas1[i][j] = nums[j];
					}
				} else {
					for (int j = 0; j < nums.length; j++) {
						datas2[i][j] = nums[j];
					}
				}

			}

			line = read.readLine();
			int D1 = Integer.parseInt(line.split(" ")[0]);
			int D2 = Integer.parseInt(line.split(" ")[1]);

			line = read.readLine();
			String A = line.split(" ")[0];
			String B = line.split(" ")[1];

			ArrayList al = new ArrayList();
			get(al, datas1, t, n, A, B, 1);
			int p = al.size();
			get(al, datas2, t, n, A, B, 1);

			int min = Integer.MAX_VALUE;

			for (int i = 0; i < al.size(); i++) {
				int a = 0;
				if (i < p) {
					a = (int) al.get(i) * D2;
				} else {
					a = (int) al.get(i) * D1;
				}
				if (a < min) {
					min = a;
				}
			}
			System.out.println(min);
		}
	}

	public static void get(ArrayList re, String[][] data, int t, int n,
			String a, String b, int level) {
		ArrayList l = new ArrayList();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < t; j++) {
				if (data[j][i] != null && data[j][i].equals(b)) {
					if (i - 1 >= 0) {
						if (data[j][i - 1].equals(a)) {
							re.add(level);
						} else if (!l.contains(data[j][i - 1]) && (i - 1) != 0) {
							l.add(data[j][i - 1]);
						}

					}
				}
			}
		}
		for (String list : (ArrayList<String>) l) {
			get(re, data, t, n, a, list, level + 1);
		}
	}
}
