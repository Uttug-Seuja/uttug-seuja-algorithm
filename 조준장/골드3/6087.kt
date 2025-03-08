import java.util.PriorityQueue

class `6087` {
    data class Node(val x: Int, val y: Int, val d: Int, val mirror: Int)

    lateinit var graph: List<List<String>>
    lateinit var visited: Array<Array<IntArray>>
    val cArr: MutableList<Node> = mutableListOf()

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        graph = List(h) { i ->
            br.readLine().mapIndexed { j, c ->
                if (c == 'C') cArr.add(Node(i, j, 0, 0))
                c.toString()
            }
        }
        visited = Array(h) { Array(w) { IntArray(4) { Int.MAX_VALUE } } } // INF로 초기화
        sb.append(dijkstra(w, h))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun dijkstra(w: Int, h: Int): Int {
        val (sx, sy) = cArr.first()
        val (ex, ey) = cArr.last()

        val queue = PriorityQueue<Node> { o1, o2 ->
            o1.mirror - o2.mirror
        }
        queue.add(Node(sx, sy, -1, 0))

        while (queue.isNotEmpty()) {
            val (x, y, d, mirror) = queue.poll()

            if (x == ex && y == ey) return mirror

            repeat(4) { nd ->
                val nx = x + dx[nd]
                val ny = y + dy[nd]

                if (nx in 0 until h && ny in 0 until w && graph[nx][ny] != "*") {
                    val nMirror = if (d != nd && d != -1) mirror + 1 else mirror
                    if (visited[nx][ny][nd] > nMirror) {
                        visited[nx][ny][nd] = nMirror
                        queue.add(Node(nx, ny, nd, nMirror))
                    }
                }
            }
        }
        return 0
    }
}

fun main() {
    `6087`().solution()
}
