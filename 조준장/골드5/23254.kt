import java.util.PriorityQueue

class `23254` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val a = br.readLine().split(" ").map { it.toInt() }
        val b = br.readLine().split(" ").map { it.toInt() }

        val subjects = a.zip(b).sortedByDescending { it.second }
        var answer = a.sumOf { it }.toLong()
        var left = 24 * n
        val queue = PriorityQueue<Int>(reverseOrder())

        for ((score, increase) in subjects) {
            while (left > 0 && queue.isNotEmpty() && queue.first() >= increase) {
                answer += queue.poll()
                left--
            }

            if (left == 0) break

            val limit = (100 - score) / increase
            val space = (100 - score) % increase
            val can = limit.coerceAtMost(left)

            answer += increase * can
            left -= can
            queue.add(space)
        }

        while (left > 0 && queue.isNotEmpty()) {
            answer += queue.poll()
            left--
        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()

    }
}

fun main() {
    `23254`().solution()
}
