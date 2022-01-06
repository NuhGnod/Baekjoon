import sys

N = int(sys.stdin.readline())
node = [0 for i in range(N)]

graph = [[] for _ in range(N)]

temp = list(map(int, sys.stdin.readline().split()))
leafNode = 0


def dfs(x, check, delNode):
    global leafNode

    if len(graph[x]) == 1:
        leafNode += 1
        return
    xParentNode = node[x]
    check[x] = True
    for y in graph[x]:
        if not check[y] and y != xParentNode and y != -1:
            dfs(y, check, delNode)


rootNode = 0
for i in range(len(temp)):
    if temp[i] == -1:
        graph[i].append(-1)
        rootNode = i
        node[i] = temp[i]
        continue
    graph[i].append(temp[i])
    graph[temp[i]].append(i)
    node[i] = temp[i]  # parent node
check = [False] * (N)
# for i in range(N):
#     # print("parent : {0} , child : {1}, size : ".format(i, graph[i]), len(graph[i]))
#     if len(graph[i]) == 1:
#         leafNode += 1


delNode = int(sys.stdin.readline())
if node[delNode] == -1:
    print(0)
else:

    graph[node[delNode]].remove(delNode)

    dfs(rootNode, check, delNode)

    print(leafNode)
