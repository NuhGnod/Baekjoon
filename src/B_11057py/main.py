import sys
mod = 10007

N = int(sys.stdin.readline())
num = [0 for _ in range(11)]
for i in range(11):
    num[i] = i
first = 1

if(N == 1):
    print(num[-1])
else:
    for j in range(N-1):
        for i in range(10):
            num[i+1] = (num[i]) % mod + (num[i+1]) % mod
    print(num[-1] % mod)
