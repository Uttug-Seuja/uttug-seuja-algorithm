package org.example

import java.util.PriorityQueue

class `13549` {
    data class Node(val num: Int, val time: Int)

    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }

        if (n < k) {
            sb.append(bfs(n, k))
        } else {
            sb.append(n - k)
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun bfs(start: Int, end: Int): Int {
        var answer = Int.MAX_VALUE

        val pq = PriorityQueue<Node> { o1, o2 ->
            o1.time - o2.time
        }

        pq.add(Node(start, 0))

        val visited = IntArray(100001) { Int.MAX_VALUE }
        visited[start] = 0

        while (pq.isNotEmpty()) {
            val (num, time) = pq.poll()
            if (num == end) {
                answer = minOf(answer, time)
                continue
            }

            if (num + 1 in 0..100000 && time + 1 < visited[num + 1]) {
                visited[num + 1] = time + 1
                pq.add(Node(num + 1, time + 1))
            }
            if (num - 1 in 0..100000 && time - 1 < visited[num - 1]) {
                visited[num - 1] = time + 1
                pq.add(Node(num - 1, time + 1))
            }
            if (num * 2 in 0..100000 && time < visited[num * 2]) {
                visited[num * 2] = time
                pq.add(Node(num * 2, time))

            }
        }

        return answer
    }
}

fun main() {
    `13549`().solve()
}
