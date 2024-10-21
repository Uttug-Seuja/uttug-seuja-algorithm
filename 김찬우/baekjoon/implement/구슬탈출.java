package com.example.codingtest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬탈출 {

    static char[][] map = new char[10][10];
    static char[][] copyMap = new char[10][10];
    static int n,m;
    static int[] result = new int[10];
    static int[] R = new int[2];
    static int[] B = new int[2];
    static int[] copyR = new int[2];
    static int[] copyB = new int[2];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean checkR = false;
    static boolean checkB = false;

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j=0; j<m; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'R') {
                    copyR[0] = i;
                    copyR[1] = j;
                }else if (map[i][j] == 'B') {
                    copyB[0] = i;
                    copyB[1] = j;
                }
            }
        }

        pum(0);

        System.out.println(answer);

    }

    static void pum(int depth) {

        if (depth == 10) {

            copyMap = new char[n][m];

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            B[0] = copyB[0];
            B[1] = copyB[1];
            R[0] = copyR[0];
            R[1] = copyR[1];

            for (int d : result) {

                checkR = false;
                checkB = false;

                if (R[0] == B[0] && (d==1 || d == 3)) {

                    if (d == 1) {
                        if (R[1] > B[1]) {
                            move(R,d,'R');
                            move(B,d,'B');
                        }else {
                            move(B,d,'B');
                            move(R,d,'R');
                        }
                    }else {
                        if (R[1] > B[1]) {
                            move(B,d,'B');
                            move(R,d,'R');
                        }else {
                            move(R,d,'R');
                            move(B,d,'B');
                        }

                    }

                }else if (R[1] == B[1] &&  (d==0 || d == 2) ) {

                    if (d == 0) {
                        if (R[0] > B[0]) {
                            move(B,d,'B');
                            move(R,d,'R');
                        }else {
                            move(R,d,'R');
                            move(B,d,'B');
                        }
                    }else {
                        if (R[0] > B[0]) {
                            move(R,d,'R');
                            move(B,d,'B');
                        }else {
                            move(B,d,'B');
                            move(R,d,'R');
                        }

                    }

                }else {
                    move(R,d,'R');
                    move(B,d,'B');
                }

                if (checkB) {
                    return;
                }

                if (checkR ) {
                    answer = 1;
                    return;
                }


            }

            return;
        }

        for (int i=0; i<4; i++) {
            result[depth] = i;
            pum(depth+1);
        }
    }

    static boolean move(int[] arr,int d, char ball) {

        int x = arr[0];
        int y = arr[1];

        while (true) {

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (copyMap[nx][ny] == '#' || copyMap[nx][ny] == 'R' || copyMap[nx][ny] =='B') {
                    copyMap[x][y] = ball;
                if (ball =='B') {

                    B[0] = x;
                    B[1] = y;
                    return checkB = false;
                }else {
                    R[0] = x;
                    R[1] = y;
                    return checkR = false;
                }


            }

            // 만약에 O를 만났을 때
            if (copyMap[nx][ny] == 'O') {
                copyMap[x][y] = '.';
                if (ball == 'R'){
                   return checkR = true;
                }else {
                    return checkB = true;
                }
            }

            copyMap[x][y] = '.';
            copyMap[nx][ny] = ball;

            x = nx;
            y = ny;

        }


    }
}
