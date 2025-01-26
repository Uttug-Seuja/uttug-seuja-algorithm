fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val answer = arr.max()!! + arr.size - 1
    sb.append(answer)
    bw.write(sb.toString())

    br.close()
    bw.close()
}
