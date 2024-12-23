package givemesomecoffee.ru.test_repository_impl.di

import com.example.modulinjection.BaseFeatureDependencies
import com.example.network_api.RetrofitProvider

interface TestRepositoryFeatureDependencies : BaseFeatureDependencies {
    val retrofitProvider: RetrofitProvider
}
