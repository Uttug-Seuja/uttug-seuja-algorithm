class `32530` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()

        val times = mutableListOf<Int>()
        repeat(n) {
            val time = br.readLine().split(":").map { it.toInt() }
            val minute = time.first() * 60 + time.last()
            times.add(minute)
        }

        times.sort()

        var answer = 1
        var target = times.first() + 10
        for (i in 1 until times.size) {
            val time = times[i]

            if (target < time) {
                target = time + 10
                answer++
            }
        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()

    }
}

fun main() {
    `32530`().solution()
}
