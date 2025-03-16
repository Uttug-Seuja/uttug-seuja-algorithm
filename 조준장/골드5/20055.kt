class `20055` {
    data class Node(val durability: Int, val hasRobot: Boolean)

    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { Node(it.toInt(), false) }
        val deque = ArrayDeque<Node>()
        deque.addAll(arr)

        var answer = 0
        while (true) {
            answer++

            // 회전
            val last = deque.removeLast()
            deque.addFirst(last)

            // 이동
            for (i in n - 1 downTo 0) {
                // 내리기
                if (i == n - 1) {
                    if (deque[i].hasRobot) {
                        deque[i] = deque[i].copy(hasRobot = false)
                    }
                    continue
                }

                if (deque[i].hasRobot) {
                    val nextIndex = i + 1

                    if (!deque[nextIndex].hasRobot && deque[nextIndex].durability > 0) {
                        deque[i] = deque[i].copy(hasRobot = false)
                        val hasRobot = nextIndex != n - 1
                        deque[nextIndex] =
                            deque[nextIndex].copy(durability = deque[nextIndex].durability - 1, hasRobot = hasRobot)
                    }
                }
            }

            // 로봇 올리기
            if (!deque[0].hasRobot && deque[0].durability > 0) {
                deque[0] = deque[0].copy(durability = deque[0].durability - 1, hasRobot = true)
            }

            if (deque.count { it.durability == 0 } >= k) break

        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `20055`().solve()
}
