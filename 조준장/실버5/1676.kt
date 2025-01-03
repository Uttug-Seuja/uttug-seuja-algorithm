package implementation

class `1676` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        var n = br.readLine().toInt()
        var answer = 0

        while (n > 1) {
            answer += n / 5
            n /= 5
        }
        sb.append(answer.toString())
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `1676`().solution()
}
