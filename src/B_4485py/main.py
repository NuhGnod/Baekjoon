import sys
import heapq

INF = 100000000


def dijk(distt, mapp, cnt):
    heap = []
    distt[0][0] = mapp[0][0]
    heapq.heappush(heap, (mapp[0][0], 0, 0))
    gox = [0, 1, 0, -1]
    goy = [1, 0, -1, 0]
    while heap:
        d, x, y = heapq.heappop(heap)

        for i in range(4):
            cx = x + gox[i]
            cy = y + goy[i]
            if 0 <= cx < N and 0 <= cy < N:

                if(d + mapp[cx][cy] <= distt[cx][cy]):
                    distt[cx][cy] = d + mapp[cx][cy]
                    heapq.heappush(heap, (d+mapp[cx][cy], cx, cy))
    print("Problem {0}: {1}".format(cnt, distt[-1][-1]))


cnt = 1
while True:
    N = int(sys.stdin.readline())
    if(N == 0):
        break
    mapp = []
    distance = [[INF] * N for _ in range(N)]

    for i in range(N):
        temp = list(map(int, sys.stdin.readline().split()))
        mapp.append(temp)
    # print(distance)
    dijk(distance, mapp, cnt)
    cnt = cnt+1
