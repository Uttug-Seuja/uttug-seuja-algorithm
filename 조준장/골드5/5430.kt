class `5430` {
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val t = br.readLine().toInt()

        loot@ for (i in 0 until t) {
            val p = br.readLine().toString()
            val n = br.readLine().toInt()
            val deque = ArrayDeque<Int>()

            br.readLine().drop(1).dropLast(1).split(",").forEach {
                val num = it.toIntOrNull()
                if (num != null) {
                    deque.add(num)
                }
            }

            var isReversed = false

            for (j in  p) {
                if (j == 'R') {
                    isReversed = !isReversed
                } else {
                    if (deque.isEmpty()) {
                        sb.append("error\n")
                        continue@loot
                    }
                    if (isReversed) {
                        deque.removeLast()
                    } else {
                        deque.removeFirst()
                    }
                }
            }

            val result = if (isReversed) deque.reversed() else deque

            sb.append(result.joinToString(",", "[", "]")).append("\n")
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `5430`().solve()
}
