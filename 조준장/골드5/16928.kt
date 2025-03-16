class `16928` {
    data class Node(val position: Int, val count: Int)

    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val ladder = mutableMapOf<Int, Int>()

        repeat(n + m) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            ladder[x] = y
        }

        val visited = IntArray(101) { Int.MAX_VALUE }
        val pq = ArrayDeque<Node>()

        pq.add(Node(1, 0))

        while (pq.isNotEmpty()) {
            val (position, count) = pq.removeFirst()

            if (position == 100) {
                continue
            }

            for (i in 1..6) {
                val (newPosition, newCount) = if (ladder[position + i] == null) {
                    Pair(position + i, count + 1)
                } else {
                    Pair(ladder[position + i]!!, count + 1)
                }

                if (newPosition in 1..100 && visited[newPosition] > newCount) {
                    visited[newPosition] = newCount
                    val newNode = Node(newPosition, newCount)
                    pq.add(newNode)
                }
            }
        }

        sb.append(visited[100])
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `16928`().solve()
}
