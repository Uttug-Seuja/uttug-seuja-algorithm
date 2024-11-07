import java.util.PriorityQueue

class `15703` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val queue = PriorityQueue(br.readLine().split(" ").map { it.toInt() })

        var answer = 0
        while (queue.isNotEmpty()) {
            answer++
            val newQueue = PriorityQueue<Int>()
            val stack = mutableListOf<Int>()
            repeat(queue.size) {
                val next = queue.poll()
                if (stack.isEmpty()) {
                    stack.add(next)
                } else {
                    if (next >= stack.size) {
                        stack.add(next)
                    } else {
                        newQueue.add(next)
                    }
                }
            }
            queue.clear()
            queue.addAll(newQueue)
        }
        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `15703`().solution()
}
