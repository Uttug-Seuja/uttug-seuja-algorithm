class `17419` {
    fun run() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val k = br.readLine().toString()

        sb.append(k.count { it == '1' })
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `17419`().run()
}
