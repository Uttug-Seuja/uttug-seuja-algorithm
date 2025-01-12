class `15652` {
    val answer = mutableListOf<List<Int>>()
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        backtracking(1, listOf(), n, m)

        answer.forEach {
            sb.append(it.joinToString(" ")).append("\n")
        }

        bw.write(sb.dropLast(1).toString())

        br.close()
        bw.close()
    }

    fun backtracking(curN: Int, curM: List<Int>, n: Int, m: Int) {
        if (m <= curM.size) {
            if (m == curM.size) {
                answer.add(curM)
            }
            return
        }

        for (i in curN..n) {
            backtracking(i, curM + i, n, m)
        }

    }
}

fun main() {
    `15652`().solution()
}
