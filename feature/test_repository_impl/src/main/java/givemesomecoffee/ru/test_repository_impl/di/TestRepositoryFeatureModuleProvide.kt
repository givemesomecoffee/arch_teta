package givemesomecoffee.ru.test_repository_impl.di

import com.example.network_api.RetrofitProvider
import dagger.Module
import dagger.Provides
import givemesomecoffee.ru.test_repository_impl.remote.TestRepositoryFeatureRest
import javax.inject.Singleton

@Module
class TestRepositoryFeatureModuleProvide {
    @Singleton
    @Provides
    fun provideFeedApi(retrofit: RetrofitProvider) = retrofit.retrofit.create(
        TestRepositoryFeatureRest::class.java)
}
