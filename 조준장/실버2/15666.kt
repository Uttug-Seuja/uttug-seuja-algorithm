class `15666` {
    val answer = mutableListOf<List<Int>>()
    lateinit var arr: List<Int>
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        arr = br.readLine().split(" ").map { it.toInt() }.toSet().sorted()

        backtracking(0, listOf(), arr.size, m)

        answer.forEach {
            sb.append(it.joinToString(" ")).append("\n")
        }
        bw.write(sb.dropLast(1).toString())

        br.close()
        bw.close()
    }

    fun backtracking(curN: Int, curM: List<Int>, n: Int, m: Int) {
        if (m <= curM.size) {
            if (curM.size == m) {
                answer.add(curM)
            }
            return
        }

        for (i in curN until n) {
            backtracking(i, curM + arr[i], n, m)
        }

    }
}

fun main() {
    `15666`().solution()
}
