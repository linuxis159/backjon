N = int(input())

arr = [0 for i in range(N+1)]

arr[1] = 0
if N >= 2:
    arr[2] = 1
if N >= 3:
    arr[3] = 1

for i in range(4,N+1):
    a = 999999999999999999
    if i % 3 == 0:
        a = arr[int(i/3)] + 1
    if i % 2 == 0:
        a = min(arr[int(i/2)] + 1, a)
    if True:
        a = min((arr[i-1] +1), (arr[i-2] +2), a)
    arr[i] = a

print(arr[N])