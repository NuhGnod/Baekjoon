import sys
import heapq
INF = sys.maxsize
def dijk(start):
    heap=[]
    heapq.heappush(heap,(start,0))
    distance[start] = 0
    while heap:
        u,w = heapq.heappop(heap)
        if(distance[u] < w) : continue
        for v,weight in graph[u]:
            # print(v, weight)
            newWeight = distance[u] + weight
            if(distance[v] > newWeight):
                distance[v] = newWeight
                heapq.heappush(heap, (v,newWeight))
    for i in range(len(distance)):
        distance[i] *=2
           

def cal():
    pX = X
    day=1
    distance.sort()
    print(distance)
    for i in range(len(distance)):
        if distance[i] > X :
            print(-1)
            return False
        else :
            if(pX < distance[i]):
                day+=1
                pX = X
            pX -= distance[i]
    print(day)
            
    
    



N,M,X,Y = map(int, sys.stdin.readline().split())
graph=[ [] for _ in range(N)]
distance=[INF for _ in range(N)]
for _ in range(M):
    u,v,w = (map(int, sys.stdin.readline().split()))
    graph[u].append((v,w))
    graph[v].append((u,w))
dijk(Y)
cal()
# print(*graph)5 6 21 0

# print(graph[1])
# for x in graph[1]:
#     print(x)