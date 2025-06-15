class `9251` {
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val a = br.readLine().toString()
        val b = br.readLine().toString()

        sb.append(lcsLength(a, b))

        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun lcsLength(a: String, b: String): Int {
        val lenA = a.length
        val lenB = b.length

        val dp = Array(lenA + 1) { IntArray(lenB + 1) }

        for (i in 1..lenA) {
            for (j in 1..lenB) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        return dp[lenA][lenB]
    }

}

fun main() {
    `9251`().solve()
}
