class `14500` {

    lateinit var graph: Array<List<Int>>
    lateinit var visited: Array<MutableList<Boolean>>

    var answer = Int.MIN_VALUE
    var maxVal = Int.MIN_VALUE
    val dy = arrayOf(1, 0, 0, -1)
    val dx = arrayOf(0, -1, 1, 0)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        graph = Array(n) {
            val list = br.readLine().split(" ").map { it.toInt() }
            maxVal = maxOf(maxVal, list.max())
            list
        }

        visited = Array(n) { MutableList(m) { false } }
        
        repeat(n) { i ->
            repeat(m) { j ->
                visited[i][j] = true
                backtracking(n, m, i, j, 1, graph[i][j])
                visited[i][j] = false
            }

        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }

    fun backtracking(n: Int, m: Int, x: Int, y: Int, depth: Int, num: Int) {
        if (depth >= 4) {
            answer = maxOf(answer, num)
            return
        }

        if (answer > num + (4 - depth) * maxVal) return

        repeat(4) {
            val nx = x + dx[it]
            val ny = y + dy[it]

            if (nx in 0..n - 1 && ny in 0..m - 1) {
                if (!visited[nx][ny]) {
                    if (depth == 2) { // ㅗ , ㅜ , ㅏ , ㅓ
                        visited[nx][ny] = true
                        backtracking(n, m, x, y, depth + 1, num + graph[nx][ny])
                        visited[nx][ny] = false
                    }
                    visited[nx][ny] = true
                    backtracking(n, m, nx, ny, depth + 1, num + graph[nx][ny])
                    visited[nx][ny] = false
                }
            }
        }
    }
}


fun main() {
    `14500`().solution()
}
