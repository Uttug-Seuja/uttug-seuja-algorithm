class `1863` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        var answer = 0

        val arr = mutableListOf<Int>()
        repeat(n) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }

            if (y == 0) {
                answer += arr.size
                arr.clear()
            } else {
                while (arr.isNotEmpty() && arr.last() > y) {
                    arr.removeLast()
                    answer++
                }
                if (arr.isEmpty() || arr.last() != y) arr.add(y)
            }

        }

        answer += arr.size
        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `1863`().solution()
}


/**
 * 4
 * 1 4
 * 2 3
 * 3 5
 * 4 4
 *
 * 답 : 4
 *
 * 5
 * 1 1
 * 2 0
 * 3 1
 * 4 0
 * 5 1
 * */
