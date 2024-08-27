package api

import api.NotionApiUtils.createPageRequest
import api.NotionApiUtils.parseAllNotesTitles
import data.Texts.*

object NotionController : NotionApi() {

    @JvmStatic
    fun getAllNotesList(): String {
        val list = getAllPages().parseAllNotesTitles()
        val result: StringBuilder = StringBuilder()

        for ((count, note) in list.withIndex()) {
            result
                .append(count)
                .append(SEPARATOR)
                .append(note)
                .append(INDENT)
        }
        return result.toString()
    }

    @JvmStatic
    fun createNote(note: String): String {
        createPage(
            createPageRequest(
                DB_ID,
                note
            )
        )
        return NOTE_ADDED
    }
}