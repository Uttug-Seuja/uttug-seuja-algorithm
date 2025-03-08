class `16954` {
    data class Node(val x: Int, val y: Int, val time: Int)

    lateinit var graph: MutableList<List<String>>
    lateinit var visited: Array<Array<BooleanArray>>

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        graph = MutableList(8) { br.readLine().map { it.toString() } }
        visited = Array(8) { Array(8) { BooleanArray(17) } }

        sb.append(bfs())
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    val dx = arrayOf(0, 0, 0, 1, 1, -1, -1, 1, -1)
    val dy = arrayOf(0, 1, -1, 0, -1, 0, 1, 1, -1)

    fun bfs(): Int {
        val deque = ArrayDeque<Node>()
        deque.add(Node(7, 0, 0))

        while (deque.isNotEmpty()) {
            repeat(deque.size) {
                val (x, y, t) = deque.removeFirst()

                if (x == 0 && y == 7) return 1

                if (graph[x][y] == "#") return@repeat

                repeat(9) { i ->
                    val nx = x + dx[i]
                    val ny = y + dy[i]
                    val nt = t + 1

                    if (nx in 0 until 8 && ny in 0 until 8 && nt < 17 && graph[nx][ny] == ".") {
                        if (!visited[nx][ny][nt]) {
                            visited[nx][ny][nt] = true
                            deque.addLast(Node(nx, ny, nt))
                        }
                    }
                }
            }

            if (graph.any { "#" in it }) {
                graph.removeLast()
                graph.add(0, MutableList(8) { "." })
            }
        }

        return 0
    }
}

fun main() {
    `16954`().solution()
}


