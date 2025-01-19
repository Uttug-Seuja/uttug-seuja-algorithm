class `1562` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()

        val mod = 1_000_000_000

        val dp = Array(n) { Array(10) { IntArray(1 shl 10) { 0 } } }

        for (k in 1..9) {
            dp[0][k][1 shl k] = 1
        }

        for (i in 1 until n) {
            for (k in 0..9) {
                for (bit in 0 until (1 shl 10)) {
                    if (k - 1 >= 0) {
                        val newBit = bit or (1 shl k)
                        dp[i][k][newBit] = (dp[i][k][newBit] + dp[i - 1][k - 1][bit]) % mod
                    }
                    if (k + 1 <= 9) {
                        val newBit = bit or (1 shl k)
                        dp[i][k][newBit] = (dp[i][k][newBit] + dp[i - 1][k + 1][bit]) % mod
                    }
                }
            }
        }

        var answer = 0
        for (k in 0..9) {
            answer = (answer + dp[n - 1][k][1023]) % mod
        }

        sb.append(answer)

        bw.write(sb.toString())

        br.close()
        bw.close()

//        9 8 7 6 5 4 3 2 1 0

//        9 8 7 6 5 4 3 2 1 0 1
//        8 9 8 7 6 5 4 3 2 1 0

//        9 8 7 6 5 4 3 2 1 0 1 0
//        9 8 7 6 5 4 3 2 1 0 1 2
//        8 9 8 7 6 5 4 3 2 1 0 1
//        9 8 9 8 7 6 5 4 3 2 1 0
//        7 8 9 8 7 6 5 4 3 2 1 0

    }
}


fun main() {
    `1562`().solution()
}
