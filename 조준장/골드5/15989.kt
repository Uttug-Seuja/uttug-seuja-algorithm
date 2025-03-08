package org.example

class `15989` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val t = br.readLine().toInt()
        val dp = IntArray(10001) { 1 }

        for (i in 2..10000) {
            dp[i] += dp[i - 2]
        }

        for (i in 3..10000) {
            dp[i] += dp[i - 3]
        }
        repeat(t) {
            val n = br.readLine().toInt()
            sb.append(dp[n]).append("\n")
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `15989`().solution()
}

/**
 * 1 -> 1
 * 2 -> 1 1, 2
 * 3 -> 1 1 1, 1 2, 3
 * 4 -> 1 1 1 1, 1 1 2, 2 2, 1 3
 * 5 -> 1 1 1 1 1, 1 1 1 2, 1 2 2, 1 1 3, 3 2
 * 6 -> 1 1 1 1 1, 1 1 1 1 2, 1 1 2 2, 1 1 1 3, 1 3 2, / 2 2 2, 3 3
 * 7 -> 1 1 1 1 1 1. 1 1 1 1 2. 1 1 1 2 2, 1 1 1 1 3, 1 1 3 2, 1 2 2 2, 1 3 3 / 3 2 2
 *
 *
 * */
