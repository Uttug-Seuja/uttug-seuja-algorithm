class `16234` {
    data class Node(val x: Int, val y: Int)

    lateinit var graph: List<MutableList<Int>>
    lateinit var visited: Array<BooleanArray>

    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, l, r) = br.readLine().split(" ").map { it.toInt() }
        graph = List(n) { br.readLine().split(" ").map { it.toInt() }.toMutableList() }
        var answer = 0
        while (true) {
            var flag = false
            visited = Array(n + 1) { BooleanArray(n + 1) }

            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (!visited[i][j]) {
                        val nodes = bfs(n, l, r, i, j)

                        if (nodes.size == 1) continue
                        flag = true

                        val num = nodes.sumOf { (x, y) -> graph[x][y] } / nodes.size
                        nodes.forEach { (x, y) ->
                            graph[x][y] = num
                        }
                    }
                }
            }

            if (!flag) break
            answer++
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()

    }

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun bfs(n: Int, l: Int, r: Int, x: Int, y: Int): List<Node> {
        val node = Node(x, y)
        val nodes = mutableListOf<Node>()
        val deque = ArrayDeque<Node>()
        deque.add(node)
        visited[x][y] = true

        while (deque.isNotEmpty()) {
            val (sx, sy) = deque.removeFirst()

            nodes.add(Node(sx, sy))

            repeat(4) { i ->
                val nx = sx + dx[i]
                val ny = sy + dy[i]

                if (nx in 0 until n && ny in 0 until n && !visited[nx][ny]) {
                    if (Math.abs(graph[sx][sy] - graph[nx][ny]) in l..r) {
                        visited[nx][ny] = true
                        deque.add(Node(nx, ny))
                    }
                }
            }
        }
        return nodes
    }

}

fun main() {
    `16234`().solve()
}
