fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val q = br.readLine().toInt()
    val arr = mutableListOf<Int>()

    repeat(q) {
        val line = br.readLine().split(" ")

        when (line.first().toInt()) {
            1 -> {
                val x = line.last().toInt()
                arr.add(x)
            }

            2 -> {
                val n = arr.size
                val prefixSum = IntArray(n + 1)
                for (i in 1..n) {
                    prefixSum[i] = prefixSum[i - 1] + arr[i - 1]
                }

                val mid = n / 2
                val frontSum = prefixSum[mid]
                val backSum = prefixSum[n] - prefixSum[mid]

                if (frontSum <= backSum) {
                    sb.append("$frontSum\n")
                    arr.subList(0, mid).clear()
                } else {
                    sb.append("$backSum\n")
                    arr.subList(mid, n).clear()
                }
            }
        }
    }

    sb.append(arr.joinToString(" "))
    bw.write(sb.toString())

    br.close()
    bw.close()
}
