import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] products = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            products[i][1] = Integer.parseInt(st.nextToken());
            products[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(products, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                return a2[0] - a1[0];
            }
        });

        int total = 0;
        for(int i = 0; i < N; i++) {
            int price = products[i][0];
            int weight = products[i][1];
            if(weight <= W) {
                total += weight * price;
                W -= weight;
            } else {
                total += W * price;
                break;
            }
        }

        System.out.println(total);
    }
}
