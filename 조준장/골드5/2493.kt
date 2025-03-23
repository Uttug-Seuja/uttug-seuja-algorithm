class `2493` {

    data class Top(val position: Int, val height: Int)

    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").mapIndexed { index, s -> Top(index, s.toInt()) }

        val answer = IntArray(n)
        val stack = mutableListOf(arr.last())

        for (i in n - 2 downTo 0) {
            while (true) {
                if (stack.isNotEmpty() && stack.last().height <= arr[i].height) {
                    answer[stack.last().position] = i + 1
                    stack.removeLast()
                } else {
                    stack.add(arr[i])
                    break
                }
            }
        }

        sb.append(answer.joinToString(" "))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}


fun main() {
    `2493`().solve()
}
