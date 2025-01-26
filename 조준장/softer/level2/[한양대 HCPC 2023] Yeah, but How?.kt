@kotlin.ExperimentalStdlibApi
fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val word = br.readLine().toString().replace("()", "(1)").replace(")(", ")+(")
    
    sb.append(word)
    bw.write(sb.toString())

    br.close()
    bw.close()

}
