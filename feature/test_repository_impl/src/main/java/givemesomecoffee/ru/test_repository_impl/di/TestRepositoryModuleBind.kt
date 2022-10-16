package givemesomecoffee.ru.test_repository_impl.di

import dagger.Binds
import dagger.Module
import givemesomecoffee.ru.test_repository_api1.api.TestRepositoryApi
import givemesomecoffee.ru.test_repository_impl.impl.TestRepositoryImpl
import javax.inject.Singleton

@Module
interface TestRepositoryModuleBind {
    @Singleton
    @Binds
    fun provideRep(api: TestRepositoryImpl): TestRepositoryApi
}