import sys


N = int(sys.stdin.readline())

arr = [('', 0)] * 30

for _ in range(N):
    temp = sys.stdin.readline()
    temp = temp.strip()

    for i in range(len(temp)):
        length = len(temp)

        index = ord(temp[i])-65

        num = 10 ** (length-i-1)
        if(num == 0):
            num = 1
        word, value = arr[index]
        value += num
        word = temp[i]
        arr[index] = (word, value)

arr.sort(key=lambda x: x[1], reverse=True)
ans = 0
number = 9
for i in range(30):
    word, value = arr[i]
    if value == 0:
        break
    ans += value * number
    number -= 1

print(ans)
