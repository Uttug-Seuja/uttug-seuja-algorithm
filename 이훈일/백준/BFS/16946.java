package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16946 {
    static int N, M;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static HashMap<Integer, Integer> storage = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] nums = line.split("");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int num = 2;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 0) {
                    int count = bfs(i, j, num);
                    storage.put(num, count);
                    num++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 1) {
                    sb.append(countWall(i, j));
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int bfs(int col, int row, int num) {
        graph[col][row] = num;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{col, row});
        int count = 1;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(graph[nx][ny] == 0) {
                        count++;
                        graph[nx][ny] = num;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return count;
    }

    public static int countWall(int x, int y) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(graph[nx][ny] > 1) {
                    set.add(graph[nx][ny]);
                }
            }
        }

        int sum = 1;
        for(int num : set) {
            sum += storage.get(num);
        }
        return sum % 10;
    }
}
