import sys


def dp(items, arr, N, K):
    for i in range(1, N+1):
        for j in range(1, K+1):
            # print(i, j)
            w, v = items[i]
            # print(w, v)
            if(j >= w):
                arr[i][j] = max(
                    max(v + arr[i-1][j - w], arr[i][j-1]), arr[i-1][j])
            else:
                arr[i][j] = arr[i-1][j]
    print(arr[-1][-1])


N, K = map(int, sys.stdin.readline().split())
items = []
items.append((0, 0))
arr = [[0] * (K+1) for _ in range(N+1)]
# print(*arr[1])
for _ in range(N):
    W, V = map(int, sys.stdin.readline().split())
    items.append((W, V))
dp(items, arr, N, K)
