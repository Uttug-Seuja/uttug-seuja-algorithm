package org.example

class `1734` {
    data class Node(val r: Int, val c: Int)

    lateinit var graph: Array<BooleanArray>

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

        graph = Array(n) { BooleanArray(m) }
        repeat(k) {
            val (r, c) = br.readLine().split(" ").map { it.toInt() }
            graph[r - 1][c - 1] = true
        }


        var answer = 0
        repeat(n) { i ->
            repeat(m) { j ->
                if (graph[i][j]) {
                    answer = maxOf(answer, bfs(n, m, i, j))
                }
            }
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)
    fun bfs(n: Int, m: Int, r: Int, c: Int): Int {
        val queue = ArrayDeque<Node>()
        queue.add(Node(r, c))
        var count = 0
        while (queue.isNotEmpty()) {
            val (x, y) = queue.removeFirst()

            repeat(4) { i ->
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx in 0 until n && ny in 0 until m && graph[nx][ny]) {
                    count++
                    graph[nx][ny] = false
                    queue.add(Node(nx, ny))
                }
            }
        }

        return count
    }
}

fun main() {
    `1734`().solution()
}
