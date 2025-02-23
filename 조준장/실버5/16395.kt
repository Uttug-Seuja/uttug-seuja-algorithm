class `16395` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val dp = Array(n + 1) { mutableListOf<Int>() }
        dp[0] = mutableListOf(1)

        for (i in 1 until n) {
            for (j in 0 until i + 1) {
                if (j == 0 || j == i) {
                    dp[i].add(1)
                    continue
                }
                val target = dp[i - 1][j - 1] + dp[i - 1][j]
                dp[i].add(target)
            }
        }

        sb.append(dp[n - 1][k - 1])
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `16395`().solution()
}
