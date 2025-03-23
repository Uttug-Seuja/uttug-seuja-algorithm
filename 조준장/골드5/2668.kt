class `2668` {
    lateinit var arr: List<Int>
    lateinit var visited: BooleanArray
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()

        arr = listOf(0) + List(n) { br.readLine().toInt() }
        val answer = mutableListOf<Int>()
        for (i in 1 .. n) {
            visited = BooleanArray(n + 1)
            if (dfs(i, arr[i])) {
                answer.add(i)
            }
        }

        sb.append(answer.size).append("\n")
        sb.append(answer.joinToString("\n"))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun dfs(start: Int, num: Int): Boolean {
        if (start == num) {
            return true
        }

        if (!visited[num]) {
            visited[num] = true
            return dfs(start, arr[num])
        }

        return false
    }
}


fun main() {
    `2668`().solve()
}
