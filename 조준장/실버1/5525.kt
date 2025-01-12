class `5525` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val m = br.readLine().toInt()
        val s = br.readLine().toString()

        var answer = 0
        var index = 0
        var IOICount = 0
        while (index <= m) {
            if (index + 2 < m && s[index] == 'I' && s[index + 1] == 'O' && s[index + 2] == 'I') {
                IOICount++
                index += 2

                if (IOICount == n) {
                    IOICount--
                    answer++
                }
            } else {
                IOICount = 0
                index++
            }
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `5525`().solution()
}
