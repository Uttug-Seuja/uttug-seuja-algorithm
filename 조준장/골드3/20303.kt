class `20303` {
    lateinit var parent: IntArray
    lateinit var person: IntArray

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
        val candyBundle = intArrayOf(0) + br.readLine().split(" ").map { it.toInt() }.toIntArray()

        parent = IntArray(n + 1) { it }
        person = IntArray(n + 1) { 1 }

        for (i in 0 until m) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            if (find(a) == find(b)) continue
            union(a, b)
        }

        for (i in 1..n) {
            if (parent[i] != i) {
                val p = find(i)
                candyBundle[p] += candyBundle[i]
                person[p] += person[i]
            }
        }

        val dp = IntArray(k)

        for (i in 1..n) {
            if (parent[i] != i) continue
            for (j in k - 1 downTo person[i]) {
                dp[j] = maxOf(dp[j], dp[j - person[i]] + candyBundle[i])
            }
        }

        sb.append(dp[k - 1])
        bw.write(sb.toString())
        br.close()
        bw.close()
    }

    fun union(u: Int, v: Int) {
        val root1 = find(u)
        val root2 = find(v)
        parent[root1] = root2
    }

    fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

}

fun main() {
    `20303`().solution()
}
