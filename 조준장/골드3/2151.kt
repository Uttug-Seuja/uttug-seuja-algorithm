import java.util.PriorityQueue

class `2151` {

    data class Node(val x: Int, val y: Int, val d: Int = 0, val mirrorCount: Int = 0)

    val mirrors = mutableListOf<Node>()
    val doors = mutableListOf<Node>()
    lateinit var graph: List<List<String>>
    lateinit var visited: List<List<BooleanArray>>
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        graph = List(n) { i ->
            br.readLine().mapIndexed { j, c ->
                if (c == '#') mirrors.add(Node(i, j))
                else if (c == '!') doors.add(Node(i, j))
                c.toString()
            }
        }
        visited = List(n) { List(n) { BooleanArray(4) } }

        sb.append(dijkstra(n))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, -1, 0, 1)

    fun dijkstra(n: Int): Int {
        val (sx, sy) = mirrors.first()
        val (ex, ey) = mirrors.last()

        val queue = PriorityQueue<Node> { o1, o2 ->
            o1.mirrorCount - o2.mirrorCount
        }

        repeat(4) {
            queue.add(Node(sx, sy, it))
        }


        while (queue.isNotEmpty()) {
            val (x, y, d, mirrorCount) = queue.poll()

            if (ex == x && ey == y) return mirrorCount
            visited[x][y][d] = true

            val nx = x + dx[d]
            val ny = y + dy[d]
            if (nx in 0 until n && ny in 0 until n && graph[nx][ny] != "*" && !visited[nx][ny][d]) {
                if (graph[nx][ny] == "!") {
                    queue.add(Node(nx, ny, (d + 3) % 4, mirrorCount + 1))
                    queue.add(Node(nx, ny, (d + 1) % 4, mirrorCount + 1))
                }
                queue.add(Node(nx, ny, d, mirrorCount))
            }
        }
        return -1
    }
}

fun main() {
    `2151`().solution()
}
