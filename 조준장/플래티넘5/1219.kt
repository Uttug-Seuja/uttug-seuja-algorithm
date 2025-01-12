class `1219` {

    data class Edge(val start: Int, val end: Int, val cost: Int)

    lateinit var costs: LongArray
    lateinit var graph: Array<MutableList<Int>>

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, startCity, endCity, m) = br.readLine().split(" ").map { it.toInt() }
        val edges = mutableListOf<Edge>()

        graph = Array(n) { mutableListOf() }

        repeat(m) {
            val (s, e, c) = br.readLine().split(" ").map { it.toInt() }
            edges.add(Edge(s, e, c))
            graph[s].add(e)
        }

        val maxCosts = br.readLine().split(" ").map { it.toLong() }

        costs = LongArray(n) { Long.MIN_VALUE }
        costs[startCity] = maxCosts[startCity]

        for (i in 1 until n) {
            var updated = false
            for ((s, e, c) in edges) {
                if (costs[s] != Long.MIN_VALUE) {
                    val newCost = costs[s] - c + maxCosts[e]
                    if (newCost > costs[e]) {
                        costs[e] = newCost
                        updated = true
                    }
                }
            }
            if (!updated) break
        }

        val infinityCandidate = BooleanArray(n) { false }
        for ((s, e, c) in edges) {
            if (costs[s] != Long.MIN_VALUE) {
                val newCost = costs[s] - c + maxCosts[e]
                if (newCost > costs[e]) {
                    infinityCandidate[e] = true
                }
            }
        }

        val visited = BooleanArray(n)
        val queue = ArrayDeque<Int>()
        for (i in infinityCandidate.indices) {
            if (infinityCandidate[i]) {
                queue.add(i)
                visited[i] = true
            }
        }

        var endCityInfinite = false
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            if (cur == endCity) {
                endCityInfinite = true
                break
            }

            for (next in graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true
                    queue.add(next)
                }
            }
        }

        val endCityCost = costs[endCity]
        val answer = when {
            endCityCost == Long.MIN_VALUE -> "gg"
            endCityInfinite -> "Gee"
            else -> endCityCost.toString()
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `1219`().solution()
}
