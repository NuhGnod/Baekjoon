import heapq
import sys
INF = sys.maxsize


def dijk(M, N):
    gox = [0, 1, 0, -1]
    goy = [1, 0, -1, 0]
    heap = []
    heapq.heappush(heap, (0, 0))
    distance[0][0] = 0
    while heap:
        cx, cy = heapq.heappop(heap)
        for i in range(4):
            nx = cx + gox[i]
            ny = cy + goy[i]
            if(0 <= nx < M and 0 <= ny < N):
                if(distance[nx][ny] > distance[cx][cy] + maze[nx][ny]):
                    distance[nx][ny] = distance[cx][cy] + maze[nx][ny]
                    heapq.heappush(heap, (nx, ny))
    print(distance[-1][-1])


N, M = map(int, sys.stdin.readline().split())
maze = []
distance = [[INF] * N for _ in range(M)]

for i in range(M):
    temp = list(map(int, sys.stdin.readline().strip()))
    # print(temp)
    maze.append(temp)

dijk(M, N)
