class `11657` {
    lateinit var dist: LongArray

    data class Edge(val start: Int, val end: Int, val time: Int)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val edges = mutableListOf<Edge>()
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        repeat(m) {
            val (start, end, time) = br.readLine().split(" ").map { it.toInt() }
            val edge = Edge(start, end, time)
            edges.add(edge)

        }

        dist = LongArray(n + 1) { Long.MAX_VALUE }.apply {
            this[1] = 0L
        }

        if (bellmanFord(n, edges)) {
            sb.append("-1\n")
        } else {
            for (i in 2..n) {
                if (dist[i] == Long.MAX_VALUE) {
                    sb.append("-1\n")
                } else {
                    sb.append("${dist[i]}\n")
                }
            }
        }

        bw.write(sb.dropLast(1).toString())

        br.close()
        bw.close()
    }

    fun bellmanFord(n: Int, edges: List<Edge>): Boolean {
        for (i in 1..n - 1) {
            for (edge in edges) {
                val (start, end, time) = edge

                if (dist[start] != Long.MAX_VALUE && dist[start] + time < dist[end]) {
                    dist[end] = dist[start] + time
                }
            }
        }

        for (edge in edges) {
            val (start, end, time) = edge

            if (dist[start] != Long.MAX_VALUE && dist[start] + time < dist[end]) {
                return true
            }
        }

        return false
    }
}


fun main() {
    `11657`().solution()
}
