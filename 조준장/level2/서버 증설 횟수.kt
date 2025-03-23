class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer: Int = 0
        
        val server = IntArray(24)
        
        players.forEachIndexed { index, player -> 
            val needsServerCount = player / m
            
            if (player >= needsServerCount) {
                if (server[index] >= needsServerCount) return@forEachIndexed
                
                val createServerCount = needsServerCount - server[index]
                answer += createServerCount
                for (i in index until minOf(index + k, 24)) {
                    server[i] += createServerCount
                }
            }
        }
        
        return answer
    }
}
