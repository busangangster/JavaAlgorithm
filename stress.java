import java.util.*;
import java.io.*;

class Shark {
    int r, c, s, d, z;

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

public class stress {
    static int R, C, M;
    static Shark[][] map;
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 우, 좌
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            
            if((d+1) <= 2){
                s = s%((R-1)*2);
            }else{
                s = s%((C-1)*2);
            }

            map[r][c] = new Shark(r, c, s, d, z);
        }

        int result = fishingKing();
        System.out.println(result);
    }

    public static int fishingKing() {
        int totalCaught = 0;
        for (int col = 0; col < C; col++) {
            Shark caughtShark = null;
            // 가까운 상어 잡기
            for (int row = 0; row < R; row++) {
                if (map[row][col] != null) {
                    caughtShark = map[row][col];
                    map[row][col] = null; // 상어 잡힘
                    totalCaught += caughtShark.z;
                    break;
                }
            }
            moveSharks();
        }
        return totalCaught;
    }

    public static void moveSharks() {
        Shark[][] newMap = new Shark[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != null) {
                    Shark shark = map[i][j];
                    int speed = shark.s;
                    int direction = shark.d;
                    int row = shark.r;
                    int col = shark.c;

                    // 상어의 속력에 따라 이동
                    for (int k = 0; k < speed; k++) {
                        row += dr[direction];
                        col += dc[direction];

                        // 범위를 벗어나면 방향을 조정하여 위치 조정
                        if (row < 0) {
                            row = 1;
                            direction = 1;
                        }
                        if (row >= R) {
                            row = R - 2;
                            direction = 0;
                        }
                        if (col < 0) {
                            col = 1;
                            direction = 2;
                        }
                        if (col >= C) {
                            col = C - 2;
                            direction = 3;
                        }
                    }

                    // 상어가 이동한 위치에 새로운 상어가 없거나 기존의 상어보다 크기가 큰 경우에만 업데이트
                    if (newMap[row][col] == null || newMap[row][col].z < shark.z) {
                        newMap[row][col] = new Shark(row, col, shark.s, direction, shark.z);
                    }
                }
            }
        }
        map = newMap;
    }
}