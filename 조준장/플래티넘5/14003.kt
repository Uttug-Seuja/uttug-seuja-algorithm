class `14003` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }

        val temp = mutableListOf<Int>()
        val indexArr = IntArray(n + 1)

        for (i in 0 until n) {
            val index = temp.binarySearch(arr[i]).let {
                if (it < 0) {
                    -(it + 1)
                } else {
                    it
                }
            }

            if (temp.size <= index) {
                temp.add(arr[i])
                indexArr[i] = temp.size - 1
            } else {
                temp[index] = arr[i]
                indexArr[i] = index
            }
        }


        var index = temp.size - 1
        val answer = ArrayDeque<Int>()
        for (i in n - 1 downTo 0) {
            if (index == indexArr[i]) {
                answer.addLast(arr[i])
                index -= 1
            }
        }

        sb.append(answer.size).append("\n")

        while (answer.isNotEmpty()) {
            sb.append(answer.removeLast()).append(" ")
        }

        bw.write(sb.dropLast(1).toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `14003`().solution()
}

/**
 * 6
 * 10 20 0 30 20 50
 *
 *
 * */
