class `31797` {

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        var arr = IntArray(10001)

        repeat(m) {
            val h = br.readLine().split(" ").map { it.toInt() }
            arr[h.first() - 1] = it + 1
            arr[h.last() - 1] = it + 1
        }
        arr = arr.filter { it != 0 }.toIntArray()

        while (arr.size < n) {
            arr += arr
        }
        
        sb.append(arr[n - 1])
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `31797`().solution()
}
