class `12015` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }

        val temp = mutableListOf<Int>()
        for (i in arr) {
            val index = temp.binarySearch(i).let { if (it < 0) -(it + 1) else it }

            if (temp.size <= index) {
                temp.add(i)
            } else {
                temp[index] = i
            }
        }

        sb.append(temp.size)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `12015`().solution()
}

/**
 *
 *  A = {10, 20, 10, 30, 20, 50}
 *  B = {10, 20, 10, 60, 70, 50}
 *
 *
 * */
