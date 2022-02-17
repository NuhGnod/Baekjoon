import heapq
import sys

INF = sys.maxsize


def dijk(start):
    heap = []
    distance[1] = 0
    pre[1] = 1
    heapq.heappush(heap, (1, 0))
    while heap:
        u, w = heapq.heappop(heap)
        if distance[u] < w:
            continue
        for (v, weight) in (graph[u]):
            nweight = distance[u] + weight
            if(distance[v] > nweight):
                distance[v] = nweight
                pre[v] = u
                heapq.heappush(heap, (v, nweight))


def calPath(s, x):
    # print(x, pre[x])
    if x < pre[x]:
        s.add((x, pre[x]))
    else:
        s.add((pre[x], x))
    # s.add((x, pre[x]))
    if(pre[x] == 1):
        # s.add((x, pre[x]))
        return 1
    node = pre[x]

    calPath(s, node)


N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
distance = [INF for _ in range(N+1)]
pre = [0 for _ in range(N+1)]
s = set()
for _ in range(M):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))
    graph[v].append((u, w))
dijk(1)
# print(*distance)
# print(*pre)
for i in range(N+1):
    if i > 1:
        calPath(s, i)
# s.add((1, 3))
sorted(s)
print(len(s))
for i in range(len(s)):
    sentence = list((s.pop()))
    # print(sentence)
    # result = sentence[1:(len(sentence)-1)]
    # print(result)
    # print(sentence)
    u, v = sentence
    print(u, v)
