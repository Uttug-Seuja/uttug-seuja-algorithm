class `1865` {

    data class Edge(val start: Int, val end: Int, val time: Int)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val T = br.readLine().toInt()

        repeat(T) {
            val (n, m, w) = br.readLine().split(" ").map { it.toInt() }

            val edges = mutableListOf<Edge>()

            repeat(m) {
                val (s, e, t) = br.readLine().split(" ").map { it.toInt() }
                edges.add(Edge(s, e, t))
                edges.add(Edge(e, s, t))
            }

            repeat(w) {
                val (s, e, t) = br.readLine().split(" ").map { it.toInt() }
                edges.add(Edge(s, e, -t))
            }

            if (bellmanFord(n, edges)) {
                sb.append("YES\n")
            } else {
                sb.append("NO\n")
            }
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    private fun bellmanFord(n: Int, edges: List<Edge>): Boolean {
        val dist = IntArray(n + 1) { 0 }

        for (i in 1 until n) {
            for (edge in edges) {
                val (start, end, time) = edge

                if (dist[start] + time < dist[end]) {
                    dist[end] = dist[start] + time
                }
            }
        }

        for (edge in edges) {
            val (start, end, time) = edge
            if (dist[start] + time < dist[end]) {
                return true
            }
        }

        return false
    }
}

fun main() {
    `1865`().solution()
}
