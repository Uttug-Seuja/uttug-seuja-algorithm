data class Node(val position: Int, val size: Long)

@kotlin.ExperimentalStdlibApi
fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val arr = ArrayDeque(br.readLine().split(" ").mapIndexed { index, size -> Node(index + 1, size.toLong()) })

    var index = 0
    while (arr.size > 1) {
        if (index >= arr.size) index = 0

        // 첫번째 미생물
        if (index == 0) {
            if (arr[index].size >= arr[index + 1].size) {
                arr[index] = Node(arr[index].position, arr[index].size + arr[index + 1].size)
                arr.removeAt(index + 1)
            }
        }
        // 마지막 미생물
        else if (index == arr.size - 1) {
            if (arr[index].size >= arr[index - 1].size) {
                arr[index] = Node(arr[index].position, arr[index].size + arr[index - 1].size)
                arr.removeAt(index - 1)
            }
        }
        // 중간 미생물
        else {
            var front = false
            var back = false

            if (arr[index].size >= arr[index - 1].size) {
                front = true
            }

            if (arr[index].size >= arr[index + 1].size) {
                back = true
            }

            if (front) {
                arr[index] = Node(arr[index].position, arr[index].size + arr[index - 1].size)
                arr.removeAt(index - 1)
                index--  // 이전 인덱스로 이동
            }

            if (back) {
                arr[index] = Node(arr[index].position, arr[index].size + arr[index + 1].size)
                arr.removeAt(index + 1)
            }
        }

        index++
    }

    val answer = arr.first()
    sb.append("${answer.size}\n${answer.position}")

    bw.write(sb.toString())

    br.close()
    bw.close()
}
