package givemesomecoffee.ru.test_interactor_impl.di

import com.example.modulinjection.BaseFeatureAPI
import givemesomecoffee.ru.test_interactor_api.api.TestInteractorApi

interface TestInteractorFeatureApi : BaseFeatureAPI {
    val testInteractor: TestInteractorApi
}
