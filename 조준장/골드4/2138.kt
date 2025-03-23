class `2138` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val startState = br.readLine().map { it.toString().toInt() }
        val endState = br.readLine().map { it.toString().toInt() }

        val result1 = switch(n, 0, startState.toMutableList(), endState.toMutableList())
        val result2 = switch(n, 1, startState.toMutableList(), endState.toMutableList())
        if (result1 == -1 || result2 == -1) {
            sb.append(maxOf(result1, result2))

        } else {
            sb.append(minOf(result1, result2))
        }

        bw.write(sb.toString())

        br.close()
        bw.close()


    }

    val d = arrayOf(-1, 0, 1)
    fun switch(n: Int, start: Int, startState: MutableList<Int>, endState: MutableList<Int>): Int {
        var count = 0

        if (start == 0) {
            count++
            repeat(3) {
                val nd = start + d[it]

                if (nd in 0 until n) {
                    if (startState[nd] == 1) startState[nd] = 0 else startState[nd] = 1
                }
            }
        }

        for (i in 1 until n) {
            if (startState[i - 1] != endState[i - 1]) {
                count++
                repeat(3) {
                    val nd = i + d[it]

                    if (nd in 0 until n) {
                        if (startState[nd] == 1) startState[nd] = 0 else startState[nd] = 1
                    }
                }
            }
        }

        return if (startState == endState) count else -1
    }

}

fun main() {
    `2138`().solution()
}
