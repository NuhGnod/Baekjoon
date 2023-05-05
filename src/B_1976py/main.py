import sys


def find(target):
    if parent[target] == target:
        return target
    else :
        parent[target] = find(parent[target])
        return parent[target]
    
def union(i,j):
    x = find(i)
    y = find(j)
    
    if x < y:
        parent[y] = x
    else :
        parent[x] = y


N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
parent =[i for i in range(N)]


for i in range(N):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(N):
        if temp[j] == 1:
            union(i,j)
temp = list(map(int, sys.stdin.readline().split()))

p = parent[temp[0]-1]
print(*parent)
for i in range(len(temp)):
    if( p != parent[temp[i] - 1]):
        print("NO")
        p=-1
        break
if(p != -1):
    print("YES")