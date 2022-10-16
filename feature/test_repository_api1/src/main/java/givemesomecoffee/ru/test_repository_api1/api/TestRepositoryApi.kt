package givemesomecoffee.ru.test_repository_api1.api

import givemesomecoffee.ru.test_repository_api1.model.TestRepositoryFeatureDto

interface TestRepositoryApi {
    suspend fun getData(id: Int): TestRepositoryFeatureDto
}