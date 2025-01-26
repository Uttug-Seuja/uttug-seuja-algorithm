data class Node(val x : Int, val y : Int)

lateinit var visited : Array<IntArray>

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

@kotlin.ExperimentalStdlibApi
fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()

    val graph = Array(n) { br.readLine().split(" ").map{ it.toInt() } }
    visited = Array(n) { IntArray(n) }

    for (num in 1 .. n) {
      solution(n, num)
    }

    visited.forEach {
        println(it.joinToString(" "))
    }
}

@ExperimentalStdlibApi
fun solution(n : Int, num : Int) {
    for (i in 0 until n) loop@ {
        for (j in 0 until n) {
            if (visited[i][j] == 0) {
                bfs(n, num, i, j)
                return
            }
        }
    }
}

@ExperimentalStdlibApi
fun bfs(n : Int, num : Int, sx : Int, sy : Int) {
    val deque = ArrayDeque<Node>()
    var count = 0
    deque.add(Node(sx, sy))

    while (deque.isNotEmpty()) {
        val (x, y) = deque.removeLast()
        visited[x][y] = num
        count++
        if (count == n) break

        repeat(4) {
            val nx = x + dx[it]
            val ny = y + dy[it]

            if (nx in 0 until n && ny in 0 until n && visited[nx][ny] == 0) {
                deque.add(Node(nx, ny))
            }
        }
    }

}
