class `14442` {
    data class Node(val x: Int, val y: Int, val k: Int)

    lateinit var graph: List<List<Int>>

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
        graph = List(n) { br.readLine().map { it.toString().toInt() } }

        sb.append(bfs(n, m, k))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun bfs(n: Int, m: Int, sk: Int): Int {
        val deque = ArrayDeque<Node>()
        deque.add(Node(0, 0, sk))

        val visited = Array(n) { Array(m) { IntArray(sk + 1) { -1 } } }
        visited[0][0][sk] = 1

        while (deque.isNotEmpty()) {
            val (x, y, k) = deque.removeFirst()
            val dist = visited[x][y][k]

            if (x == n - 1 && y == m - 1) {
                return dist
            }

            repeat(4) { index ->
                val nx = x + dx[index]
                val ny = y + dy[index]

                if (nx in 0 until n && ny in 0 until m) {
                    if (graph[nx][ny] == 0 && visited[nx][ny][k] == -1) {
                        // 벽이 아니면 그대로 이동
                        visited[nx][ny][k] = dist + 1
                        deque.add(Node(nx, ny, k))
                    } else if (graph[nx][ny] == 1 && k > 0 && visited[nx][ny][k - 1] == -1) {
                        // 벽을 부수고 이동
                        visited[nx][ny][k - 1] = dist + 1
                        deque.add(Node(nx, ny, k - 1))
                    }
                }
            }
        }
        return -1
    }
}

fun main() {
    `14442`().solution()
}
