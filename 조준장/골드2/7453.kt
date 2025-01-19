class `7453` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()

        val graph = Array<LongArray>(4) { LongArray(n) }

        for (i in 0 until n) {
            val column = br.readLine().split(" ").map { it.toLong() }
            for (j in 0 until 4) {
                graph[j][i] = column[j]
            }
        }

        val arr1 = LongArray(n * n)
        val arr2 = LongArray(n * n)

        repeat(n) { i ->
            repeat(n) { j ->
                arr1[n * i + j] = graph[0][i] + graph[1][j]
                arr2[n * i + j] = graph[2][i] + graph[3][j]

            }
        }

        arr1.sort()
        arr2.sort()

        var answer = 0L
        var start = 0
        var end = arr2.size - 1

        while (start < arr1.size && end >= 0) {

            val result = arr1[start] + arr2[end]
            if (result == 0L) {
                var tempIndex = start
                var startCount = 0L

                while (tempIndex < arr1.size && arr1[tempIndex] == arr1[start]) {
                    startCount++
                    tempIndex++
                }

                start = tempIndex
                var endCount = 0L
                tempIndex = end

                while (0 <= tempIndex && arr2[tempIndex] == arr2[end]) {
                    endCount++
                    tempIndex--
                }

                end = tempIndex

                answer += startCount * endCount

            } else if (result < 0L) {
                start++
            } else {
                end--
            }
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `7453`().solution()
}
