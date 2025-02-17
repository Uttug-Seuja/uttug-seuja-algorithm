import java.util.PriorityQueue
import kotlin.math.ceil

class `24042` {
    data class Node(val destination: Int, val time: Long = 0)

    lateinit var graph: Array<MutableList<Node>>
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        graph = Array(n + 1) { mutableListOf() }

        repeat(m) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            graph[a].add(Node(b, it.toLong()))
            graph[b].add(Node(a, it.toLong()))
        }

        sb.append(dijkstra(n, m))
        bw.write(sb.toString())
        br.close()
        bw.close()
    }

    fun dijkstra(n: Int, m: Int): Long {
        val pq = PriorityQueue<Node> { o1, o2 ->
            (o1.time - o2.time).toInt()
        }

        pq.add(Node(1, 0))

        val visited = LongArray(n + 1) { Long.MAX_VALUE }
        visited[1] = 0

        while (pq.isNotEmpty()) {
            val (destination, time) = pq.poll()

            if (destination == n) return time

            for ((d, t) in graph[destination]) {
                val nt = m * ceil(((time - t).toDouble() / m)).toLong() + t + 1
                if (visited[d] <= nt) continue

                visited[d] = nt
                pq.add(Node(d, nt))
            }
        }

        return -1
    }
}

fun main() {
    `24042`().solution()
}
