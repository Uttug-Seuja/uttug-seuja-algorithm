class `2638` {

    data class Node(val x: Int, val y: Int)

    lateinit var graph: Array<MutableList<Int>>
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toMutableList() }


        var answer = 0
        while (true) {
            val result = graph.map { row ->
                row.all { it == 0 }
            }

            if (result.all { it }) break
            bfs(n, m)
            answer++
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()

    }

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun bfs(n: Int, m: Int) {
        val visited = Array(n) { IntArray(m) }
        visited[0][0] = 1
        val deque = ArrayDeque<Node>()
        deque.add(Node(0, 0))

        while (deque.isNotEmpty()) {
            val (x, y) = deque.removeFirst()

            repeat(4) {
                val nx = x + dx[it]
                val ny = y + dy[it]

                if (nx in 0..n - 1 && ny in 0..m - 1) {
                    if (graph[nx][ny] == 0 && visited[nx][ny] == 0) {
                        deque.add(Node(nx, ny))
                    }
                    visited[nx][ny]++

                }
            }

        }

        repeat(n) { i ->
            repeat(m) { j ->
                if (graph[i][j] == 1 && visited[i][j] >= 2) {
                    graph[i][j] = 0
                }
            }
        }
    }
}


fun main() {
    `2638`().solution()
}
