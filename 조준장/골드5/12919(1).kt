class `12919` {
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()
        var answer = 0

        val s = br.readLine().map { it.toString() }
        val t = br.readLine().map { it.toString() }

        val deque = ArrayDeque<List<String>>()

        deque.add(t)

        while (deque.isNotEmpty()) {
            val next = deque.removeFirst()

            if (next == s) {
                answer = 1
                break
            }

            if (next.isNotEmpty()) {
                if (next.first() == "B") {
                    val nT= next.toMutableList()
                    nT.removeFirst()
                    deque.add(nT.reversed().toMutableList())
                }

                if(next.last() == "A") {
                    val nT= next.toMutableList()
                    nT.removeLast()
                    deque.add(nT)
                }
            }
        }

        sb.append(answer)

        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `12919`().solve()
}
