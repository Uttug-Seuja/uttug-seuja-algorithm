class `22251` {

    val numbers = arrayOf(
        booleanArrayOf(true, true, true, false, true, true, true),
        booleanArrayOf(false, false, true, false, true, false, false),
        booleanArrayOf(false, true, true, true, false, true, true),
        booleanArrayOf(false, true, true, true, true, true, false),
        booleanArrayOf(true, false, true, true, true, false, false),
        booleanArrayOf(true, true, false, true, true, true, false),
        booleanArrayOf(true, true, false, true, true, true, true),
        booleanArrayOf(false, true, true, false, true, false, false),
        booleanArrayOf(true, true, true, true, true, true, true),
        booleanArrayOf(true, true, true, true, true, true, false)
    )

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k, p, x) = br.readLine().split(" ").map { it.toInt() }

        val display = convertNumberToDisplay(x, k)
        var result = 0
        for (i in 1..n) {
            if (i == x) continue

            val floorDisplay = convertNumberToDisplay(i, k)
            val count = findDiffCount(floorDisplay, display, k)

            if (count in 1..p) {
                result++
            }
        }
        sb.append(result)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }

    fun convertNumberToDisplay(number: Int, k: Int): Array<BooleanArray> {
        val display = Array(k) { BooleanArray(7) }
        var num = number
        var i = k - 1
        while (num > 0) {
            val place = num % 10
            display[i--] = numbers[place].copyOf()
            num /= 10
        }
        while (i >= 0) {
            display[i--] = numbers[0].copyOf()
        }
        return display
    }

    fun findDiffCount(number: Array<BooleanArray>, display: Array<BooleanArray>, k: Int): Int {
        var count = 0
        for (i in 0 until k) {
            for (j in 0 until 7) {
                if (number[i][j] != display[i][j]) {
                    count++
                }
            }
        }
        return count
    }

}

fun main() {
    `22251`().solution()
}
