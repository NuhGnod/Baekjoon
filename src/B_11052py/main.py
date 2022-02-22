import sys

from sympy import Max


N = int(sys.stdin.readline())


def cal():
    for i in range(1, N+1):
        dp[i][1] = cards[i]

    for i in range(N+1):
        for j in range(N+1):
            if(i < j):
                continue
            # print("asd")
            dp[i][j] = max(dp[i][j-1], cards[j] + dp[i-j][i-j])
    print(dp[-1][-1])


cards = [0 for _ in range(N+1)]
dp = [[0] * (N+1) for _ in range(N+1)]

temp = list(map(int, sys.stdin.readline().split()))
for i in range(len(temp)):
    cards[i+1] = temp[i]

cal()
# print(*dp)
