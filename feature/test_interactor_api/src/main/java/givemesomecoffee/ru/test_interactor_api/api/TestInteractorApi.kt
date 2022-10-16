package givemesomecoffee.ru.test_interactor_api.api

import givemesomecoffee.ru.test_interactor_api.model.TestInteractorDto

interface TestInteractorApi {
    suspend fun getSomething(id: Int): TestInteractorDto
}