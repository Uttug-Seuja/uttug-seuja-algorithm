class `2623` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(n + 1) { mutableListOf<Int>() }
        val visited = IntArray(n + 1) { 0 }

        repeat(m) {
            val row = br.readLine().split(" ").map { it.toInt() }
            var preNum = 0
            row.drop(1).forEach { currentNum ->
                preNum = if (preNum == 0) {
                    currentNum
                } else {
                    graph[preNum].add(currentNum)
                    visited[currentNum]++
                    currentNum
                }

            }
        }

        val deque = ArrayDeque<Int>()

        visited.drop(1).forEachIndexed { index, int ->
            if (int == 0) deque.add(index + 1)
        }

        val answer = mutableListOf<Int>()

        while (deque.isNotEmpty()) {
            val currentNum = deque.removeFirst()
            answer.add(currentNum)

            for (nextNum in graph[currentNum]) {
                visited[nextNum]--

                if (visited[nextNum] == 0) {
                    deque.addLast(nextNum)
                }
            }
        }

        val result = if (answer.size == n) {
            answer.joinToString("\n")
        } else {
            "0"
        }

        sb.append(result)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `2623`().solution()
}

