class Solution {
    public long solution(String numbers) {
        
        String[] strList = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i<strList.length; i++){
            
            numbers = numbers.replace(strList[i],String.valueOf(i));
        }
        
        return Long.parseLong(numbers);
    }
}
