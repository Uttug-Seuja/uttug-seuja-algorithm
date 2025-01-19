import kotlin.math.min

class `10971` {
    var n: Int = 0
    lateinit var graph: Array<List<Int>>
    val dp = Array(10) { IntArray(1 shl 10) { -1 } }
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        n = br.readLine().toInt()
        graph = Array(n) {
            br.readLine().split(" ").map { it.toInt() }
        }

        sb.append(dfs(0, 1))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun dfs(start: Int, state: Int): Int {
        if (state == (1 shl n) - 1) {
            if (graph[start][0] != 0) return graph[start][0]
            return INF
        }

        if (dp[start][state] != -1) return dp[start][state]
        dp[start][state] = INF

        for (i in 0 until n) {
            if (state and (1 shl i) != 0 || graph[start][i] == 0) continue
            dp[start][state] = min(dp[start][state], graph[start][i] + dfs(i, state or (1 shl i)))
        }

        return dp[start][state]
    }

    companion object {
        const val INF = 10000000
    }
}

fun main() {
    `10971`().solution()
}
