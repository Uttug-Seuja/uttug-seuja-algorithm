class `21736` {
    data class Node(val x: Int, val y: Int)

    var graph: List<MutableList<String>> = emptyList()
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        var iNode = Node(0, 0)
        graph = List(n) { i ->
            br.readLine().mapIndexed { j, c ->
                if (c == 'I') {
                    iNode = Node(i, j)
                }
                c.toString()
            }.toMutableList()
        }
        val count = bfs(n, m, iNode)
        val result = if (count == 0) {
            "TT"
        } else {
            "$count"
        }
        sb.append(result)
        bw.write(result)

        br.close()
        bw.close()
    }

    fun bfs(n: Int, m: Int, start: Node): Int {
        val dx = arrayOf(0, 0, 1, -1)
        val dy = arrayOf(1, -1, 0, 0)
        var answer = 0
        val deque = ArrayDeque<Node>()
        deque.add(start)

        while (deque.isNotEmpty()) {
            val next = deque.removeFirst()

            repeat(4) { i ->
                val nx = next.x + dx[i]
                val ny = next.y + dy[i]

                if (nx in 0 until n && ny in 0 until m) {
                    if (graph[nx][ny] != "X") {
                        if (graph[nx][ny] == "P") {
                            answer++
                        }
                        graph[nx][ny] = "X"
                        deque.add(Node(nx, ny))
                    }
                }

            }

        }
        return answer
    }
}

fun main() {
    `21736`().solution()
}
