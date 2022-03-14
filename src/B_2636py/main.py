from itertools import count
import sys


def change(row, col, mapp):  # c를다시 0으로 바꾸기
    for i in range(row):
        for j in range(col):
            if(mapp[i][j] == 'c'):
                mapp[i][j] = 0
    # for i in range(row):
    #     for j in range(col):
    #         print(mapp[i][j], end=" ")
    #     print()


def bfs(x, y, col, row, mapp, visited):  # 바깥 치즈 찾기(c)
    count = 0
    q = []
    q.append((x, y))
    gox = [0, 1, 0, -1]
    goy = [1, 0, -1, 0]
    while q:
        cx, cy = q.pop(0)
        visited[cx][cy] = True
        for _ in range(4):
            nx = cx + gox[_]
            ny = cy + goy[_]
            if(0 <= nx < row and 0 <= ny < col):

                if mapp[nx][ny] == 1:
                    mapp[nx][ny] = 'c'
                    count += 1
                elif(mapp[nx][ny] == 0 and not visited[nx][ny]):
                    q.append((nx, ny))
                    visited[nx][ny] = True
    return count


row, col = map(int, sys.stdin.readline().split())
mapp = []
for _ in range(row):
    temp = list(map(int, sys.stdin.readline().split()))
    mapp.append(temp)
cnt = 0
cheese = 0
while True:
    visited = [[False] * col for i in range(row)]
    temp = bfs(0, 0, col, row, mapp, visited)
    change(row, col, mapp)
    cnt += 1
    if(temp == 0):
        print(cnt-1)
        print(cheese)

        break
    cheese = temp
