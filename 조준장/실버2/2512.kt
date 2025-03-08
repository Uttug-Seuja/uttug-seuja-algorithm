class `2512` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }
        val m = br.readLine().toInt()

        var answer = 0
        var start = 1
        var end = arr.max()

        while (start <= end) {
            var total = 0
            val mid = (start + end) / 2

            arr.forEach {
                total += if (it <= mid) {
                    it
                } else {
                    mid
                }
            }

            if (total <= m) {
                start = mid + 1
                answer = mid
            } else {
                end = mid - 1
            }
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `2512`().solution()
}
