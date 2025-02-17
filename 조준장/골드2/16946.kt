class `16946` {

    data class Node(val x: Int, val y: Int)

    lateinit var graph: List<MutableList<Int>>
    lateinit var moveGraph: List<MutableList<Pair<Int, Int>>>

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        graph = List(n) { br.readLine().map { it.toString().toInt() }.toMutableList() }
        moveGraph = List(n) { MutableList(m) { Pair(0, 0) } }
        initMoveGraph(n, m)
        moveCheck(n, m)

        graph.forEach {
            sb.append(it.joinToString("")).append("\n")
        }
        bw.write(sb.dropLast(1).toString())

        br.close()
        bw.close()

    }

    fun initMoveGraph(n: Int, m: Int) {
        var num = 1
        val visited = Array(n + 1) { BooleanArray(m + 1) { false } }
        val deque = ArrayDeque<Node>()

        repeat(n) { x ->
            repeat(m) { y ->
                var count = 1
                val loc = mutableListOf(Pair(x, y))
                if (!visited[x][y] && graph[x][y] == 0) {
                    visited[x][y] = true
                    deque.add(Node(x, y))

                    while (deque.isNotEmpty()) {
                        val (sx, sy) = deque.removeFirst()

                        repeat(4) { index ->
                            val nx = sx + dx[index]
                            val ny = sy + dy[index]

                            if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && graph[nx][ny] == 0) {
                                visited[nx][ny] = true
                                deque.add(Node(nx, ny))
                                count++
                                loc.add(Pair(nx, ny))
                            }
                        }

                    }

                    loc.forEach { (sx, sy) ->
                        moveGraph[sx][sy] = Pair(num, count)
                    }
                    num++
                }
            }
        }
    }

    fun moveCheck(n: Int, m: Int) {
        repeat(n) { x ->
            repeat(m) { y ->
                var count = 1
                val visited = mutableSetOf<Int>()
                if (graph[x][y] == 1) {
                    repeat(4) { index ->
                        val nx = x + dx[index]
                        val ny = y + dy[index]
                        if (nx in 0 until n && ny in 0 until m && graph[nx][ny] == 0) {
                            if (moveGraph[nx][ny].first !in visited) {
                                visited.add(moveGraph[nx][ny].first)
                                count += moveGraph[nx][ny].second
                            }
                        }
                    }
                    graph[x][y] = count % 10
                }
            }
        }

    }
}

fun main() {
    `16946`().solution()
}
