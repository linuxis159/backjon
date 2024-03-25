from typing import Dict, List
N = int(input())
cnt = 0
for i in range(N):
    word = input()
    charSet = set()
    flag = False
    for j in range(0, len(word)):
        if word[j] in charSet:
            flag = True
            break
        else:
            try:
                charSet.add(word[j])
                if len(word) != j+1:
                    if word[j] == word[j+1]:
                        while word[j] == word[j+1]:
                            j+=1
            except IndexError as e :
                pass
    if flag == False:
        cnt+=1
print(cnt)

