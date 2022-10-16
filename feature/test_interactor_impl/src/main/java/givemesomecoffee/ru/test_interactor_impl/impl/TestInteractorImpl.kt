package givemesomecoffee.ru.test_interactor_impl.impl

import givemesomecoffee.ru.test_interactor_api.api.TestInteractorApi
import givemesomecoffee.ru.test_interactor_api.model.TestInteractorDto
import givemesomecoffee.ru.test_interactor_impl.map
import givemesomecoffee.ru.test_repository_api.api.TestRepositoryApi
import javax.inject.Inject

class TestInteractorImpl @Inject constructor(private val repository: TestRepositoryApi):
    TestInteractorApi {
    override suspend fun getSomething(id: Int): TestInteractorDto {
        return repository.getData(id).map()
    }
}
