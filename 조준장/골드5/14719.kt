import kotlin.math.min

class `14719` {
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (h, w) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { it.toInt() }

        var answer = 0
        for (i in 1 until w) {
            val left = arr.subList(0, i).maxOrNull() ?: 0
            val right = arr.subList(i + 1, w).maxOrNull() ?: 0

            val compare = min(left, right)

            if (arr[i] < compare) {
                answer += compare - arr[i]
            }
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `14719`().solve()
}
