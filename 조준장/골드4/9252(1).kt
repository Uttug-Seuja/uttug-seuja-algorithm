class `9252` {
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val a = br.readLine().toString()
        val b = br.readLine().toString()

        val dp = Array(a.length + 1) { IntArray(b.length + 1) }

        for (i in 1..a.length) {
            for (j in 1..b.length) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        val size = dp[a.length][b.length]
        sb.append(size).append("\n")
        if (size != 0) {
            var answerStr = ""
            var i = a.length
            var j = b.length

            while (i > 0) {
                when (dp[i][j]) {
                    dp[i - 1][j] -> i--
                    dp[i][j - 1] -> j--
                    else -> {
                        i--
                        j--
                        answerStr = a[i] + answerStr
                    }

                }
            }

            sb.append(answerStr)
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `9252`().solve()
}
