import java.util.PriorityQueue

class `15591` {
    data class Place(
        val position: Int,
        val r: Int,
    )

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (N, Q) = br.readLine().split(" ").map { it.toInt() }

        val places = mutableListOf<Place>()

        val graph = List(N + 1) { mutableListOf<Place>() }
        repeat(N - 1) {
            val (p, q, r) = br.readLine().split(" ").map { it.toInt() }
            graph[p].add(Place(position = q, r = r))
            graph[q].add(Place(position = p, r = r))
        }

        repeat(Q) {
            var result = 0
            val (k, v) = br.readLine().split(" ").map { it.toInt() }
            val pq = PriorityQueue<Place> { o1, o2 ->
                o2.r - o1.r
            }.apply {
                add(Place(v, Int.MAX_VALUE))
            }
            val visited = mutableSetOf<Int>(v)

            while (pq.isNotEmpty()) {
                val nextPlace = pq.poll()

                for (place in graph[nextPlace.position]) {
                    if (place.position !in visited) {
                        val newR = minOf(nextPlace.r, place.r)
                        if (k <= newR) {
                            result++
                            pq.add(Place(place.position, newR))
                            visited.add(place.position)
                        }
                    }
                }
            }
            sb.append("$result\n")
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `15591`().solution()
}
