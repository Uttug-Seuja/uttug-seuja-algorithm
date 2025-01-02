class Solution {

    fun String.toSecondsTime() : Int {
        val timeList = this.split(":").map { it.toInt() }
        return timeList.first() * 60 + timeList.last()
    }

    fun Int.toTime() : String {
        val minute = (this / 60).toString()
        val seconds = (this % 60).toString()
        return "${minute.padStart(2, '0')}:${seconds.padStart(2, '0')}"
    }

    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        var answer: String = ""

        val newVideoLen = video_len.toSecondsTime()
        var newPos = pos.toSecondsTime()
        val newOpStart = op_start.toSecondsTime()
        val newOpEnd = op_end.toSecondsTime()

        commands.forEach { command ->
            if (newPos in newOpStart..newOpEnd) {
                newPos = newOpEnd
            }
            
            if (command == "next") {
                newPos += 10
                if (newVideoLen < newPos) {
                    newPos = newVideoLen
                }

            } else {
                newPos -= 10
                if (newPos < 0) {
                    newPos = 0
                }
            }
        }

        if (newPos in newOpStart..newOpEnd) {
            newPos = newOpEnd
        }

        return newPos.toTime()
    }
}
