package BOJ.Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2166 {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            int[][] points = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            double area = calculatePolygonArea(points);
            System.out.printf("%.1f\n", area);
        }

        static double calculatePolygonArea(int[][] points) {
            double area = 0;

            for (int i = 1; i < points.length - 1; i++) {
                area += calculateTriangleArea(points[0], points[i], points[i + 1]);
            }

            return Math.abs(area);
        }

        static double calculateTriangleArea(int[] A, int[] B, int[] C) {
            return 0.5 * Math.abs(A[0] * (B[1] - C[1]) + B[0] * (C[1] - A[1]) + C[0] * (A[1] - B[1]));
        }

}
