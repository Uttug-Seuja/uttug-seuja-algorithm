class `12851` {
    data class Node(val position: Int, val depth: Int)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }

        val pq = PriorityQueue<Node> { o1, o2 ->
            o1.depth - o2.depth
        }
        pq.add(Node(n, 0))

        val answer = mutableListOf<Int>()
        val visited = IntArray(100_001)
        while (pq.isNotEmpty()) {
            val next = pq.poll()

            if (next.position == k) {
                answer.add(next.depth)
                continue
            }

            for (position in arrayOf(next.position - 1, next.position + 1, next.position * 2)) {
                if (position !in 0..100_000) continue
                if (visited[position] == 0 || visited[position] == visited[next.position] + 1) {
                    val node = Node(position = position, depth = next.depth + 1)
                    visited[position] = visited[next.position] + 1
                    pq.add(node)
                }
            }
        }

        sb.append(answer.first()).append("\n")
        sb.append(answer.size)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}


fun main() {
    `12851`().solution()
}
