class Solution {
    fun solution(nodes: IntArray, edges: Array<IntArray>): IntArray {
        val n = nodes.size
        val node2idx = nodes.withIndex().associate { (i, node) -> node to i }

        val parent = IntArray(n) { it }
        val degree = IntArray(n)
        val rootGroup = IntArray(n)
        val nonRootGroup = IntArray(n)

        fun find(a: Int): Int {
            if (parent[a] != a) {
                parent[a] = find(parent[a])
            }
            return parent[a]
        }

        fun merge(a: Int, b: Int) {
            val rootA = find(a)
            val rootB = find(b)
            if (rootA != rootB) {
                parent[rootB] = rootA
            }
        }

        edges.forEach { edge ->
            val u = node2idx[edge[0]] ?: throw IllegalArgumentException()
            val v = node2idx[edge[1]] ?: throw IllegalArgumentException()
            degree[u]++
            degree[v]++
            merge(u, v)
        }

        nodes.forEachIndexed { i, node ->
            val repr = find(i)
            if (node % 2 == degree[i] % 2) {
                rootGroup[repr]++
            } else {
                nonRootGroup[repr]++
            }
        }

        var hTreeCount = 0
        var rTreeCount = 0

        nodes.indices.forEach { i ->
            if (find(i) != i) return@forEach 

            if (rootGroup[i] == 1) {
                hTreeCount++
            }
            if (nonRootGroup[i] == 1) {
                rTreeCount++
            }
        }

        return intArrayOf(hTreeCount, rTreeCount)
    }
}
