import sys
from collections import deque

N,L,R = map(int, sys.stdin.readline().split())
g =[]
for  i in range(N):
    g.append(list(map(int, sys.stdin.readline().split())))
    
gox=[0,1,0,-1]
goy=[1,0,-1,0]

def bfs(a,b,g, visit):
    unit=[]
    people =0
    q = deque()
    q.append((a,b))
    unit.append((a,b))
    people+=g[a][b]
    visit[a][b] = True
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + gox[i]
            ny = y + goy[i]
            if 0 <= nx <N and 0<= ny<N and not visit[nx][ny]:
                if L<= abs(g[nx][ny] - g[x][y]) <= R:
                    q.append((nx,ny))
                    unit.append((nx,ny))
                    people += g[nx][ny]
                    visit[nx][ny] = True
    newPeople = people // len(unit)
    for a,b in unit:
        g[a][b] = newPeople
    return True if len(unit) >= 2 else False

day =0
while True:
    visit = [[False] * N for _ in range(N)]
    stop = True
    for i in range(N):
        for j in range(N):
            if not visit[i][j]:
                check = bfs(i,j,g,visit)
                if check:
                    stop = False
    if stop:
        break
    else:
        day+=1
print(day)