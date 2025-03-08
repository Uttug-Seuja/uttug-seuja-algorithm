class `27172` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }

        val visited = IntArray(1000001) { -1 }
        val answer = IntArray(n)

        arr.forEachIndexed { index, i ->
            visited[i] = index
        }

        for (i in 0 until n) {
            for (j in arr[i] * 2..1000000 step arr[i]) {
                if (visited[j] == -1) continue
                answer[i]++
                answer[visited[j]]--
            }
        }

        sb.append(answer.joinToString(" "))
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `27172`().solution()
}
