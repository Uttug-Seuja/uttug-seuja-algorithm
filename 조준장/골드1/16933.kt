class `16933` {
    data class Node(val x: Int, val y: Int, val k: Int, val isMorning: Boolean)

    lateinit var graph: List<List<Int>>

    fun solution() {
        val br = System.`in`.bufferedReader()

        val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
        graph = List(n) { br.readLine().map { it.toString().toInt() } }

        println(bfs(n, m, k))
    }

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun bfs(n: Int, m: Int, sk: Int): Int {
        val deque = ArrayDeque<Node>()
        deque.add(Node(0, 0, sk, true))

        // visited[x][y][k] -> k개의 벽을 부술 수 있을 때 방문 여부
        val visited = Array(n) { Array(m) { BooleanArray(sk + 1) } }
        visited[0][0][sk] = true

        var dist = 1

        while (deque.isNotEmpty()) {
            repeat(deque.size) {
                val (x, y, k, isMorning) = deque.removeFirst()

                // 도착지 도달 시 최단 거리 반환
                if (x == n - 1 && y == m - 1) return dist

                repeat(4) { index ->
                    val nx = x + dx[index]
                    val ny = y + dy[index]

                    if (nx in 0 until n && ny in 0 until m) {
                        if (graph[nx][ny] == 0 && !visited[nx][ny][k]) {
                            visited[nx][ny][k] = true
                            deque.add(Node(nx, ny, k, !isMorning))
                        } else if (graph[nx][ny] == 1 && k > 0 && !visited[nx][ny][k - 1]) {
                            if (isMorning) {
                                visited[nx][ny][k - 1] = true
                                deque.add(Node(nx, ny, k - 1, false))
                            } else {
                                deque.add(Node(x, y, k, true))
                            }
                        }
                    }
                }
            }
            dist++
        }
        return -1
    }
}

fun main() {
    `16933`().solution()
}
