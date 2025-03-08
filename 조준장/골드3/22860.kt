import java.io.*
import java.util.*

class `22860` {

    data class Folder(val name: String) {
        val childFolder = mutableListOf<Folder>()
        val childFile = mutableListOf<String>()
    }

    private val folderList = mutableListOf<Folder>()
    private var fileCnt = 0

    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val st = StringTokenizer(br.readLine())

        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()

        repeat(N + M) {
            val (P, F, C) = br.readLine().split(" ")
            val parentFolder = findFolder(P) ?: Folder(P).also { folderList.add(it) }

            if (C == "1") {
                val childFolder = findFolder(F) ?: Folder(F).also { folderList.add(it) }
                parentFolder.childFolder.add(childFolder)
            } else {
                parentFolder.childFile.add(F)
            }
        }

        val Q = br.readLine().toInt()
        repeat(Q) {
            fileCnt = 0
            val query = br.readLine().split("/")
            val lastName = query.last()
            val folder = folderList.find { it.name == lastName }

            folder?.let {
                val hs = mutableSetOf<String>()
                findFile(it, hs)
                bw.write("${hs.size} $fileCnt\n")
            }
        }

        bw.close()
    }

    private fun findFolder(name: String): Folder? {
        return folderList.find { it.name == name }
    }

    private fun findFile(folder: Folder, hs: MutableSet<String>) {
        fileCnt += folder.childFile.size
        hs.addAll(folder.childFile)
        folder.childFolder.forEach { findFile(it, hs) }
    }
}

fun main() {
    boj_22860().solution()
}
