class `11066` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val t = br.readLine().toInt()

        repeat(t) {
            val k = br.readLine().toInt()
            val arr = br.readLine().split(" ").map { it.toInt() }

            val sum = IntArray(k + 1)
            val dp = Array(k) { IntArray(k) }

            for (i in 1..k) {
                sum[i] = sum[i - 1] + arr[i - 1]
            }

            for (d in 1 until k) {
                for (i in 0 until k - d) {
                    val j = i + d
                    dp[i][j] = Int.MAX_VALUE

                    for (mid in i until j) {
                        dp[i][j] = minOf(dp[i][j], dp[i][mid] + dp[mid + 1][j] + sum[j + 1] - sum[i])
                    }
                }
            }
            sb.append(dp[0][k - 1]).append("\n")
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `11066`().solution()

}
