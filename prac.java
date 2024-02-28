// import java.io.*;
// import java.util.*;


// public class prac {
// 	static int R,C,M,man_y,sum;
// 	static ArrayList<shark> sharks;
// 	static boolean[] visited;
// 	static int[][] grid;
// 	static int[] dx = {0,-1,1,0,0};
// 	static int[] dy = {0,0,0,1,-1};
// 	public static void main(String[] args) throws Exception{
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringTokenizer st;
		
// 		st = new StringTokenizer(br.readLine());
// 		R = Integer.parseInt(st.nextToken());
// 		C = Integer.parseInt(st.nextToken());
// 		M = Integer.parseInt(st.nextToken());
		
// 		sharks = new ArrayList<shark>();
// 		visited = new boolean[M];
// 		grid = new int[R+1][C+1];
		
// 		man_y = 0; // 낚시왕 x 좌표 
// 		sum = 0; // 상어 크기 합
		
// 		if (M == 0) {
// 			System.out.println(0);
// 		}
// 		else {
// 			for (int i=0; i<M; i++) {
// 				st = new StringTokenizer(br.readLine());
// 				int r = Integer.parseInt(st.nextToken());
// 				int c = Integer.parseInt(st.nextToken());
// 				int s = Integer.parseInt(st.nextToken());
// 				int d = Integer.parseInt(st.nextToken());
// 				int z = Integer.parseInt(st.nextToken());
				
// 				sharks.add(new shark(r,c,s,d,z));
// 				grid[r][c] = z;
// 			}

// 			System.out.println(sharks);
	
// 			while (true) {
// 				if (man_y > R+1) {
// 					System.out.println(sum);
// 					break;
// 				}
// 				else {

// 					man_y++; // 1. 낚시왕 한 칸 이동 
// 					int min_v = Integer.MAX_VALUE;
// 					int gone = -1;
// 					for (int i=0; i<sharks.size(); i++) { // 2. 같은 열에 있는 상어 중 가장 가까운 한마리 잡기 
// 						System.out.println(Arrays.deepToString(grid));
// 						if (sharks.get(i).y == man_y && grid[sharks.get(i).x][sharks.get(i).y] != 0) {
							
// 							if (Math.abs(1 - sharks.get(i).x) < min_v) {
// 								min_v =  Math.abs(1 - sharks.get(i).x);
// 								gone = i ;
// 							}
// 						}
// 					}
// 					System.out.println(gone);
					
// 					if (gone != -1) {
// 						sum += sharks.get(gone).size;	
// 					}


// 					// 3. 상어 이동
// 					moveSharks();
// 					updateGrid();
// 					System.out.println();
// 					System.out.println(Arrays.deepToString(grid));
// 					System.out.println(sum);
// 					System.out.println();

					
// //					for (int i=0; i<sharks.size(); i++) { // 같은 위치에 있는 상어 제거
// //						if (visited[i]) continue;
// //						ArrayList<Integer> nums  = new ArrayList<Integer>();
// //						nums.add(i);
// //						int tmp = sharks.get(i).size;
// //						int idx = i;
// //						int cnt = 0 ;
// //						
// //						for (int j=i+1; j<sharks.size(); j++) {
// //							if (visited[j]) continue;
// //							
// //							if (sharks.get(i).x == sharks.get(j).x && sharks.get(i).y == sharks.get(j).y) {
// //								if (sharks.get(j).size > tmp) {
// //									tmp = sharks.get(j).size;
// //									idx = j;
// //									nums.add(j);
// //									cnt++;
// //								}
// //							}
// //						}
// //
// //						if (cnt >= 1) {
// //							for (int  j=0; j<nums.size(); j++) {
// //								if (nums.get(j) == idx) continue;
// //								else {
// //									visited[nums.get(j)] = true;
// //								}
// //							}
// //						}
// //					}
// 				}
// 			}
// 		}
		
// 	}
// 	  static void moveSharks() {
// 	        for (shark shark : sharks) {
// 	            int r = shark.x;
// 	            int c = shark.y;
// 	            int s = shark.speed;
// 	            int d = shark.direction;

// 	            // 현재 방향으로 속도만큼 이동
// 	            for (int i = 0; i < s; i++) {
// 	                r += dx[d];
// 	                c += dy[d];

// 	                // 경계를 벗어나면 방향 반대로 변경
// 	                if (r < 1 || r > R || c < 1 || c > C) {
// 	                    r -= dx[d];
// 	                    c -= dy[d];
// 	                    if (d == 1) d = 2;
// 	                    else if (d == 2) d = 1;
// 	                    else if (d == 3) d = 4;
// 	                    else if (d == 4) d = 3;
// 	                    i--; // 한 칸 이동했으므로 다시 한 칸 뒤로 이동
// 	                }
// 	            }

// 	            shark.x = r;
// 	            shark.y = c;
// 	            shark.direction = d;
// 	        }
// 	    }
	  
// 	    static void updateGrid() {
// 	        grid = new int[R + 1][C + 1]; // 격자 초기화
// 	        for (shark shark : sharks) {
// 	            if (grid[shark.x][shark.y] == 0) { // 상어가 없는 곳이라면
// 	                grid[shark.x][shark.y] = shark.size; // 상어 배치
// 	            } else { // 상어가 있는 곳이라면 크기 비교
// 	                if (grid[shark.x][shark.y] < shark.size) { // 새로운 상어가 더 크다면
// 	                    grid[shark.x][shark.y] = shark.size; // 해당 위치에 큰 상어 배치
// 	                }
// 	            }
// 	        }
// 	    }
// }


// class shark{
// 	int x;
// 	int y;
// 	int speed;
// 	int direction;
// 	int size;
// 	public shark(int x, int y, int speed, int direction, int size) {
// 		this.x = x;
// 		this.y =y ;
// 		this.speed = speed;
// 		this.direction = direction;
// 		this.size = size;
// 	}
// 	@Override
// 	public String toString() {
// 		return "shark [x=" + x + ", y=" + y + ", speed=" + speed + ", direction=" + direction + ", size=" + size + "]";
// 	}
// }

