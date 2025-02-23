class `13913` {
    data class Node(val num: Int, val arr: LongArray)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }


        if (k <= n) {
            sb.append(n - k).append("\n")
            sb.append((k..n).sortedDescending().joinToString(" "))
        } else {
            val deque = ArrayDeque<Node>()
            deque.add(Node(n, longArrayOf(n.toLong())))
            val visited = BooleanArray(100001)
            visited[n] = true

            while (deque.isNotEmpty()) {
                val (num, arr) = deque.removeFirst()

                if (num == k) {
                    sb.append(arr.size - 1).append("\n")
                    sb.append(arr.joinToString(" "))
                    break
                }

                for (i in arrayOf(num, 1, -1)) {
                    if (num + i in 0..100000 && !visited[num + i]) {
                        visited[num + i] = true
                        deque.add(Node(num + i, arr + longArrayOf((num + i).toLong())))
                    }
                }
            }
        }



        bw.write(sb.toString())
        br.close()
        bw.close()
    }

}

fun main() {
    `13913`().solution()
}
