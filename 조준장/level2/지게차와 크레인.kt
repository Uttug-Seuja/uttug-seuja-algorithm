class Solution {
    data class Node(val x : Int, val y : Int)

    fun solution(storage: Array<String>, requests: Array<String>): Int {
        var answer: Int = 0

        val deque = ArrayDeque<Node>()
        val storageGraph = storage.map { it.map{ it.toString() }.toMutableList() }
        val n = storageGraph.size
        val m = storageGraph.first().size

        requests.forEach { request ->
            val visited = Array(n + 1) { BooleanArray(m + 1) }
            val isCrane = if(request.length == 1) false else true

            for (i in 0 until n) {
                deque.add(Node(i, -1))
                deque.add(Node(i, m))
            }

            for (j in 0 until m) {
                deque.add(Node(-1, j))
                deque.add(Node(n, j))
            }

            val dx = arrayOf(1, -1, 0, 0)
            val dy = arrayOf(0, 0, 1, -1)

            while(deque.isNotEmpty()) {
                val (x, y) = deque.removeFirst()

                repeat(4) { i ->
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if (nx in 0 until n && ny in 0 until m && !visited[nx][ny]) {
                        visited[nx][ny] = true
                        
                        if (isCrane || storageGraph[nx][ny] == ".") {
                            deque.add(Node(nx, ny))
                        }
                        
                        if (storageGraph[nx][ny] in request) {
                            storageGraph[nx][ny] = "."
                        }
                        
                        
                    }
                }

            }

        }
        
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (storageGraph[i][j] != ".") {
                    answer++
                }
            }
        }
        

        return answer
    }

}
