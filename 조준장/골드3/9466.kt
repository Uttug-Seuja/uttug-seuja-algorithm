class `9466` {
    lateinit var arr: List<Int>
    lateinit var visited: IntArray
    var count = 0

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val testCase = br.readLine().toInt()

        repeat(testCase) {
            val n = br.readLine().toInt()
            arr = listOf(0) + br.readLine().split(" ").map { it.toInt() }
            visited = IntArray(n + 1) { 0 }
            count = 0

            for (i in 1..n) {
                if (visited[i] == 0) {
                    dfs(i)
                }
            }

            sb.append(n - count).append("\n")
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()
    }

    private fun dfs(start: Int) {
        val path = mutableListOf<Int>()
        var current = start

        while (true) {
            if (visited[current] == 2) break // 이미 탐색 완료
            if (visited[current] == 1) {    // 사이클 발견
                val cycleStart = path.indexOf(current)
                count += path.size - cycleStart
                break
            }

            visited[current] = 1 // 방문 중 표시
            path.add(current)
            current = arr[current]
        }

        // 탐색 완료 처리
        for (node in path) {
            visited[node] = 2
        }
    }
}

fun main() {
    `9466`().solution()
}
