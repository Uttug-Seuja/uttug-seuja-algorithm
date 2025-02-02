class `9184` {

    val dp = Array(21) { Array(21) { IntArray(21) } }

    fun w(a: Int, b: Int, c: Int): Int {
        if (a <= 0 || b <= 0 || c <= 0) return 1

        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20)

        if (dp[a][b][c] != 0) return dp[a][b][c]

        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
            return dp[a][b][c]
        }

        dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
        return dp[a][b][c]

    }

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()


        while (true) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            if (a == -1 && b == -1 && c == -1) break
            sb.append("w($a, $b, $c) = ${w(a, b, c)}\n")
        }

        bw.write(sb.toString())

        br.close()
        bw.close()

    }
}

fun main() {
    `9184`().solution()
}
