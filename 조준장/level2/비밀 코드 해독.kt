class Solution {
    var combinationNums = mutableListOf<List<Int>>()
    fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
        var answer: Int = 0

        val k = q.size
        combinations(n, 1, listOf())
        
        combinationNums.forEach { combinationNum ->
            var flag = true
            for (i in 0 until k) {
                if (q[i].intersect(combinationNum).size != ans[i]) {
                    flag = false
                    break
                }
            }
            
            if (flag) answer++
        }

        return answer
    }

    fun combinations(n : Int, start : Int, nums : List<Int>) {
        if (5 <= nums.size) {
            combinationNums.add(nums)
            return
        }

        for (i in start .. n) {
            combinations(n, i + 1, nums + i)
        }

    }
}
