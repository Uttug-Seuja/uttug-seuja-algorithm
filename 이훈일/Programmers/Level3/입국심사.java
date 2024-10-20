import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) n * times[times.length-1];
        long answer = 0;
        while(right >= left) {
            long mid = (left + right) / 2;
            
            long cnt = 0;
            for(int time : times) {
                cnt += mid / time;
            }
            
            if(cnt < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}
