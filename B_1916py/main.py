import sys
import heapq
INF = sys.maxsize


def dijk(start, dest):
    distance[start] = 0
    heap = []
    # print(*graph)
    heapq.heappush(heap, (start, 0))
    while heap:
        u, w = heapq.heappop(heap)
        if(distance[u] < w):
            continue
        for v, d in graph[u]:
            # print(v, d)
            nd = w + d
            if(distance[v] > nd):
                distance[v] = nd
                heapq.heappush(heap, (v, nd))
    print(distance[dest])


N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

graph = [[] for _ in range(N+1)]
distance = [INF for _ in range(N+1)]

for i in range(M):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))
start, dest = map(int, sys.stdin.readline().split())
dijk(start, dest)
