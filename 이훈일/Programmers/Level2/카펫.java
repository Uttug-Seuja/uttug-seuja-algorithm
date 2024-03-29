class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        if(yellow == 1) {
            answer[0] = 3;
            answer[1] = 3;
        } else {
            for(int i = 1; i <= yellow/2; i++) {
                if(yellow % i == 0) {
                    int sum = ((i+2) * ((yellow/i) + 2)) - yellow;
                    if(sum == brown) {
                        answer[0] = Math.max(i, yellow/i) + 2;
                        answer[1] = Math.min(i, yellow/i) + 2;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}
