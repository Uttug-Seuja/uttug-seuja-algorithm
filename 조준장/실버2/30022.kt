import kotlin.math.abs

class `30022` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, a, b) = br.readLine().split(" ").map { it.toInt() }
        var answer = 0L
        var countA = 0
        var countB = 0
        List(n) {
            br.readLine().split(" ").map { it.toLong() }
        }.sortedWith(compareByDescending {
            abs(it.first() - it.last())
        }).forEach {
            if (it.first() == it.last()) answer += it.first()
            else {
                if (it.first() < it.last()) {
                    answer += if (countA >= a) {
                        countB++
                        it.last()
                    } else {
                        countA++
                        it.first()
                    }
                } else {
                    answer += if (countB >= b) {
                        countA++
                        it.first()
                    } else {
                        countB++
                        it.last()
                    }
                }
            }
        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `30022`().solution()
}
