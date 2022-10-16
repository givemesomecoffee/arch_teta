package givemesomecoffee.ru.test_repository_impl.di

import com.example.modulinjection.BaseFeatureAPI
import givemesomecoffee.ru.test_repository_api.api.TestRepositoryApi

interface TestRepositoryFeatureApi : BaseFeatureAPI {
    val testRepository: TestRepositoryApi
}
