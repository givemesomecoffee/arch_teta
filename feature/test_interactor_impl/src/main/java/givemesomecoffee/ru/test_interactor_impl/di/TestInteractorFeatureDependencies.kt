package givemesomecoffee.ru.test_interactor_impl.di

import com.example.modulinjection.BaseFeatureDependencies
import givemesomecoffee.ru.test_repository_api1.api.TestRepositoryApi

interface TestInteractorFeatureDependencies : BaseFeatureDependencies {
    val testRepository: TestRepositoryApi
}
