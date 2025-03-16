class `20437` {
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val t = br.readLine().toInt()

        repeat(t) {
            val words = br.readLine()
            val k = br.readLine().toInt()

            val wordMap = mutableMapOf<Char, MutableList<Int>>()
            val countMap = mutableMapOf<Char, Int>()

            words.forEach { char ->
                countMap[char] = (countMap[char] ?: 0) + 1
            }

            words.forEachIndexed { index, char ->
                if (countMap[char]!! >= k) {
                    if (wordMap[char] == null) {
                        wordMap[char] = mutableListOf(index)
                    } else {
                        wordMap[char]!!.add(index)
                    }
                }
            }

            var maxLength = Int.MIN_VALUE
            var minLength = Int.MAX_VALUE

            if (wordMap.isEmpty()) {
                sb.append("-1\n")
                return@repeat
            }

            for ((char, indexList) in wordMap) {
                for (i in 0..indexList.size - k) {
                    val length = indexList[i + k - 1] - indexList[i] + 1
                    maxLength = maxOf(maxLength, length)
                    minLength = minOf(minLength, length)
                }
            }

            sb.append("$minLength $maxLength\n")
        }

        bw.write(sb.toString())
        bw.flush()

        br.close()
        bw.close()
    }
}

fun main() {
    `20437`().solve()
}
