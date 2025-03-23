import kotlin.math.abs

class `2467` {
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }

        var start = 0
        var end = n - 1
        var target = Int.MAX_VALUE
        var answer = IntArray(2)
        while (start < end) {
            val mid = arr[start] + arr[end]

            if (abs(mid) < target) {
                target = abs(mid)
                answer = intArrayOf(arr[start], arr[end])
            }

            if (mid == 0) break

            if (mid < 0) {
                start++
            } else {
                end--
            }
        }

        sb.append(answer.joinToString(" "))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `2467`().solve()
}
