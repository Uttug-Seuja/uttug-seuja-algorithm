class `30804` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }

        val freq = mutableMapOf<Int, Int>()

        var start = 0
        var answer = 0

        for (end in 0 until n) {
            val currentValue = arr[end]
            freq[currentValue] = freq.getOrDefault(currentValue, 0) + 1

            while (freq.size > 2) {
                val startValue = arr[start]
                freq[startValue] = freq[startValue]!! - 1
                if (freq[startValue] == 0) {
                    freq.remove(startValue)
                }
                start++
            }

            answer = maxOf(answer, end - start + 1)
        }

        sb.append(answer)
        bw.write(sb.toString())

        br.close()
        bw.close()
    }
}

fun main() {
    `30804`().solution()
}
