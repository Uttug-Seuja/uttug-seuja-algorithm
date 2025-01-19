import kotlin.math.max

class `30805` {
    val answer = mutableListOf<Int>()
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val aN = br.readLine().toInt()
        val arrA = br.readLine().split(" ").map { it.toInt() }.toMutableList()
        val bN = br.readLine().toInt()
        val arrB = br.readLine().split(" ").map { it.toInt() }.toMutableList()


        recursive(arrA, arrB)

        if (answer.isEmpty()) {
            sb.append(0)
        } else {
            sb.append(answer.size).append("\n")
            sb.append(answer.joinToString(" "))
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun recursive(arrA: MutableList<Int>, arrB: MutableList<Int>) {
        if (arrA.isEmpty() || arrB.isEmpty()) return

        val maxA = arrA.max()
        val maxB = arrB.max()

        val maxIndexA = arrA.indexOf(maxA)
        val maxIndexB = arrB.indexOf(maxB)

        if (maxA == maxB) {
            val newArrA = arrA.subList(maxIndexA + 1, arrA.size)
            val newArrB = arrB.subList(maxIndexB + 1, arrB.size)
            answer.add(maxA)
            recursive(newArrA, newArrB)
        } else if (maxA < maxB) {
            arrB.removeAt(maxIndexB)
            recursive(arrA, arrB)
        } else {
            arrA.removeAt(maxIndexA)
            recursive(arrA, arrB)
        }

    }
}

fun main() {
    `30805`().solution()
}
