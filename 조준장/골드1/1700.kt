class `1700` {
    data class Node(val depth: Int, val multiTab: Set<Int>, val count: Int)

    lateinit var arr: List<Int>
    var answer = Int.MAX_VALUE
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        arr = br.readLine().split(" ").map { it.toInt() }

        val multiTab = mutableSetOf<Int>()
        var answer = 0
        repeat(k) { index ->

            if (arr[index] in multiTab) return@repeat

            if (multiTab.size < n) {
                multiTab.add(arr[index])
                return@repeat
            }

            val newArr = arr.subList(index + 1, k)
            var removeIndex = -1
            var removeTab = -1

            for (tab in multiTab) {
                val nextIndex = newArr.indexOf(tab)

                if (nextIndex == -1) {
                    removeTab = tab
                    break
                } else if (nextIndex > removeIndex) {
                    removeIndex = nextIndex
                    removeTab = tab
                }
            }

            multiTab.remove(removeTab)
            multiTab.add(arr[index])
            answer++
        }


        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }

}

fun main() {
    `1700`().solution()
}
