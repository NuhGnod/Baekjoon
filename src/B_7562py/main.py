from typing import Deque

n = input()
n = int(n)


class Pair:
    def __init__(self, x, y, cnt):
        self.x = x
        self.y = y
        self.cnt = cnt

    def __getX__(self):
        return self.x

    def __getY__(self):
        return self.y

    def __getCnt__(self):
        return self.cnt


gox = [1, 2, 2, 1, -1, -2, -2, -1]
goy = [2, 1, -1, -2, -2, -1, 1, 2]

l = 0  # 전역변수


def isPossible(x, y):
    global l
    # print(type(x), type(len))
    if x < 0 or y < 0 or x >= l or y >= l:
        return False
    return True


def __bfs__(p1, p2, c):
    dq = []
    dq.append(p1)
    ans = 300 * 300 + 300
    ans = int(ans)
    # print("cnt : ", not dq)

    while dq:
        p = dq.pop(0)
        x = p.__getX__()
        y = p.__getY__()
        x = int(x)
        y = int(y)
        cnt = p.__getCnt__()
        cnt = int(cnt)
        c[x][y] = True
        if x == int(p2.__getX__()) and y == int(p2.__getY__()):
            ans = min(ans, cnt)
            continue
        for i in range(0, 8):
            nx = x + gox[i]
            ny = y + goy[i]
            nx = int(nx)
            ny = int(ny)
            # print("nx - ny", nx, ny)

            if isPossible(nx, ny):
                # print("nx + ny", nx, ny)
                if not c[nx][ny]:
                    dq.append(Pair(nx, ny, cnt + 1))
                    c[nx][ny] = True

    print(ans)
    # print("p1.getX() : ", p1.__getX__())
    # return 1


for i in range(0, n):
    l = input()
    l = int(l)
    cx, cy = input().split(" ")
    dx, dy = input().split(" ")
    c = [[0] * l for i in range(l)]  # boolean 배열
    p1 = Pair(cx, cy, 0)  # 출발 점
    p2 = Pair(dx, dy, 0)  # 목적지
    __bfs__(p1, p2, c)
