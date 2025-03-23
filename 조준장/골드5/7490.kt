class `7490` {
    val answer = mutableListOf<String>()
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val t = br.readLine().toInt()

        repeat(t) {
            val n = br.readLine().toInt()
            recursion(n, 1, listOf("1"))
            answer.add("")
        }

        sb.append(answer.joinToString("\n"))
        bw.write(sb.toString())

        br.close()
        bw.close()

    }

    fun recursion(n: Int, depth: Int, result: List<String>) {
        if (n <= depth) {
            var num = result[0].toInt()
            for (i in 1 until result.size step 2) {
                if (result[i] == "+") {
                    num += result[i + 1].toInt()
                } else if (result[i] == "-") {
                    num -= result[i + 1].toInt()
                }
            }

            val answerList = result.map {
                if (it.length == 1) {
                    it
                } else {
                    it.toList().joinToString("/")
                }
            }

            if (num == 0) {
                answer.add(answerList.joinToString("").replace("/", " "))
            }
            return
        }

        recursion(
            n,
            depth + 1,
            result.mapIndexed { index, s -> if (index == result.size - 1) s + "${depth + 1}" else s })
        recursion(n, depth + 1, result + listOf("+") + "${depth + 1}")
        recursion(n, depth + 1, result + listOf("-") + "${depth + 1}")

    }
}

fun main() {
    `7490`().solve()
}
