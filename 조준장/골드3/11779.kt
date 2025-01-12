import java.util.PriorityQueue

class `11779` {
    data class Node(val end: Int, val cost: Int, val cities: List<Int> = emptyList())

    lateinit var graph: Array<MutableList<Node>>

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val m = br.readLine().toInt()

        graph = Array(n + 1) { mutableListOf<Node>() }
        repeat(m) {
            val (start, end, cost) = br.readLine().split(" ").map { it.toInt() }
            graph[start].add(Node(end, cost))
        }

        val (startCity, endCity) = br.readLine().split(" ").map { it.toInt() }

        val answer = dijkstra(startCity, endCity) ?: return

        sb.append(answer.cost).append("\n")
        sb.append(answer.cities.size).append("\n")
        sb.append(answer.cities.joinToString(" "))

        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun dijkstra(startCity: Int, endCity: Int): Node? {
        val visited = mutableSetOf<Int>()

        val queue = PriorityQueue<Node> { o1, o2 ->
            o1.cost.compareTo(o2.cost)
        }

        queue.add(Node(startCity, 0, listOf(startCity)))

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            if (current.end == endCity) {
                return current
            }

            for (neighbor in graph[current.end]) {
                if (neighbor.end !in visited) {
                    visited.add(current.end)
                    val newCost = current.cost + neighbor.cost
                    val newCities = current.cities + neighbor.end
                    queue.add(Node(neighbor.end, newCost, newCities))
                }
            }
        }

        return null
    }
}

fun main() {
    `11779`().solution()
}
