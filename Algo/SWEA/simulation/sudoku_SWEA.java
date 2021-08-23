package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class sudoku_SWEA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int arr[][];
		arr=new int[9][9];
		boolean check = false;
		ArrayList<Integer> list = new ArrayList<Integer>();
		TreeSet<Integer> set;
		for(int test_case = 1; test_case <=T; test_case++)
		{
			check = false;
			for(int i = 0;i<9;i++) {
				for(int j = 0; j<9;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0;i<9;i++) {
				for(int j = 0; j<9;j++) {
					if(list.contains(arr[i][j]))
					{
						check = true;
					}
					list.add(arr[i][j]);
				}
				list.clear();
				for(int j = 0; j<9;j++) {
					if(list.contains(arr[j][i]))
					{
						check = true;
					}
					list.add(arr[j][i]);
				}
				list.clear();
			}
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					int sum = 0; //이렇게 해도 5 5 5 의 경우 파악 가능 위에서 위 아래가 다른지 체크하니깐
						for(int k = 0; k < 3; k++) {
							for(int s = 0; s < 3; s++) {
								sum += arr[3*i + k][3*j + s];
								}
							}
						if(sum != 45)
							{check = true;}
					}
				}
			if(check == false)
				{System.out.println("#"+test_case + " " + 1);
				}else {
					System.out.println("#"+test_case + " " + 0);
			}
		}
	}
}
