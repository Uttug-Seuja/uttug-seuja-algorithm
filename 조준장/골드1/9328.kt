class `9328` {

    data class Node(val x: Int, val y: Int)

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val testCase = br.readLine().toInt()

        repeat(testCase) {
            val (h, w) = br.readLine().split(" ").map { it.toInt() }
            val graph =
                Array(1) { List(w + 2) { '.' } } + Array(h) {
                    listOf('.') + br.readLine().map { it } + listOf('.')
                } + Array(1) { List(w + 2) { '.' } }

            val keys = mutableSetOf<Char>()
            val keysStr = br.readLine()

            if (keysStr.toIntOrNull() == null) {
                keys.addAll(keysStr.map { it })
            }

            val deque = ArrayDeque<Node>()
            repeat(w + 2) {
                if (graph[0][it] == '.') deque.add(Node(0, it))
                if (graph[graph.size - 1][it] == '.') deque.add(Node(graph.size - 1, it))
            }

            repeat(h + 2) {
                if (graph[it][0] == '.') deque.add(Node(it, 0))
                if (graph[it][graph[0].size - 1] == '.') deque.add(Node(it, graph[0].size - 1))
            }
            sb.append(bfs(h, w, graph, deque, keys)).append("\n")
        }

        bw.write(sb.dropLast(1).toString())

        br.close()
        bw.close()
    }

    fun bfs(h: Int, w: Int, graph: Array<List<Char>>, deque: ArrayDeque<Node>, keys: MutableSet<Char>): Int {
        var count = 0
        val visited = Array(h + 2) { BooleanArray(w + 2) }
        while (deque.isNotEmpty()) {
            var flag = false
            repeat(deque.size) {
                val (x, y) = deque.removeFirst()

                if (graph[x][y].isDoor() && graph[x][y].lowercase().first() !in keys) {
                    deque.add(Node(x, y))
                    return@repeat
                }
                flag = true
                if (graph[x][y] == '$') count++

                repeat(4) {
                    val nx = x + dx[it]
                    val ny = y + dy[it]

                    if (nx in 0 until h + 1 && ny in 0..w + 1 && !visited[nx][ny] && graph[nx][ny] != '*') {
                        visited[nx][ny] = true
                        deque.add(Node(nx, ny))
                        if (graph[nx][ny].isKey()) keys.add(graph[nx][ny])
                    }
                }
            }
            if (!flag) break
        }
        return count
    }

    fun Char.isKey(): Boolean = this in 'a'..'z'

    fun Char.isDoor(): Boolean = this in 'A'..'Z'
}

fun main() {
    `9328`().solution()
}
