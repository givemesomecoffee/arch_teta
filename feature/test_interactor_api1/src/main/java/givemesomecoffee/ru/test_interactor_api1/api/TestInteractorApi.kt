package givemesomecoffee.ru.test_interactor_api1.api

import givemesomecoffee.ru.test_interactor_api1.model.TestInteractorDto

interface TestInteractorApi {
    suspend fun getSomething(id: Int): TestInteractorDto
}