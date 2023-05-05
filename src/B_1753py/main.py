from dis import dis
import sys
import heapq

V, E = map(int, sys.stdin.readline().split())
K = int(sys.stdin.readline())
INF = sys.maxsize


def dijk(graph, distance, start):
    heap = []
    heapq.heappush(heap, (0, start))
    while heap:
        weight, u = heapq.heappop(heap)
        if distance[u] < weight:
            continue
        for v, w in graph[u]:
            nw = w + weight
            # print("v", v)
            if nw < distance[v]:
                distance[v] = nw
                heapq.heappush(heap, (nw, v))


graph = [[] for _ in range(1+V)]

distance = [INF for _ in range(V+1)]
distance[K] = 0
# print(*distance)
for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))
# print(*graph)
dijk(graph, distance, K)
# print(*distance)
for i in range(1, len(graph)):
    print("INF" if distance[i] == INF else distance[i])
