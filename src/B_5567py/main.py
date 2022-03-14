import sys


def dfs(arr, c, idx, time):
    c[idx] = True
    cur = idx
    for d in arr[idx]:
        # print(d)
        c[d] = True
        if time == 0:
            dfs(arr, c, d, time+1)


n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
arr = [0 for _ in range(n+1)]
c = [False for _ in range(n+1)]

for i in range(n+1):
    arr[i] = []
for i in range(m):
    a, b = map(int, sys.stdin.readline().split(" "))
    arr[a].append(b)
    arr[b].append(a)
    # arr.append((a,b))
# print(*arr)
dfs(arr, c, 1, 0)
cnt = 0
for _ in range(2, n+1):
    if(c[_]):
        cnt += 1
print(cnt)
