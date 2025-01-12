import java.util.PriorityQueue

class `16398` {
    data class Node(val a: Int, val b: Int, val cost: Long)

    private var parent: MutableList<Int> = mutableListOf()
    var answer = Long.MAX_VALUE
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        parent = MutableList(n) { it }


        val pq = PriorityQueue<Node> { o1, o2 ->
            (o1.cost - o2.cost).toInt()
        }

        repeat(n) { i ->
            val row = br.readLine().split(" ").map { it.toDouble() }
            row.forEachIndexed { j, item ->
                if (i != j) {
                    val node = Node(i, j, item.toLong())
                    pq.add(node)
                }
            }
        }

        val answer = mutableListOf<Node>()
        while (pq.isNotEmpty()) {
            val (a, b, c) = pq.poll()

            if (find(a) == find(b)) continue
            union(a, b)
            answer.add(Node(a, b, c))
        }

        sb.append(answer.sumOf { it.cost })
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    private fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    private fun union(u: Int, v: Int) {
        val root1 = find(u)
        val root2 = find(v)

        parent[root1] = root2
    }
}

fun main() {
    `16398`().solution()
}
