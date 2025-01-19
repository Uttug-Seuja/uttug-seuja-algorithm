import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution2473 {
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toLong() }.sorted()

        var closestSum = Long.MAX_VALUE
        var answerTriple = Triple(0L, 0L, 0L)

        for (i in 0 until n - 2) {
            var left = i + 1
            var right = n - 1

            while (left < right) {
                val currentSum = arr[i] + arr[left] + arr[right]
                val absCurrentSum = kotlin.math.abs(currentSum)
                val absClosestSum = kotlin.math.abs(closestSum)

                if (absCurrentSum < absClosestSum) {
                    closestSum = currentSum
                    answerTriple = Triple(arr[i], arr[left], arr[right])

                    if (closestSum == 0L) break
                }

                if (currentSum < 0) {
                    left++
                } else {
                    right--
                }
            }

            if (closestSum == 0L) break
        }

        sb.append("${answerTriple.first} ${answerTriple.second} ${answerTriple.third}")
        bw.write(sb.toString())
        bw.flush()
        br.close()
        bw.close()
    }
}

fun main() {
    Solution2473().solution()
}
