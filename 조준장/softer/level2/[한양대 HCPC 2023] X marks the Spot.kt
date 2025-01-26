fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()

    repeat(n) {
        val (from, to) = br.readLine().split(" ").map{ it.toString() }
        val index = from.indexOfFirst{ it == 'X' || it == 'x'}
        sb.append(to[index].toUpperCase())
    }

    bw.write(sb.toString())

    br.close()
    bw.close()
    
}

// Indexing
// Indirect
