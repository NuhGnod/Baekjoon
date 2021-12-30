import sys


def isPossible(x, y, size):

    if x < 0 or y < 0 or x >= size or y >= size:
        return False
    return True


def bfs(A, L, R):
    gox = [0, 1, 0, -1]
    goy = [1, 0, -1, 0]
    size = len(A)

    queue = []
    baseCondition = False
    Date = 0
    while True:
        c = [[0] * size for i in range(size)]
        cc = [[0] * size for i in range(size)]

        isChanged = False
        if baseCondition:
            print(Date - 1)
            break
        Date += 1
        for i in range(size):
            for j in range(size):
                if not c[i][j]:
                    queue.append((i, j))
                person = 0
                cnt = 0
                while queue:
                    x, y = queue.pop(0)
                    for k in range(4):
                        nx = x + gox[k]
                        ny = y + goy[k]
                        if isPossible(nx, ny, size):
                            if not c[nx][ny]:
                                one = abs(A[nx][ny] - A[x][y])

                                if L <= one <= R:
                                    if not c[x][y]:
                                        person += A[x][y]
                                        cnt += 1
                                    c[x][y] = True
                                    c[nx][ny] = True

                                    cc[x][y] = j
                                    cc[nx][ny] = j

                                    person += A[nx][ny]
                                    cnt += 1
                                    queue.append((nx, ny))
                                    isChanged = True
                if cnt == 0:
                    continue
                for k in range(size):
                    for q in range(size):
                        boo = c[k][q]
                        time = cc[k][q]
                        if boo and time == j:
                            A[k][q] = person // cnt
                        # if c[k][q]:
                        #     A[k][q] = person // cnt
        if not isChanged:
            baseCondition = True

    # return 1


N, L, R = map(int, sys.stdin.readline().split())
A = [[0] * N for i in range(N)]


for i in range(N):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(N):
        A[i][j] = temp[j]
bfs(A, L, R)

# for i in range(N):
#     print(A[i])
