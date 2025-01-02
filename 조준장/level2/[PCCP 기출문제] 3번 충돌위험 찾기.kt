class Solution {

    fun solution(points: Array<IntArray>, routes: Array<IntArray>): Int {
        var answer = 0

        val robotRoutes = Array(101) { mutableListOf<Pair<Int, Int>>() }

        var num = 0
        var maxLength = 0

        // 로봇들의 경로 저장
        for (i in routes.indices) {
            var p = Pair(points[routes[i][0] - 1][0], points[routes[i][0] - 1][1])
            for (j in 1 until routes[i].size) {
                val start = routes[i][j - 1]
                val end = routes[i][j]
                p = Pair(points[start - 1][0], points[start - 1][1])

                while (points[end - 1][0] != p.first) {
                    robotRoutes[num].add(p)
                    p = if (points[end - 1][0] > p.first) Pair(p.first + 1, p.second) else Pair(p.first - 1, p.second)
                }
                while (points[end - 1][1] != p.second) {
                    robotRoutes[num].add(p)
                    p = if (points[end - 1][1] > p.second) Pair(p.first, p.second + 1) else Pair(p.first, p.second - 1)
                }
            }
            robotRoutes[num].add(p)

            if (maxLength < robotRoutes[num].size) {
                maxLength = robotRoutes[num].size
            }

            num++
        }

        val routeSize = routes.size
        var currentPoint: Pair<Int, Int>

        // 충돌 상황 체크
        for (index in 0 until maxLength) {
            for (i in 0 until routeSize) {
                if (robotRoutes[i].size <= index) continue

                if (robotRoutes[i][index].first == -1) continue

                currentPoint = robotRoutes[i][index]
                for (j in i + 1 until routeSize) {
                    if (robotRoutes[j].size <= index) continue

                    if (robotRoutes[j][index].first == -1) continue

                    if (currentPoint == robotRoutes[j][index]) {
                        if (robotRoutes[i][index].first != -1) {
                            robotRoutes[i][index] = Pair(-1, -1)
                        }
                        robotRoutes[j][index] = Pair(-1, -1)
                    }
                }
                // 만약 중복되는 포인트가 한개라도 있었을 때 횟수 추가
                if (robotRoutes[i][index].first == -1) {
                    answer++
                }
            }
        }

        return answer
    }
}
