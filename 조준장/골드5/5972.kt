import java.util.PriorityQueue

class `5972` {
    data class Node(val destination: Int, val depth: Int)

    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(n + 1) { mutableListOf<Node>() }
        repeat(m) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            graph[a].add(Node(b, c))
            graph[b].add(Node(a, c))
        }

        val visited = IntArray(n + 1) { Int.MAX_VALUE }
        visited[1] = 0
        val deque = PriorityQueue<Node> { o1, o2 ->
            o1.depth - o2.depth

        }
        deque.add(Node(1, 0))

        while (deque.isNotEmpty()) {
            val (destination, depth) = deque.poll()

            if (destination == n) {
                visited[destination] = minOf(visited[destination], depth)
                break
            }

            for ((nDestination, nDepth) in graph[destination]) {
                if (visited[destination] + nDepth < visited[nDestination]) {
                    visited[nDestination] = visited[destination] + nDepth
                    deque.add(Node(nDestination, visited[destination] + nDepth))
                }
            }
        }

        sb.append(visited[n])
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}


fun main() {
    `5972`().solve()
}
