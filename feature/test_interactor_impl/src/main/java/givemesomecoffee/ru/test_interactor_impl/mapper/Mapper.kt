package givemesomecoffee.ru.test_interactor_impl

import givemesomecoffee.ru.test_interactor_api.model.TestInteractorDto
import givemesomecoffee.ru.test_repository_api.model.TestRepositoryFeatureDto

fun TestRepositoryFeatureDto.map(): TestInteractorDto {
    return TestInteractorDto(
        master = master,
        violet = violet
    )
}