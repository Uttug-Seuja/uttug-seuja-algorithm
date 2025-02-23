class `1956` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (v, e) = br.readLine().split(" ").map { it.toInt() }
        var answer = Int.MAX_VALUE
        val dist = Array(v + 1) { IntArray(v + 1) { Int.MAX_VALUE } }

        repeat(e) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            dist[a][b] = c
        }

        for (k in 1..v) {
            for (i in 1..v) {
                for (j in 1..v) {
                    if (dist[i][k] != Int.MAX_VALUE && dist[k][j] != Int.MAX_VALUE) {
                        dist[i][j] = minOf(dist[i][j], dist[i][k] + dist[k][j])
                    }
                }
            }
        }

        for (i in 1..v) {
            answer = minOf(answer, dist[i][i])
        }

        sb.append(
            if (answer == Int.MAX_VALUE) {
                -1
            } else {
                answer
            }
        )
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `1956`().solution()
}
