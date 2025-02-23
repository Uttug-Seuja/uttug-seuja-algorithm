import java.util.LinkedList
import java.util.Queue

class `12886` {
    val visited = Array(1501) { BooleanArray(1501) }

    fun solution() {
        val br = System.`in`.bufferedReader()
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

        val sum = a + b + c
        if (sum % 3 != 0) {
            println(0)
            return
        }

        val result = bfs(a, b, c)
        println(if (result) 1 else 0)
    }

    fun bfs(a: Int, b: Int, c: Int): Boolean {
        val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
        queue.add(Triple(a, b, c))
        visited[a][b] = true

        while (queue.isNotEmpty()) {
            val (x, y, z) = queue.poll()
            if (x == y && y == z) return true

            val list = listOf(x, y, z)

            for (i in 0..2) {
                for (j in 0..2) {
                    if (i == j) continue
                    if (list[i] < list[j]) {
                        val next = list.toMutableList()
                        next[i] = list[i] * 2
                        next[j] = list[j] - list[i]

                        val nx = next[0]
                        val ny = next[1]
                        val nz = next[2]

                        val sorted = listOf(nx, ny, nz).sorted()

                        if (!visited[sorted[0]][sorted[1]]) {
                            visited[sorted[0]][sorted[1]] = true
                            queue.add(Triple(sorted[0], sorted[1], sorted[2]))
                        }
                    }
                }
            }
        }
        return false
    }
}

fun main() {
    `12886`().solution()
}
