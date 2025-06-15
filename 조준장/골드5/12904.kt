class `12904` {
    fun solve() {
        var answer = 0
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val s = br.readLine().map { it.toString() }
        val t = br.readLine().map { it.toString() }
        val deque = ArrayDeque<String>()

        t.forEach {
            deque.add(it)
        }


        while (s.size < deque.size) {
            if (deque.last() == "A") {
                deque.removeLast()
            } else if (deque.last() == "B") {
                deque.removeLast()
                deque.reverse()
            }
        }

        if (s == deque) {
            answer = 1
        }

        sb.append(answer)

        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `12904`().solve()
}
