class `5052` {
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val t = br.readLine().toInt()

        loot@ for (i in 0 until t) {
            val n = br.readLine().toInt()
            val arr = Array(n) { br.readLine().toString() }.sorted()

            for (j in 0 until n - 1) {
                val minLength = minOf(arr[j].length, arr[j + 1].length)
                if (arr[j] == arr[j + 1].substring(0, minLength)) {
                    sb.append("NO\n")
                    continue@loot
                }
            }

            sb.append("YES\n")
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `5052`().solve()
}
