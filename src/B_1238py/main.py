import sys
import heapq
INF = sys.maxsize


def dijk(start, x):
    heap = []
    distance[start][start] = 0
    heapq.heappush(heap, (start, 0))
    while heap:
        u, w = heapq.heappop(heap)
        if distance[start][u] < w:
            continue
        for v, t in (graph[u]):
            # print(v, t)
            nt = distance[start][u] + t
            if(distance[start][v] > nt):
                distance[start][v] = nt
                heapq.heappush(heap, (v, nt))


def cal(dest):
    max = -1
    for i in range(1, N+1):
        temp = distance[i][dest] + distance[dest][i]
        if(max < temp):
            max = temp
    return max


N, M, X = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
distance = [[INF] * (N+1) for _ in range(N+1)]

for _ in range(M):
    u, v, t = map(int, sys.stdin.readline().split())
    graph[u].append((v, t))
# print(*graph)
for i in range(1, N+1):
    dijk(i, X)
# print(*distance)
print(cal(X))
