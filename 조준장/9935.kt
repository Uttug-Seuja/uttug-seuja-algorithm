class `9935` {
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val words = br.readLine().map { it.toString() }
        val bomb = br.readLine().map { it.toString() }
        val bombSize = bomb.size
        val deque = ArrayDeque<String>()

        for (word in words) {
            deque.add(word)
            if (bomb.size <= deque.size && deque.last() == bomb.last() && bomb == deque.subList(
                    deque.size - bombSize,
                    deque.size
                )
            ) {
                repeat(bombSize) {
                    deque.removeLast()
                }
            }
        }

        if (deque.isEmpty()) {
            sb.append("FRULA")
        } else {
            sb.append(deque.joinToString(""))
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `9935`().solve()
}
