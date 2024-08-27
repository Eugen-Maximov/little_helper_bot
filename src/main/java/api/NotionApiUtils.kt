package api

import notion.api.v1.model.pages.Page
import notion.api.v1.model.pages.PageParent
import notion.api.v1.model.pages.PageProperty
import notion.api.v1.request.pages.CreatePageRequest

object NotionApiUtils {

    private fun String.asRichText(): List<PageProperty.RichText> =
        listOf(PageProperty.RichText(text = PageProperty.RichText.Text(content = this)))

    fun List<Page>.parseAllNotesTitles(): List<String?> {
        val resultList: ArrayList<String?> = arrayListOf()
        this.forEach {
            resultList.add(it.properties["Note Title"]!!.title!![0].text!!.content)
        }
        return resultList
    }

    fun createPageRequest(
        dbId: String,
        note: String,
    ): CreatePageRequest = CreatePageRequest(
        parent = PageParent.database(dbId),
        properties = mapOf("Note Title" to PageProperty(title = note.asRichText()))
    )
}