T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    result = 0
     
    for i in range(N):
        p, x = map(float, input().split())
        result += p * x
     
    print(f'#{test_case} {result}')
