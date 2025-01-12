import java.util.PriorityQueue
import kotlin.math.hypot
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt

class `4386` {
    data class Node(val x: Int, val y: Int, val cost: Double)

    lateinit var parent: MutableList<Int>
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()

        parent = MutableList(n) { it }
        val pq = PriorityQueue<Node> { o1, o2 ->
            (o1.cost - o2.cost).toInt()
        }

        val graph = List(n) {
            br.readLine().split(" ").map { it.toDouble() }
        }

        repeat(n) { i ->
            repeat(n) loop@{ j ->
                if (i == j) return@loop
                val x = (graph[i][0] - graph[j][0]).pow(2)
                val y = (graph[i][1] - graph[j][1]).pow(2)
                val cost = sqrt(x + y)
                val node = Node(i, j, cost)

                pq.add(node)
            }
        }
        val answer = mutableListOf<Node>()

        while (pq.isNotEmpty()) {
            val (x, y, cost) = pq.poll()

            if (find(x) == find(y)) continue

            union(x, y)
            answer.add(Node(x, y, cost))
        }

        val result = round(answer.sumOf { it.cost } * 100) / 100
        sb.append(result)

        bw.write(sb.toString())

        br.close()
        bw.close()
    }


    fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(u: Int, v: Int) {
        val root1 = find(u)
        val root2 = find(v)

        parent[root1] = root2
    }
}


fun main() {
    `4386`().solution()
}
