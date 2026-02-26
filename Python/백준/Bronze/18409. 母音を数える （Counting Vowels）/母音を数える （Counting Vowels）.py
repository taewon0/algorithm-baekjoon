n = int(input().strip())
s = input().strip()

count = 0
for i in range(n):
    if s[i] in ['a', 'e', 'i', 'o', 'u']:
        count += 1
print(count)