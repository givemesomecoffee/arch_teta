package givemesomecoffee.ru.test_interactor_impl.di

import dagger.Binds
import dagger.Module
import givemesomecoffee.ru.test_interactor_api.api.TestInteractorApi
import givemesomecoffee.ru.test_interactor_impl.impl.TestInteractorImpl
import javax.inject.Singleton

@Module
interface TestInteractorFeatureModuleBind {
    @Singleton
    @Binds
    fun getInteractor(interactor: TestInteractorImpl): TestInteractorApi
}
