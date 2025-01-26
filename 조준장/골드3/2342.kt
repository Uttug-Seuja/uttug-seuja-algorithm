class `2342` {

    val graph = arrayOf(
        arrayOf(0, 2, 2, 2, 2),
        arrayOf(2, 1, 3, 4, 3),
        arrayOf(2, 3, 1, 3, 4),
        arrayOf(2, 4, 3, 1, 3),
        arrayOf(2, 3, 4, 3, 1)
    )
    lateinit var arr: List<Int>
    var size = 0
    lateinit var dp: Array<Array<IntArray>>

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        arr = br.readLine().split(" ").map { it.toInt() }
        size = arr.size - 1
        dp = Array(size) { Array(5) { IntArray(5) } }
        sb.append(dfs(0, 0, 0))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun dfs(depth: Int, left: Int, right: Int): Int {
        if (depth == size) return 0
        if (dp[depth][left][right] != 0) return dp[depth][left][right]

        val next = arr[depth]

        dp[depth][left][right] = minOf(
            dfs(depth + 1, next, right) + graph[left][next], 
            dfs(depth + 1, left, next) + graph[right][next]
        )

        return dp[depth][left][right]
    }
}

fun main() {
    `2342`().solution()
}


/**
 * 1 3 2 4 1 2 0
 * 14
 *
 * 1 3 2 2 2 1 0
 * 10
 *
 * 1 2 3 2 0
 * 8
 *
 * 1 2 3 2 1 0
 * 11
 * */
