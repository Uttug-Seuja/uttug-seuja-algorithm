class `7579` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val activatedApp = listOf(0) + br.readLine().split(" ").map { it.toInt() }
        val cost = listOf(0) + br.readLine().split(" ").map { it.toInt() }

        val dp = Array(n + 1) { IntArray(100_001) }

        for (i in 1..n) {
            for (j in 0 until 100_001) {
                // i번째 앱의 바용이 현재 탐색하고 있는 비용 j 보다 크다면
                // i번째 앱을 활성화시킬 수 없음
                // 현재 탐색하고 있는 비용인 j 보다 작다면 이전 j번째 비용과 i 번째 앱을 활성화시켰을 때 비용을 비교한다.
                if (cost[i] > j) {
                    dp[i][j] = dp[i - 1][j]
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - cost[i]] + activatedApp[i])
                }
            }
        }


        for (i in 0..100_000) {
            if (dp[n][i] >= m) {
                sb.append(i)

                break
            }
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `7579`().solution()
}
