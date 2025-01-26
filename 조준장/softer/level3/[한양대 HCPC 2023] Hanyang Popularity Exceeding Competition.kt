fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    var x = 0
    repeat(n) {
        val (p, c) = br.readLine().split(" ").map { it.toInt() }

        if(Math.abs(p - x) <= c) {
            x++
        }
    }

    sb.append(x)
    bw.write(sb.toString())

    br.close()
    bw.close()

}
