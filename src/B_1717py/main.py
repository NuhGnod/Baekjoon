import sys
sys.setrecursionlimit(10**5)
def union(a,b):
    x = find(a)
    y = find(b)
    
    if( x < y):
        parent[y] = x
    else :
        parent[x]= y 

def find(target):
    if parent[target] == target:
        return target
    parent[target] = find(parent[target])
    return parent[target]

N,M = map(int, sys.stdin.readline().split())
parent =[i for i in range(N+1)]
# print(*parent)
for i in range(M):
    oper,x,y = map(int, sys.stdin.readline().split())
    
    if( oper == 0):
        union(x,y)
    if( oper == 1):
        if(find(x) == find(y)):
            
            print("YES")
        else :
            print("NO")
