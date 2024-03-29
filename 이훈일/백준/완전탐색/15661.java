package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15661 {
    static int N, answer;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        answer = Integer.MAX_VALUE;

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if(depth == N) {
            int[] result = cal();
            answer = Math.min(answer, Math.abs(result[0] - result[1]));
            return;
        }

        visited[depth] = true;
        dfs(depth+1);
        visited[depth] = false;
        dfs(depth + 1);
    }

    public static int[] cal() {
        int startSum = 0;
        int linkSum = 0;

        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    startSum += graph[i][j];
                    startSum += graph[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkSum += graph[i][j];
                    linkSum += graph[j][i];
                }
            }
        }

        return new int[]{startSum, linkSum};
    }
}
