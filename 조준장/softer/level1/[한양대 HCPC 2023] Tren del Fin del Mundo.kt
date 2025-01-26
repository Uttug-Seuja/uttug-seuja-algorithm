fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val answer = List(n) { br.readLine().split(" ").map { it.toInt() } }.sortedBy { it.last() }.first()

    sb.append(answer.joinToString(" "))

    bw.write(sb.toString())

    br.close()
    bw.close()
}

