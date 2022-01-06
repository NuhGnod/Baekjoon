from collections import deque
import sys


def dfs(targetx, fam, check):

    for x in fam[targetx]:
        if check[x] == 0:
            check[x] = check[targetx] + 1
            dfs(x, fam, check)


N = int(sys.stdin.readline())
targetx, targety = map(int, sys.stdin.readline().split())
m = int(sys.stdin.readline())
family = [0 for i in range(N + 1)]
check = [0] * (N + 1)

for i in range(N + 1):
    family[i] = []
for i in range(m):
    parent, child = map(int, sys.stdin.readline().split())
    family[child].append(parent)
    family[parent].append(child)
# for i in range(m + 1):
#     print("child : {0} , parent : {1}".format(i, family[i]))
dfs(targetx, family, check)
print(check[targety] if check[targety] > 0 else -1)
