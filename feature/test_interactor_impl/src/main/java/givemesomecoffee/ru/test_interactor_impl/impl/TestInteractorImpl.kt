package givemesomecoffee.ru.test_interactor_impl.impl

import givemesomecoffee.ru.test_interactor_api1.api.TestInteractorApi
import givemesomecoffee.ru.test_interactor_api1.model.TestInteractorDto
import givemesomecoffee.ru.test_interactor_impl.mapper.map
import givemesomecoffee.ru.test_repository_api1.api.TestRepositoryApi
import javax.inject.Inject

class TestInteractorImpl @Inject constructor(private val repository: TestRepositoryApi) :
    TestInteractorApi {
    override suspend fun getSomething(id: Int): TestInteractorDto {
        return repository.getData(id).map()
    }
}
