class `2458` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(n + 1) { mutableListOf<Int>() }
        val reverseGraph = Array(n + 1) { mutableListOf<Int>() }

        repeat(m) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            graph[a].add(b)
            reverseGraph[b].add(a)
        }

        var answer = 0
        repeat(n) {
            if (bfs(n, it + 1, graph, reverseGraph)) {
                answer++
            }
        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }

    fun bfs(n: Int, start: Int, graph: Array<MutableList<Int>>, reverseGraph: Array<MutableList<Int>>): Boolean {
        val deque = ArrayDeque<Int>()
        deque.add(start)
        val visited = BooleanArray(n + 1)
        visited[start] = true

        while (deque.isNotEmpty()) {
            val target = deque.removeFirst()

            for (i in graph[target]) {
                if (!visited[i]) {
                    visited[i] = true
                    deque.add(i)
                }
            }
        }

        deque.clear()
        deque.add(start)

        while (deque.isNotEmpty()) {
            val target = deque.removeFirst()

            for (i in reverseGraph[target]) {
                if (!visited[i]) {
                    visited[i] = true
                    deque.add(i)
                }
            }
        }

        return visited.drop(1).all { it }
    }
}

fun main() {
    `2458`().solution()
}
