package B_1854;
import java.util.*;
import java.io.*;
 
public class Main {
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, K;
    private static List<Node>[] edge;
    private static PriorityQueue<Integer>[] dist;
 
    static class Node implements Comparable<Node> {
        int v, weight;
 
        public Node(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
 
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
 
        init();
 
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edge[u].add(new Node(v, weight));
        }
 
        dijkstra(1);
        print();
 
        br.close();
    }
 
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start].add(0);
 
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
 
            for (Node next : edge[cur.v]) {
                if (dist[next.v].size() < K) { // 저장된 최단비용의 수가 K개 이하
                    dist[next.v].add((cur.weight + next.weight) * -1);
                    pq.add(new Node(next.v, cur.weight + next.weight));
                } else if ((dist[next.v].peek() * -1) > cur.weight + next.weight) {
                    dist[next.v].poll();
                    dist[next.v].add((cur.weight + next.weight) * -1);
                    pq.add(new Node(next.v, cur.weight + next.weight));
                }
            }
        }
    }
 
    private static void print() {
        for (int i = 1; i <= N; ++i){
            if (dist[i].size() == K) System.out.println(dist[i].peek() * -1);
            else System.out.println(-1);
        }
    }
 
    private static void init() {
        dist = new PriorityQueue[N + 1];
        edge = new ArrayList[N + 1];
        for (int i = 0 ; i < N + 1; ++i) {
            dist[i] = new PriorityQueue<>(K);
            edge[i] = new ArrayList<>();
        }
    }
}
