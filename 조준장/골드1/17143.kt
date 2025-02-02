class `17143` {
    data class Shark(val r: Int, val c: Int, val s: Int, val d: Int, val z: Int)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val (R, C, M) = br.readLine().split(" ").map { it.toInt() }

        if (M == 0) {
            bw.write("0\n")
            br.close()
            bw.close()
            return
        }

        val sharks = Array(R + 1) { Array<Shark?>(C + 1) { null } }

        repeat(M) {
            val (r, c, s, d, z) = br.readLine().split(" ").map { it.toInt() }
            sharks[r][c] = Shark(r, c, s, d, z)
        }

        var totalScore = 0

        val dr = intArrayOf(0, -1, 1, 0, 0)
        val dc = intArrayOf(0, 0, 0, 1, -1)

        // 낚시왕 이동
        for (pos in 1..C) {
            // 가장 가까운 상어 잡기
            for (row in 1..R) {
                if (sharks[row][pos] != null) {
                    totalScore += sharks[row][pos]!!.z
                    sharks[row][pos] = null
                    break
                }
            }

            // 상어 이동
            val newSharks = Array(R + 1) { Array<Shark?>(C + 1) { null } }

            for (r in 1..R) {
                for (c in 1..C) {
                    val shark = sharks[r][c] ?: continue
                    var (nr, nc, s, d, z) = shark

                    var move = s
                    when (d) {
                        1, 2 -> { // 위/아래 이동
                            for (i in 0 until s) {
                                if (nr == 1) d = 2
                                if (nr == R) d = 1
                                nr += dr[d]
                            }
                        }

                        3, 4 -> { // 오른쪽/왼쪽 이동
                            for (i in 0 until s) {
                                if (nc == 1) d = 3
                                if (nc == C) d = 4
                                nc += dc[d]
                            }
                        }
                    }

                    if (newSharks[nr][nc] == null || newSharks[nr][nc]!!.z < z) {
                        newSharks[nr][nc] = Shark(nr, nc, s, d, z)
                    }
                }
            }
            sharks.indices.forEach { sharks[it] = newSharks[it] }
        }

        bw.write(totalScore.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `17143`().solution()
}
