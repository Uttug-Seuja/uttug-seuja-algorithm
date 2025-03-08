import java.util.ArrayDeque

class `13549` {
    data class Node(val position: Int, val time: Int)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }

        if (k <= n) {
            sb.append(n - k)
        } else {
            sb.append(bfs(n, k))
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun bfs(start: Int, end: Int): Int {
        val queue = ArrayDeque<Node>()
        queue.add(Node(start, 0))
        val visited = IntArray(100001) { Int.MAX_VALUE }

        var answer = Int.MAX_VALUE
        while (queue.isNotEmpty()) {
            val (position, time) = queue.poll()

            if (position == end) {
                answer = minOf(answer, time)
                continue
            }

            if (position + 1 in 0 .. 100000 && time + 1 < visited[position + 1]) {
                visited[position + 1] = time + 1
                queue.add(Node(position + 1, time + 1))
            }
            if (position - 1 in 0 .. 100000 && time - 1 < visited[position - 1]) {
                visited[position - 1] = time - 1
                queue.add(Node(position - 1, time + 1))
            }
            if (position * 2 in 0 .. 100000 && time < visited[position * 2]) {
                visited[position * 2] = time
                queue.add(Node(position * 2, time))
            }
        }

        return answer
    }
}

fun main() {
    `13549`().solution()
}
