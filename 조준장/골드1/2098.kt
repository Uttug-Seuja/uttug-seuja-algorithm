import kotlin.math.min

class `2098` {

    val dp = Array(16) { IntArray(1 shl 16) { -1 } }
    lateinit var graph: Array<List<Int>>
    var n = 0
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
        const val INF = 20000000
    }
}

fun main() {
    `2098`().solution()
}
//4
//0 10 15 20
//5 0 9 10
//6 13 0 12
//8 8 9 0
