class `1094` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()

        sb.append(n.countOneBits())
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `1094`().solution()
}
