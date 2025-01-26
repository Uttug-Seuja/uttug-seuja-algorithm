class `20040` {
    data class Node(val num: Int, val end: Int)

    var answer = 0
    private lateinit var parent: IntArray


    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        parent = IntArray(n) { it }

        var answer = 0
        for (i in 1..m) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            if (find(x) == find(y)) {
                answer = i
                break
            }
            union(x, y)
        }

        sb.append(answer)
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

        parent[root2] = root1
    }
}

fun main() {
    `20040`().solution()
}


/**
 *
 *
 * 6 5
 * 0 1
 * 1 2
 * 2 3
 * 5 4
 * 0 4
 *
 * */
