package givemesomecoffee.ru.test_repository_api.api

import givemesomecoffee.ru.test_repository_api.model.TestRepositoryFeatureDto

interface TestRepositoryApi {
    suspend fun getData(id: Int): TestRepositoryFeatureDto
}