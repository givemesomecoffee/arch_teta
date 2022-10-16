package givemesomecoffee.ru.test_interactor_impl.mapper

import givemesomecoffee.ru.test_interactor_api1.model.TestInteractorDto
import givemesomecoffee.ru.test_repository_api1.model.TestRepositoryFeatureDto

fun TestRepositoryFeatureDto.map(): TestInteractorDto {
    return TestInteractorDto(
        master = master,
        violet = violet
    )
}
