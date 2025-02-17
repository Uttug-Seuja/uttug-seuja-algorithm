import java.util.PriorityQueue

class `2887` {
    data class Node(val a: Int, val b: Int, val c: Int)

    lateinit var parent: IntArray
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val graph = MutableList(n) { index -> listOf(index) + br.readLine().split(" ").map { it.toInt() } }

        parent = IntArray(n + 1) { it }
        val pq = PriorityQueue<Node> { o1, o2 ->
            o1.c - o2.c
        }

        for (d in 1..3) {
            graph.sortBy { it[d] }
            for (i in 0 until n - 1) {
                val cost = Math.abs(graph[i][d] - graph[i + 1][d])
                pq.add(Node(graph[i][0], graph[i + 1][0], cost))
            }
        }

        val answer = mutableListOf<Node>()
        while (pq.isNotEmpty()) {
            val (a, b, c) = pq.poll()

            if (find(a) == find(b)) continue
            union(a, b)
            answer.add(Node(a, b, c))
        }

        sb.append(answer.sumOf { it.c })
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val root1 = find(x)
        val root2 = find(y)

        parent[root1] = root2
    }


}


fun main() {
    `2887`().solution()
}


/**
 *
 * 3
 * 1 1 1
 * 2 3 9
 * -1 9 5
 *
 * A -> B -> C -> D -> E
 *
 * A -> B = 0
 * B -> D = 1
 * D -> C = 3
 * D -> E = 0
 * => 4
 * */
