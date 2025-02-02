class `14916` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0

        for (i in 1..n) {
            if (i >= 2 && dp[i - 2] != Int.MAX_VALUE) dp[i] = minOf(dp[i], dp[i - 2] + 1)
            if (i >= 5 && dp[i - 5] != Int.MAX_VALUE) dp[i] = minOf(dp[i], dp[i - 5] + 1)
        }

        val answer = if (dp[n] == Int.MAX_VALUE) -1 else dp[n]
        sb.append(answer)
        bw.write(answer.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `14916`().solution()
}
