import java.math.BigInteger

class `10826` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val dp = Array(n + 1) { BigInteger.ZERO }
        if (n > 0) dp[1] = BigInteger.ONE
        if (n > 1) dp[2] = BigInteger.ONE

        for (i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        sb.append(dp[n])
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `10826`().solution()
}
