class `9177` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val t = br.readLine().toInt()

        repeat(t) {
            val (word1, word2, resultWord) = br.readLine().split(" ")
            if (bfs(word1, word2, resultWord) || bfs(word2, word1, resultWord)) {
                sb.append("Data set ${it + 1}: yes\n")
            } else {
                sb.append("Data set ${it + 1}: no\n")
            }
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()

    }

    fun bfs(word1: String, word2: String, resultWord: String): Boolean {
        if (word1.length + word2.length != resultWord.length) return false

        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        val visited = Array(word1.length + 1) { BooleanArray(word2.length + 1) }

        queue.add(0 to 0)
        visited[0][0] = true

        while (queue.isNotEmpty()) {
            val (i, j) = queue.removeFirst()

            if (i == word1.length && j == word2.length) {
                return true
            }

            if (i < word1.length && word1[i] == resultWord[i + j] && !visited[i + 1][j]) {
                visited[i + 1][j] = true
                queue.add(i + 1 to j)
            }

            if (j < word2.length && word2[j] == resultWord[i + j] && !visited[i][j + 1]) {
                visited[i][j + 1] = true
                queue.add(i to j + 1)
            }
        }

        return false
    }
}

fun main() {
    `9177`().solution()
}
