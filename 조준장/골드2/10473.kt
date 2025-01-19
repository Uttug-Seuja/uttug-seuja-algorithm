import java.util.PriorityQueue
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val (startX, startY) = br.readLine().split(" ").map { it.toDouble() }
    val (endX, endY) = br.readLine().split(" ").map { it.toDouble() }
    val n = br.readLine().toInt()
    val cannons = List(n) {
        br.readLine().split(" ").map { it.toDouble() }.let { Node(it[0], it[1]) }
    }
    br.close()

    val result = findMinimumTime(Node(startX, startY), Node(endX, endY), cannons)
    println("%.6f".format(result))
}

data class Node(val x: Double, val y: Double)

fun findMinimumTime(start: Node, end: Node, cannons: List<Node>): Double {
    val nodes = listOf(start) + cannons + listOf(end) // 시작, 대포, 끝 노드를 순서대로 연결
    val n = nodes.size
    val distances = Array(n) { DoubleArray(n) { Double.MAX_VALUE } }

    // 거리 및 이동 시간 계산
    for (i in nodes.indices) {
        for (j in nodes.indices) {
            if (i != j) distances[i][j] = calculateTime(nodes[i], nodes[j], i in 1 until n - 1)
        }
    }

    // 다익스트라 알고리즘
    val minTime = DoubleArray(n) { Double.MAX_VALUE }
    minTime[0] = 0.0
    val pq = PriorityQueue<Pair<Int, Double>>(compareBy { it.second })
    pq.add(0 to 0.0)

    while (pq.isNotEmpty()) {
        val (current, currentTime) = pq.poll()
        if (currentTime > minTime[current]) continue

        for (next in nodes.indices) {
            val newTime = currentTime + distances[current][next]
            if (newTime < minTime[next]) {
                minTime[next] = newTime
                pq.add(next to newTime)
            }
        }
    }

    return minTime[n - 1]
}

fun calculateTime(from: Node, to: Node, isCannon: Boolean): Double {
    val distance = calculateDistance(from, to)
    return if (isCannon) {
        // 대포를 타고 가는 시간과 걷는 시간 중 최소
        if (distance >= 50) 2.0 + (distance - 50) / 5.0 else 2.0 + (50 - distance) / 5.0
    } else {
        // 걷는 시간
        distance / 5.0
    }
}

fun calculateDistance(a: Node, b: Node): Double {
    return sqrt((b.x - a.x).pow(2) + (b.y - a.y).pow(2))
}
