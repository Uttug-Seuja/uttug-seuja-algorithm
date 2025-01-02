class Solution {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var answer: Int = 0
        var start = diffs.minOf { it }
        var end = diffs.maxOf { it }

        while (start <= end) {
            val mid = (start + end) / 2
            
            if (calculate(mid, diffs, times, limit)) {
                answer = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return answer
    }

    fun calculate(level : Int, diffs: IntArray, times: IntArray, limit: Long) : Boolean {
        val n = diffs.size
        var currentTime = 0L
        repeat(n) { i ->
            if (diffs[i] <= level) {
                currentTime += times[i]
            } else {
                val time = if (i == 0) times[i] else times[i] + times[i - 1]
                currentTime += times[i] + (diffs[i] - level) * time
            }

            if (limit < currentTime) return false
        }
        
        return true
    }
}
