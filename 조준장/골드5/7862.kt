class `7862` {
    fun solve() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        while (true) {
            val input = br.readLine().toString()
            if (input == "end") break
            var countO = 0
            var countX = 0
            val graph = input.map {
                if (it == 'O') {
                    countO++
                } else if (it == 'X') {
                    countX++
                }
                it.toString()
            }.chunked(3)


            if ((countX != countO + 1) && (countX != countO)) {
                sb.append("invalid\n")
                continue
            }

            val rowCountO = checkRow(graph, "O")
            val rowCountX = checkRow(graph, "X")

            if (rowCountX >= 1) {
                if (rowCountO == 0 && countX >= countO) {
                    sb.append("valid\n")
                } else {
                    sb.append("invalid\n")
                }
                continue
            }

            if (rowCountO >= 1) {
                if (rowCountX == 0 && countX == countO) {
                    sb.append("valid\n")
                } else {
                    sb.append("invalid\n")
                }
                continue
            }

            val columnCountO = checkColumn(graph, "O")
            val columnCountX = checkColumn(graph, "X")

            if (columnCountX >= 1) {
                if (columnCountO == 0 && countX > countO) {
                    sb.append("valid\n")
                } else {
                    sb.append("invalid\n")

                }
                continue
            }

            if (columnCountO >= 1) {
                if (columnCountX == 0 && countX == countO) {
                    sb.append("valid\n")
                } else {
                    sb.append("invalid\n")

                }
                continue
            }

            val diagonalCountO = checkDiagonal(graph, "O")
            val diagonalCountX = checkDiagonal(graph, "X")

            if (diagonalCountX >= 1) {
                if (countX > countO) {
                    sb.append("valid\n")
                } else {
                    sb.append("invalid\n")
                }
                continue
            }

            if (diagonalCountO >= 1) {
                if (countX == countO) {
                    sb.append("valid\n")
                } else {
                    sb.append("invalid\n")
                }
                continue
            }

            if (countX + countO == 9) {
                sb.append("valid\n")
                continue
            }

            sb.append("invalid\n")
        }

        bw.write(sb.toString())

        br.close()
        bw.close()
    }

    fun checkRow(graph: List<List<String>>, str: String): Int {
        var answer = 0
        for (i in 0 until 3) {
            var count = 0
            for (j in 0 until 3) {
                if (graph[i][j] == str) {
                    count++
                }
            }
            if (count == 3) answer++
        }

        return answer
    }

    fun checkColumn(graph: List<List<String>>, str: String): Int {
        var answer = 0
        for (i in 0 until 3) {
            var count = 0
            for (j in 0 until 3) {
                if (graph[j][i] == str) {
                    count++
                }
            }
            if (count == 3) answer++
        }

        return answer
    }

    fun checkDiagonal(graph: List<List<String>>, str: String): Int {
        var answer = 0
        if (graph[0][0] == str && graph[1][1] == str && graph[2][2] == str) {
            answer++
        }

        if (graph[0][2] == str && graph[1][1] == str && graph[2][0] == str) {
            answer++
        }


        return answer
    }
}

fun main() {
    `7862`().solve()
}
