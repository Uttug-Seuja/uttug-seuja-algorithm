import java.util.PriorityQueue

class `14938` {
    data class Node(val destination: Int, val dist: Int)

    lateinit var graph: Array<MutableList<Node>>
    lateinit var items: List<Int>

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
        items = br.readLine().split(" ").map { it.toInt() }
        graph = Array(n + 1) { mutableListOf<Node>() }

        repeat(r) {
            val (a, b, l) = br.readLine().split(" ").map { it.toInt() }

            graph[a].add(Node(b, l))
            graph[b].add(Node(a, l))
        }

        var answer = Int.MIN_VALUE
        repeat(n) {
            val visited = dijkstra(n, m, it + 1)
            var itemCount = 0
            visited.forEachIndexed { index, dist ->
                if (dist <= m) {
                    itemCount += items[index - 1]
                }
            }

            answer = maxOf(answer, itemCount)
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }


    fun dijkstra(n: Int, m: Int, start: Int): List<Int> {
        val visited = MutableList(n + 1) { Int.MAX_VALUE }
        visited[start] = 0
        val pq = PriorityQueue<Node> { o1, o2 ->
            o1.dist - o2.dist
        }
        pq.add(Node(start, 0))

        while (pq.isNotEmpty()) {
            val next = pq.poll()

            for (dNode in graph[next.destination]) {
                if (next.dist + dNode.dist < visited[dNode.destination] && next.dist + dNode.dist <= m) {
                    visited[dNode.destination] = next.dist + dNode.dist
                    val newNode = Node(dNode.destination, next.dist + dNode.dist)
                    pq.add(newNode)
                }
            }
        }

        return visited.toList()
    }
}


fun main() {
    `14938`().solution()
}
