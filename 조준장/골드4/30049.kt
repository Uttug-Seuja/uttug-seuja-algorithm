class `30049` {
    data class Market(val num: Int, val take: Int)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
        val arr = List(n + 1) { MutableList(10001) { 0 } }
        val marketBestSeller = MutableList(10001) { Market(it, 0) }
        val bestSellerCount = MutableList(10001) { 0 }

        repeat(n) { num ->
            val line = br.readLine().split(" ").map { it.toInt() }
            for (i in 0 until line.size step 2) {
                val j = line[i]
                val take = line[i + 1]
                arr[num + 1][j] = take
                if (marketBestSeller[j].take < take) {
                    marketBestSeller[j] = Market(num = num + 1, take = take)
                }
            }
        }

        marketBestSeller.forEach { seller ->
           if (seller.take > 0)  bestSellerCount[seller.num]++
        }

        var count = bestSellerCount.count { it == k }

        val q = br.readLine().toInt()
        repeat(q) {
            val (i, j, u) = br.readLine().split(" ").map { it.toInt() }
            arr[i][j] += u

            if (marketBestSeller[j].num == i) {
                marketBestSeller[j] = marketBestSeller[j].copy(take = arr[i][j])
            } else {
                if (marketBestSeller[j].take < arr[i][j]) {
                    if (bestSellerCount[marketBestSeller[j].num] == k) count--
                    bestSellerCount[marketBestSeller[j].num]--

                    marketBestSeller[j] = Market(num = i, take = arr[i][j])

                    bestSellerCount[i]++
                    if (bestSellerCount[i] == k) count++
                }
            }
            sb.append("${count}\n")
        }

        bw.write(sb.dropLast(1).toString())
        br.close()
        bw.close()
    }
}

fun main() {
    `30049`().solution()
}



