class `16724` {
    data class Node(val x: Int, val y: Int)

    lateinit var graph: List<List<Char>>
    lateinit var visited: Array<IntArray>
    val d = mapOf('U' to arrayOf(-1, 0), 'D' to arrayOf(1, 0), 'L' to arrayOf(0, -1), 'R' to arrayOf(0, 1))

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        graph = List(n) { br.readLine().map { it } }


        visited = Array(n) { IntArray(m) { 0 } }

        var count = 1
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (visited[i][j] == 0) {
                    visited[i][j] = count
                    visited[i][j] = dfs(i, j, count)
                    count++
                }
            }
        }

        val answer = mutableSetOf<Int>()

        for (i in 0 until n) {
            for (j in 0 until m) {
                answer.add(visited[i][j])
            }
        }

        sb.append(answer.size)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun dfs(x: Int, y: Int, cycle: Int): Int {
        val order = d[graph[x][y]]!!

        val nx = x + order.first()
        val ny = y + order.last()

        if (visited[nx][ny] != 0) {
            return visited[nx][ny]
        }

        visited[nx][ny] = cycle
        visited[nx][ny] = dfs(nx, ny, cycle)
        return 1
    }

}

fun main() {
    `11049`().solution()
}
