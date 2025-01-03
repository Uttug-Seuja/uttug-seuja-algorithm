package implementation

class `9019` {
    var a: Int = 0
    var b: Int = 0
    var answer = ""
    private val visited = mutableSetOf<Int>()


    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val t = br.readLine().toInt()

        repeat(t) {
            answer = ""
            visited.clear()
            val arr = br.readLine().split(' ').map { it.toInt() }
            a = arr.first()
            b = arr.last()
            bfs()
            sb.append("$answer\n")
        }

        bw.write(sb.dropLast(1).toString())
        bw.close()
        br.close()
    }

    fun bfs() {
        val queue = ArrayDeque<Pair<Int, String>>()
        queue.add(Pair(a, ""))
        var newNum: Int = 0
        while (queue.isNotEmpty()) {
            val (num, str) = queue.removeFirst()

            // D
            newNum = runD(num)
            if (newNum == b) {
                answer = str + "D"
                return
            }

            if (newNum !in visited) {
                visited.add(newNum)
                queue.add(Pair(newNum, str + "D"))
            }

            // S
            newNum = runS(num)
            if (newNum == b) {
                answer = str + "S"
                return
            }

            if (newNum !in visited) {
                visited.add(newNum)
                queue.add(Pair(newNum, str + "S"))
            }

            // L
            newNum = runL(num)
            if (newNum == b) {
                answer = str + "L"
                return
            }

            if (newNum !in visited) {
                visited.add(newNum)
                queue.add(Pair(newNum, str + "L"))
            }

            // R
            newNum = runR(num)
            if (newNum == b) {
                answer = str + "R"
                return
            }

            if (newNum !in visited) {
                visited.add(newNum)
                queue.add(Pair(newNum, str + "R"))
            }
        }

    }

    fun runD(n: Int): Int {
        return (n * 2) % 10000
    }

    fun runS(n: Int): Int {
        return if (n - 1 < 0) 9999 else n - 1
    }

    fun runL(n: Int): Int {
        return (n % 1000) * 10 + n / 1000
    }

    fun runR(n: Int): Int {
        return (n % 10) * 1000 + (n / 10) % 1000
    }
}

fun main() {
    `9019`().solution()
}

