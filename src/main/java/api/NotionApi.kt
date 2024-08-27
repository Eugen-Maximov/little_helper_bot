package api

import data.Environments
import notion.api.v1.NotionClient
import notion.api.v1.model.databases.query.sort.QuerySort
import notion.api.v1.model.pages.Page
import notion.api.v1.request.pages.CreatePageRequest

open class NotionApi {

    protected companion object {
        const val DB_ID = "1f30d602-03b6-4bce-91cd-389de898620e"

        var notionClient: NotionClient = NotionClient(
            Environments.getEnvValue(Environments.NOTION_KEY)
        )
    }

    protected fun getAllPages(): List<Page> = notionClient.queryDatabase(
        databaseId = DB_ID,
        sorts = listOf(QuerySort("Created Date"))
    ).results

    protected fun createPage(
        createPageRequest: CreatePageRequest
    ): Page = notionClient.createPage(createPageRequest)
}
