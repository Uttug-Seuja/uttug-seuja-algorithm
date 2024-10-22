import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parents;
    static int n;
    static int m;
    static int k;
    static Edge[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new Edge[m];
        init();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++) {
           parents[Integer.parseInt(st.nextToken())] = 0;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);


        int answer = 0;
        int v =0;

        for (int i=0; i<m; i++) {
            Edge edge = arr[i];
            int from = edge.from;
            int to = edge.to;

            if (union(from,to)) {

                answer += edge.power;
                v++;

                if (v == n-1) {
                    break;
                }
            }


        }

        System.out.println(answer);

    }

    static void init() {
        parents = new int[n+1];
        for (int i=1; i<=n; i++) {
            parents[i] = i;
        }
    }

    static int find(int node) {
        if (parents[node] == node) {
            return node;
        }
        return parents[node] = find(parents[node]);
    }

    static boolean union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return false;
        }

        parents[pa] = pb;
        return true;

    }


    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int power;

        public Edge(int from, int to, int power) {
            this.from = from;
            this.to = to;
            this.power = power;
        }

        @Override
        public int compareTo(Edge o) {
            return this.power - o.power;
        }
    }
}
