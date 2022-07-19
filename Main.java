import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static File file = new File("Input.txt");
	static ArrayList<String> data = new ArrayList<String>();
	static ArrayList<String> data2 = new ArrayList<String>();
	static String current = "";
	static int[] count = {0, 0};
	static int n = 0;
	
	public static void main(String[] args) {
		Scanner scan;
		Scanner scan2;
		try {
			scan = new Scanner(file);
			scan2 = new Scanner(file);
			while(scan.hasNextLine()) {
				data.add(scan.nextLine());
				data2.add(scan2.nextLine());
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			if(data.size() == 1) {
				System.out.println(data.get(0));
				break;
			}
			for(int i = 0; i < data.size(); i++) {
				current = data.get(i);
				if(current.charAt(n) == '1') {
					count[1] += 1;
				}
				else {
					count[0] += 1;
				}
			}
			char common = ' ';
			if(count[1] > data.size()/2 || count[1] == count[0]) {
				common = '1';
			}
			else common = '0';
			for(int i = 0; i < data.size();) {
				current = data.get(i);
				
				if(current.charAt(n) != common) {
					data.remove(i);
				}
				else {
					i++;
				}
			}
			count[0] = 0;
			count[1] = 0;
			n++;
		}
		n = 0;
		for(int i = 0; i < data.get(0).length()-1; i++) {
			if(data2.size() == 3) {
				System.out.println(data2.get(1));
				break;
			}
			for(int j = 0; j < data2.size(); j++) {
				current = data2.get(j);
				if(current.charAt(i) == '0') {
					count[1] += 1;
				}
				else {
					count[0] += 1;
				}
			}
			char common = ' ';
			if(count[1] < data2.size()/2 || count[1] == count[0]) {
				common = '0';
			}
			else common = '1';
			for(int j = 0; j < data2.size();) {
				current = data2.get(j);
				if(data2.size() == 3) {
					System.out.println(data2.get(1));
					break;
				}
				if(current.charAt(i) != common) {
					System.out.println(data2 + " " + i);
					data2.remove(j);
				}
				else {
					j++;
				}
			}
			
			count[0] = 0;
			count[1] = 0;
		}
		
		int c = Integer.parseInt(data2.get(1), 2);
		int o = Integer.parseInt(data.get(0), 2);
		System.out.println(c);
		System.out.println(o);
		System.out.println(o*c);
	}
}