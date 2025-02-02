class `2491` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }
        val reverseArr = arr.reversed()
        val dp = IntArray(n + 1) { 0 }
        val reverseDp = IntArray(n + 1) { 0 }

        dp[0] = 1
        reverseDp[0] = 1

        for (i in 1 until n) {
            if (arr[i - 1] <= arr[i]) {
                dp[i] += dp[i - 1] + 1
            } else {
                dp[i] = 1
            }
        }

        for (i in 1 until n) {
            if (reverseArr[i - 1] <= reverseArr[i]) {
                reverseDp[i] += reverseDp[i - 1] + 1
            } else {
                reverseDp[i] = 1
            }
        }

        sb.append(maxOf(dp.max(), reverseDp.max()))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `2491`().solution()
}
