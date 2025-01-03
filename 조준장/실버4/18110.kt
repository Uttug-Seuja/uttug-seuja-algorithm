package implementation

import kotlin.math.roundToInt

class `18110` {

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        if (n == 0) {
            sb.append(0)
        } else {
            var arr = List(n) {
                br.readLine().toInt()
            }.sorted()
            val size = arr.size
            val count = (size * 0.15).roundToInt()
            arr = arr.drop(count).dropLast(count)
            sb.append(((arr.sum().toDouble() / arr.size)).roundToInt())
        }
        
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `18110`().solution()
}
