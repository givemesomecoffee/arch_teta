package givemesomecoffee.ru.test_repository_impl.impl

import givemesomecoffee.ru.test_repository_api1.api.TestRepositoryApi
import givemesomecoffee.ru.test_repository_api1.model.TestRepositoryFeatureDto
import givemesomecoffee.ru.test_repository_impl.remote.TestRepositoryFeatureRest
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(private val api: TestRepositoryFeatureRest):
    TestRepositoryApi {
    override suspend fun getData(id: Int): TestRepositoryFeatureDto {
        return api.getMains(id)
    }
}
