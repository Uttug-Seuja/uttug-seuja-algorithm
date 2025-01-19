class `12865` {

    data class Article(val w: Int, val v: Int)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val articles = Array(n) {
            val input = br.readLine().split(" ").map { it.toInt() }
            Article(input.first(), input.last())
        }

        val dp = Array(n + 1) { IntArray(k + 1) }

        // i -> 가져갈 물건의 위치
        // j -> 배낭이 버틸 수 있는 무게
        for (i in 1..n) {
            for (j in 1..k) {
                val (w, v) = articles[i - 1]

                if (w > j) {
                    dp[i][j] = dp[i - 1][j]
                } else {

                    dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - w] + v)

                }
            }
        }

        sb.append(dp[n][k])
        bw.write(sb.toString())

        br.close()
        bw.close()
      
    }


}

fun main() {
    `12865`().solution()
}
