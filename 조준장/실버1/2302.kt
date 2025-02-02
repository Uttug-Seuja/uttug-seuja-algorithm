class `2302` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val m = br.readLine().toInt()

        val dp = IntArray(41)
        dp[1] = 1
        dp[2] = 2

        for (i in 3..40) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        var answer = 1
        var num = 0

        repeat(m) {
            val vip = br.readLine().toInt()
            if (vip - num - 1 != 0) {
                answer *= dp[vip - num - 1]
            }
            num = vip
        }

        if (n - num != 0) {
            answer *= dp[n - num]
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `2302`().solution()
}
