package BOJ.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1068_트리 {
	//문항을 제대로 읽지 않아서 일어난 문제
	//union find 로 찾을 수 없다 애초에 부모 노드의 위치를 줄 뿐더러 이진 트리의 형태로 내려오는 것이 아니므로
	//노드는 순서대로 들어오지 않으며 각 번호는 부모노드의 위치를 반환하는 것이다.
	// -1은 루트노드이다.
	static int N;
	static ArrayList<Integer> list[];
	static int M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		list = new ArrayList[N];
		for(int i = 0;i<N;i++) {
			list[i] = new ArrayList<>();
		}
		int root = -1;
		for(int i = 0;i<N;i++) {
			int parent = Integer.parseInt(tk.nextToken());
			if(parent == -1) {
				root = i; // 항상 -1이 0번째에 나오는 것이 아니다.
			}else {
				list[parent].add(i);//1,2
			}
		}

		M =Integer.parseInt(in.readLine());// 몇 번째
		//M+1 그 위치로 감
		if(root != M) {
			System.out.println(dfs(root));
		}
		else { //root가M 이면 바로 리턴
			System.out.println("0");
		}
	}
	static private int dfs(int start) {
		int ret = 1;
		int child = 0;
		for (Integer ch: list[start]){
			if(ch==M) continue; // 카운트 안됨
			child += dfs(ch);
		}
		// 리프노드가 아닌경우 (그 때에 저장된 child 값을 상위 노드로 올려주는 것이다.)
		if(child != 0) return child; // 리프노드가 아닌데 내려왔다는 것은 다 탐색 했다는 것이므로 거기서 내려감
			// 리프노드인경우 (자식이 없는경우)
		else return ret;
	}
}
