class `16194` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }

        val dp = IntArray(n + 1)
        for (i in 1..n) {
            dp[i] = arr[i - 1]
            for (j in 1 until i) {
                dp[i] = minOf(dp[i], dp[i - j] + dp[j])
            }
        }

        sb.append(dp[n])
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `16194`().solution()
}
