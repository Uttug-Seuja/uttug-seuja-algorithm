class `8972` {

    data class Node(val x: Int, val y: Int)

    lateinit var graph: Array<MutableList<String>>

    val d = arrayOf(
        arrayOf(0, 0),
        arrayOf(1, -1),
        arrayOf(1, 0),
        arrayOf(1, 1),
        arrayOf(0, -1),
        arrayOf(0, 0),
        arrayOf(0, 1),
        arrayOf(-1, -1),
        arrayOf(-1, 0),
        arrayOf(-1, 1),
    )

    var r = 0
    var c = 0

    lateinit var robotD: List<Int>

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val input = br.readLine().split(" ").map { it.toInt() }
        r = input[0]
        c = input[1]
        graph = Array(r) { br.readLine().map { it.toString() }.toMutableList() }

        robotD = br.readLine().map { it.toString().toInt() }

        var startNode = Node(0, 0)
        val crazyNodes = mutableListOf<Node>()
        repeat(r) { i ->
            repeat(c) { j ->
                if (graph[i][j] == "I") {
                    startNode = Node(i, j)
                } else if (graph[i][j] == "R") {
                    crazyNodes.add(Node(i, j))
                }
            }
        }

        val result = bfs(startNode, crazyNodes)
        if (result == null) {
            graph.forEach { row ->
                sb.append(row.joinToString("")).append("\n")
            }
        } else {
            sb.append("kraj $result\n")
        }

        bw.write(sb.dropLast(1).toString())

        br.close()
        bw.close()

    }

    fun bfs(startNode: Node, crazyNodes: List<Node>): Int? {
        val deque = ArrayDeque<Node>()
        deque.addLast(startNode)

        crazyNodes.forEach { crazyNode ->
            deque.addLast(crazyNode)
        }

        var currentX = 0
        var currentY = 0
        var count = 0

        var visited = Array(r) { IntArray(c) }

        while (deque.isNotEmpty()) {
            val (x, y) = deque.removeFirst()

            if (graph[x][y] == "I") {

                repeat(r) { i ->
                    repeat(c) { j ->
                        if (visited[i][j] >= 2) {
                            graph[i][j] = "."
                        } else if (visited[i][j] == 1) {
                            graph[i][j] = "R"
                        }
                    }
                }

                visited = Array(r) { IntArray(c) }

                if (robotD.size <= count) return null

                val nd = d[robotD[count]]
                val nx = x + nd[0]
                val ny = y + nd[1]
                if (nx in 0 until r && ny in 0 until c) {
                    count++

                    if (graph[nx][ny] == "R") return count

                    val node = Node(nx, ny)
                    graph[x][y] = "."
                    graph[nx][ny] = "I"
                    currentX = nx
                    currentY = ny

                    deque.addLast(node)
                }
            } else if (graph[x][y] == "R") {
                var nx = x
                var ny = y
                val tempX = currentX - x
                val tempY = currentY - y

                when {
                    tempX < 0 -> nx--
                    tempX > 0 -> nx++
                }

                when {
                    tempY < 0 -> ny--
                    tempY > 0 -> ny++
                }

                graph[x][y] = "."
                visited[nx][ny]++

                when (graph[nx][ny]) {
                    "I" -> return count
                    else -> {
                        val node = Node(nx, ny)
                        deque.addLast(node)
                    }
                }
            }
        }
        return null
    }

}

fun main() {
    `8972`().solution()
}
