class `12919` {
    var answer = 0
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val s = br.readLine().toString()
        val t = br.readLine().toString()

        sb.append(bfs(s, t))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun bfs(s: String, t: String): Int {
        val deque = ArrayDeque<String>()

        deque.add(t)
        while (deque.isNotEmpty()) {
            val next = deque.removeFirst()

            if (s == next) return 1

            if (next.length > 1 && next.last() == 'A') {
                deque.add(next.dropLast(1))
            }

            if (next.length > 1 && next.first() == 'B') {
                deque.add(next.drop(1).reversed())
            }
        }
        return 0
    }
}


fun main() {
    `12919`().solution()
}
