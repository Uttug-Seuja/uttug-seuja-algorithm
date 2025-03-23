class Solution {
    val temp = mapOf(
        1 to "a",
        2 to "b",
        3 to "c",
        4 to "d",
        5 to "e",
        6 to "f",
        7 to "g",
        8 to "h",
        9 to "i",
        10 to "j",
        11 to "k",
        12 to "l",
        13 to "m",
        14 to "n",
        15 to "o",
        16 to "p",
        17 to "q",
        18 to "r",
        19 to "s",
        20 to "t",
        21 to "u",
        22 to "v",
        23 to "w",
        24 to "x",
        25 to "y",
        26 to "z"
    )

    val reversedTemp = temp.entries.associate { (key, value) -> value to key }

    fun solution(n: Long, bans: Array<String>): String {
        var answer: String = ""
        val sortedBans = bans.sortedWith(compareBy({ it.length }, { it }))
        val m = 26
        var count = 0
        // a b c d e f g h i j k l m n o p q r s t u v w x y z
        // aa ab ac ad ae af ag ah

        var arr = mutableListOf<Int>()
        var target = n
        while (target > 0) {
            target--                     
            arr.add((target % m).toInt() + 1)    
            target /= m
        }

        arr.reverse()
        sortedBans.forEach { ban ->
            if (ban.length < arr.size) {
                count++
                arr = arr.colculate()
            } else if (ban.length == arr.size) {
                for (i in 0 until arr.size) {
                    if (reversedTemp[ban[i].toString()]!! > arr[i]) break
                    if (reversedTemp[ban[i].toString()]!! < arr[i]) {
                        count++
                        arr = arr.colculate()
                        break
                    }
                    if (i == arr.size - 1 && reversedTemp[ban[i].toString()]!! == arr[i]) {
                        count++
                        arr = arr.colculate()
                    }
                }
            }
        }

        arr.forEach {
            answer += temp[it]
        }

        return answer
    }

    fun MutableList<Int>.colculate(): MutableList<Int> {
        this[this.size - 1]++

        var i = this.size - 1
        while (i >= 0) {
            if (this[i] > 26) {
                this[i] = 1
                if (i == 0) {
                    this.add(0, 1)
                    i++  
                } else {
                    this[i - 1]++
                }   
            }
            i--
        }

    return this
}

}
