package simulation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
 
public class BOJ_2108_통계학 {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			arr[i] = value;
			sum += value;
		}
		
		Arrays.sort(arr);
		
		boolean flag = false;
		int mode_max = 0;
		int mode = 10000;
		
		for(int i = 0; i < N; i++) {
			int jump = 0;	// 동일한 수가 나온만큼 i 값 jump 시킬 변수 
			int count = 1;
			int i_value = arr[i];
			
			for(int j = i + 1; j < N; j++){
				if(i_value != arr[j]) {
					break;
				}
				count++; //동일한 값
				jump++; // i 값 그만큼 넘긴다
			}
			
			if(count > mode_max) {
				mode_max = count; // 몇번이나 갔는지
				mode = i_value; //최빈값
				flag = true; // 최빈 값 찾았다
			}
			else if(count == mode_max && flag == true) { // 최빈값이 같은 것이 있다면..
				mode = i_value;
				flag = false; // 두번째로 작은 값이 되므로 여기서 막는다
			}
			
			i += jump; //i 넘어가기
		}
		System.out.println((int)Math.round((double)sum / N));
		System.out.println(arr[N / 2]);
		System.out.println(mode);		
		System.out.println(arr[N - 1] - arr[0]);
	}
}