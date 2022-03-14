import sys
import math
t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))

    # sums = {-1: 0}
    # for i in range(len(arr)):
    #     sums[i] = sums[i-1] + arr[i]
    # sums = [arr[0]]
    # for i in range(1, len(arr)):
    #     sums.append(sums[i-1] + arr[i])
    sums = [0]
    for f in arr:
        # print(sums[-1])
        sums.append(sums[-1] + f)
    # print(*sums)

    dp = [[0]*n for _ in range(n)]

    for gap in range(1, n):
        for start in range(n - gap):
            end = start + gap
            dp[start][end] = math.inf
            for k in range(start, end):
                dp[start][end] = min(dp[start][end],
                                     dp[start][k] + dp[k+1][end]
                                     + sums[end+1] - sums[start])
    print(dp[0][-1])
