/**
 * 인규가 쓰는 코드 에디터는 매우 똑똑해서 작성된 코드에서 오류가 없는 연속된
 * X줄이 존재한다면, 특정 커맨드를 통해 나머지 오류를 자동으로 해결할 수 있다.
 * 즉, 인규는 자동으로 생성된 코드를 전부 수정하지 않고도 프로그램을 완성할 수 있다.
 *
 * 다만, 인규는 코드 에디터에 의존하는 것을 싫어하기 때문에, 오류를
 * Y개 이상 찾아 해결한 뒤에만, 에디터의 오류 해결 기능을 이용하려 한다.
 *
 * 두 음이 아닌 정수
 * X, Y 그리고 자동으로 생성된 코드에서 오류가 있는 줄 번호가 주어질 때, 에디터가 해결할 오류 개수의 최댓값을 구하는 프로그램을 작성하시오.
 * 단, 한 줄에는 최대 한 개의 오류만 존재한다.
 *
 * N개의 코드 줄이 있다.
 * 오류가 있는 줄은 M개 주어진다.
 * 오류가 없는 연속된 X줄이 존재한다면 나머지 오류 자동 해결
 * Y개 이상 찾아 해경한 뒤에만, 오류 자동 해결
 * 에디터가 해결할 오류 개수의 최댓값을 출력한다.*
 *
 * 1 2 3 4 5 6 7 8 9 10
 * f t t f t t f t t f
 * t     t     t
 *
 * 7 3
 *
 * f f f f t f t f t f
 * t t t t t f t f t f -> 3
 *
 * f f f t t t t t t t -> 3
 *
 *
 * */

class `24453` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { it.toInt() }
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        if (n == 1) {
            sb.append(m - y)
        } else {
            val error = BooleanArray(20000001)
            arr.forEach {
                error[it] = true
            }

            var answer = Int.MAX_VALUE
            var bugCount = 0
            var solveCount = 0
            var start = 1
            var end = 1

            while (true) {
                if (start == n) break

                if ((bugCount < y || solveCount < x) && end <= n) {
                    if (error[end]) bugCount++
                    end++
                    solveCount++
                } else {
                    if (bugCount >= y && solveCount >= x) answer = minOf(answer, bugCount)
                    if (error[start]) bugCount--
                    start++
                    solveCount--
                }
            }

            sb.append(m - answer)
        }



        bw.write(sb.toString())
        br.close()
        bw.close()
    }
}

fun main() {

    `24453`().solution()
}
