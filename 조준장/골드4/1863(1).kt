class `1863` {
    fun solve() {
        val br = System.`in`.bufferedReader()

        val n = br.readLine().toInt()
        var answer = 0
        val stack = mutableListOf<Int>(0)
        repeat(n) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }

            if (stack.last() <= y) {
                stack.add(y)
            } else {
                while (stack.isNotEmpty()) {
                    val last = stack.last()
                    if (last <= y) {
                        if (last != y) {
                            stack.add(y)
                        }
                        break
                    }
                    stack.removeLast()
                    answer++
                }
            }
        }

        while (stack.last() != 0) {
            if (stack.removeLast() != 0) answer++
        }
        println(answer)
    }
}


fun main() {
    `1863`().solve()
}
//6
//1 1
//2 2
//5 3
//6 1
//7 3
//8 2

