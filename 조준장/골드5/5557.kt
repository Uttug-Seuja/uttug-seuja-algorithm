class `5557` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }
        val dp = Array(101) { LongArray(21) }

        dp[0][arr[0]] = 1L

        for (i in 1 until n - 1) {
            for (j in 0..20) {
                if (dp[i - 1][j] != 0L) {
                    if (j + arr[i] <= 20) dp[i][j + arr[i]] += dp[i - 1][j]
                    if (j - arr[i] >= 0) dp[i][j - arr[i]] += dp[i - 1][j]
                }
            }
        }

        sb.append(dp[n - 2][arr[n - 1]])
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `5557`().solution()
}
