import sys
INF=sys.maxsize
import heapq

    
def dijk(dist,start): #1번 노드 부터 모든 노드까지의 길이
    heap=[]
    dist[start] = 0
    heapq.heappush(heap, (start,0))
    while heap:
        u,w =heapq.heappop(heap)
        if dist[u] < w:continue
        for v,weight in graph[u]:
            nw = dist[u] + weight
            if(dist[v] > nw):
                dist[v]=nw
                heapq.heappush(heap, (v,nw))
    # print(dist)

N,E = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
distance = [INF for _ in range(N+1)]
v1Distance =[INF for _ in range(N+1)]
v2Distance =[INF for _ in range(N+1)]
for E in range(E):
    a,b,c = map(int, sys.stdin.readline().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
v1,v2 = map(int, sys.stdin.readline().split())
# print(*graph)
dijk(distance,1)
dijk(v1Distance,v1)
dijk(v2Distance,v2)
ans1 = 0
ans2 = 0
##asd
# 1 -> v1 -> v2 -> N
ans1 += distance[v1]
ans1 += v1Distance[v2]
ans1 += v2Distance[N]

# 1 -> v2 -> v1 -> N
ans2 += distance[v2]
ans2 += v2Distance[v1]
ans2 += v1Distance[N]
# print(ans1,ans2)/
ans = ans1
if ans2 < ans1 : ans = ans2
if ans >= INF :print(-1)
else :
    print(ans)