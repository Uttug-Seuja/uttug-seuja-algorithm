def solution(n):
    cnt = 1
    
    while n != 1:
        if n % 2 == 0:
            n /= 2
        else:
            cnt += 1
            n = n // 2
            
    return cnt
