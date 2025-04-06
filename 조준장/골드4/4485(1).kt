import java.util.PriorityQueue

class `4485` {
    data class Node(val x: Int, val y: Int, val cost: Int)

    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()
        var index = 0
        while (true) {
            index++
            val n = br.readLine().toInt()
            if (n == 0) break

            val graph = List(n) { br.readLine().split(" ").map { it.toInt() } }
            val problem = dijkstra(n, graph)
            sb.append("Problem $index: $problem\n")
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun dijkstra(n: Int, graph: List<List<Int>>): Int {
        val visited = List(n) { IntArray(n) { Int.MAX_VALUE } }
        val pq = PriorityQueue<Node> { o1, o2 ->
            o1.cost - o2.cost
        }
        pq.add(Node(0, 0, graph[0][0]))
        visited[0][0] = graph[0][0]

        while (pq.isNotEmpty()) {
            val (x, y, cost) = pq.poll()

            if (x == n - 1 && y == n - 1) continue

            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx !in 0 until n || ny !in 0 until n) continue

                val newCost = cost + graph[nx][ny]

                if (newCost < visited[nx][ny]) {
                    visited[nx][ny] = newCost
                    val node = Node(nx, ny, newCost)
                    pq.add(node)
                }

            }
        }

        return visited[n - 1][n - 1]
    }
}

fun main() {
    `4485`().solve()
}
