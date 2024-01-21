package BOJ.simulation;

public class BOJ_4690_완전_세제곱 {

	public static void main(String[] args) {
		for (int i = 6; i <= 100; i++) {
			for (int j = 2; j < i; j++) {
				for (int j2 = j+1; j2 < i; j2++) {
					for (int k = j2+1; k < i; k++) {
						if(i*i*i == j*j*j + j2*j2*j2 + k*k*k) {
							System.out.println("Cube = "+i+", Triple = "+"("+j+","+j2+","+k+")");
						}
					}
				}
			}
		}
	}

}
