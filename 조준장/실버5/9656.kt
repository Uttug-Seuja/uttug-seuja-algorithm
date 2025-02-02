class `9656` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val dp = BooleanArray(n + 1) { false }

        if (n >= 1) dp[1] = true
        if (n >= 2) dp[2] = false
        if (n >= 3) dp[3] = true

        for (i in 4..n) {
            dp[i] = !dp[i - 1] || !dp[i - 3]
        }

        sb.append(if (dp[n]) "CY" else "SK")
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `9656`().solution()
}
