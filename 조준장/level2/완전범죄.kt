import java.util.PriorityQueue

class Solution {
    
    data class Node(val currentN : Int, val currentM : Int, val depth : Int)
    
    
    fun solution(info: Array<IntArray>, n: Int, m: Int): Int {
        return bfs(info, n, m)
    }
    
    fun bfs(info : Array<IntArray>, n : Int, m : Int) : Int {
        val pq = PriorityQueue<Node> { o1, o2 ->
            val result1 = o1.currentN - o2.currentN
            if (result1 == 0) {
                o2.depth - o1.depth
            } else {
                result1
            }
        }
        pq.add(Node(0, 0, 0))
        val visited = Array(info.size) { Array(n + 1) {  BooleanArray(m + 1) }}
        while (pq.isNotEmpty()) {
            val (currentN, currentM, depth) = pq.poll()
            
            if (n <= currentN || m <= currentM) continue
            
            if (info.size <= depth) {
                return currentN
            }
            
            if (visited[depth][currentN][currentM]) continue
            visited[depth][currentN][currentM] = true
            
            pq.add(Node(currentN + info[depth][0], currentM, depth + 1))
            pq.add(Node(currentN, currentM + info[depth][1], depth + 1)) 
        }
        
        return -1
    }
}
