import java.util.*

class `28707` {

    data class Node(val l: Int, val r: Int, val c: Int)
    data class Edge(val cost: Int, val arr: IntArray)

    lateinit var initArr: IntArray
    lateinit var graph: List<Node>

    var minCost = Int.MAX_VALUE
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        initArr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val m = br.readLine().toInt()
        graph = List(m) {
            val (l, r, c) = br.readLine().split(" ").map { it.toInt() }
            Node(l - 1, r - 1, c)
        }

        dijkstra()

        sb.append(if (minCost == Int.MAX_VALUE) "-1" else minCost)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun dijkstra() {
        val targetArr = initArr.sortedArray()
        val pq = PriorityQueue<Edge> { o1, o2 -> o1.cost - o2.cost }
        val visited = mutableSetOf<String>()

        pq.add(Edge(0, initArr.clone()))

        while (pq.isNotEmpty()) {
            val (cost, arr) = pq.poll()

            if (arr.contentEquals(targetArr)) {
                minCost = minOf(minCost, cost)
                break
            }

            val stateKey = arr.joinToString(",")
            if (stateKey in visited) continue
            visited.add(stateKey)

            for (edge in graph) {
                val newArr = arr.clone()
                newArr[edge.l] = arr[edge.r]
                newArr[edge.r] = arr[edge.l]

                val newCost = cost + edge.c
                if (newArr.joinToString(",") !in visited) {
                    pq.add(Edge(newCost, newArr))
                }
            }
        }
    }
}

fun main() {
    `28707`().solution()
}
