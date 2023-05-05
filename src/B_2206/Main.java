package B_2206;

import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int[][] maze;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    static Queue<Pair> que = new LinkedList<Pair>();
    static boolean[][][] visited;


    public static void BFS() {
        visited = new boolean[n][m][2];    //[][][0]은 벽은 안 부신 경우, [][][1]은 벽은 부신경우
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        que.add(new Pair(0,0,1,0));

        int ans=Integer.MAX_VALUE;
        while(!que.isEmpty()) {
            Pair node = que.poll();
            int nodex = node.x;
            int nodey = node.y;
            int nodelength = node.length;
            int nodewall = node.wall;

            if(nodex == n-1 && nodey == m-1) {
                ans = Math.min(ans,  nodelength);
                continue;
            }
            //주변 칸을 탐색
            /**
             * 이전에 벽은 부수지 않은경우(wall==0) 2가지
             * 0-1 벽을 만났을때는 벽을 안 부쉈으므로 벽 부수고 이동 wall을 1로 바꿈
             * 0-2 벽을 만나지 않았을때, 그대로 방문처리해주고 탐색을 계속
             * 이전에 벽을 부순경우(wall==1) 2가지
             * 1-1 벽을 만났을 경우, 이미 벽을 부쉈으므로 탐색을 해당지점에서 종료 -> 큐에 값을 넣지 않는다는 뜻
             * 1-2 벽을 만나지 않은 경우, 그대로 방문처리를 하고탐색을 계속
             * **/ 
            for(int i=0;i<4;i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                //범위 안일때
                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    //이전에 벽을 부수지 않은 경우이면서 방문하지 않는 곳이면
                    if(nodewall == 0 && !visited[nx][ny][0]) {
                        if(maze[nx][ny] == 1) {//벽일때
                            que.add(new Pair(nx,ny,nodelength+1,nodewall+1));
                            visited[nx][ny][1] = true;
                        }else {
                            que.add(new Pair(nx,ny,nodelength+1,nodewall));
                            visited[nx][ny][0] = true;
                        }
                    }else if(nodewall == 1 && !visited[nx][ny][1]) {//이전에 벽을 부순경우
                        if(maze[nx][ny]==0) {//벽이 아닐대만 체크
                            que.add(new Pair(nx,ny,nodelength+1,nodewall));
                            visited[nx][ny][1] = true;
                        }
                    }

                }
            }
        }
        if(ans == Integer.MAX_VALUE) {
            System.out.println("-1");
        }else {
            System.out.println(ans);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    

        String [] NM = br.readLine().split(" ");
        n = Integer.parseInt(NM[0]);
        m = Integer.parseInt(NM[1]);
        maze = new int[n][m];

        for(int i=0;i<n;i++) {
            String mazeinfo = br.readLine();
            for(int j=0;j<mazeinfo.length();j++) {
                maze[i][j] = Integer.parseInt(mazeinfo.substring(j, j+1));
            }
        }
        //너비탐색으로 부실수 있는 벽 체크
        BFS();

    }
    public static class Pair{
        int x,y;
        int length;
        int wall;
        public Pair(int x, int y, int length, int wall) {
            this.x = x;
            this.y = y;
            this.length = length;
            this.wall = wall;
        }
    }
}
//class Point {
//	int x, y, wall, len;
//
//	public Point(int x, int y, int len, int wall) {
//		this.x = x;
//		this.y = y;
//		this.wall = wall;
//		this.len = len;
//	}
//
//}
//
//public class Main {
//	static int map[][];
//	static boolean check[][][];
//	static int N, M;
//	static int gox[] = { 1, 0, -1, 0 };
//	static int goy[] = { 0, 1, 0, -1 };
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		String in[] = br.readLine().split(" ");
//		N = Integer.parseInt(in[0]);
//		M = Integer.parseInt(in[1]);
//		map = new int[N][M];
//		check = new boolean[N][M][2];
//		for (int i = 0; i < N; i++) {
//			String input = br.readLine();
//			for (int j = 0; j < M; j++) {
//				map[i][j] = input.charAt(j) - '0';
//			}
//		}
////		show();
//
//		// 0일때 가능
//		bfs();
//	}
//
//	static public void bfs() {
//		Queue<Point> q = new LinkedList();
//		q.add(new Point(0, 0, 1, 0));
//		check[0][0][0] = true;
//		check[0][0][1] = true;
//		int ans = Integer.MAX_VALUE;
//		while (!q.isEmpty()) {
//			Point p = q.poll();
//			int nx = p.x;
//			int ny = p.y;
//			int nwall = p.wall;
//			int nlen = p.len;
//
//			if (nx == N - 1 && ny == M - 1) {
//				ans = Math.min(ans, nlen);
//				continue;
//			}
//
//			for (int i = 0; i < 4; i++) {
//				nx += gox[i];
//				ny += goy[i];
//
//				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
//					if (nwall == 0 && !check[nx][ny][0]) {
//
//						if (map[nx][ny] == 1) {// 벽
//							q.add(new Point(nx, ny, nlen + 1, nwall + 1));
//							check[nx][ny][1] = true;
//						} else {// 이동가능
//							q.add(new Point(nx, ny, nlen, nwall + 1));
//							check[nx][ny][0] = true;
//						}
//
//					} else if (nwall == 1 && !check[nx][ny][1]) {
//						if (map[nx][ny] == 0) {
//							q.add(new Point(nx, ny, nlen, nwall + 1));
//							check[nx][ny][1] = true;
//						}
//					}
//				}
//			}
//
//		}
//		if (ans == Integer.MAX_VALUE) {
//			System.out.println(-1);
//		} else {
//			System.out.println(ans);
//		}
//
//	}
//
//	static boolean isPossible(int nx, int ny) {
//		if (nx < 0 || nx >= N || ny < 0 || ny >= M)
//			return false;
//		return true;
//	}
//
//	static public void show() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
//
//}
