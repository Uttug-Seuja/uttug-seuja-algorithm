fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()


    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val answer = draw(n)
        sb.append(answer.toString()).append("\n")
    }
    bw.write(sb.dropLast(1).toString())

    br.close()
    bw.close()
}

fun draw(n : Int) : String {
    val mod = n % 5
    val quotient = n / 5

    if (mod == 0 && quotient == 0) {
        return "|".repeat(n)
    }

    var str = "++++ ".repeat(quotient)
    
    if(mod == 0) {
        str.dropLast(1)
    } else {
        str += "|".repeat(mod)
    }

    return str
}




