// baekjoon 지뢰 찾기_실버4
// 메모리 14224 kb	성능 132 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk_4396 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char [][] bomb = new char[n][n];
        char [][] board = new char[n][n];
        int [] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
        int [] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};
        int key = 1;

        for(int i = 0; i < n ; i++){
            String x = br.readLine();
            for(int j = 0; j < n; j++) {
                bomb[i][j] = x.charAt(j);
            }
        }

        for(int i = 0; i < n ; i++){
            String x = br.readLine();
            for(int j = 0; j < n; j++) {
                if(x.charAt(j) == 'x') {
                    if(bomb[i][j] == '*') {
                        key = 0;
                    }
                    else {
                        int count = 0;
                        for (int k = 0; k < 8; k++) { // 해당 칸 주위 8칸 검사
                            int newx = i + dirX[k];
                            int newy = j + dirY[k];
                            if (newx >= 0 && newx < n && newy >= 0 && newy < n && bomb[newx][newy] == '*')
                                count++;
                        }
                        board[i][j] = (char) (count + '0');
                    }
                }
                else {
                    board[i][j] = '.';
                }
            }
        }

        if(key == 0) {
            for(int i = 0; i < n ; i++){
                for(int j = 0; j < n; j++) {
                    if(bomb[i][j] == '*')
                        board[i][j] = '*';
                }
            }
        }

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
}