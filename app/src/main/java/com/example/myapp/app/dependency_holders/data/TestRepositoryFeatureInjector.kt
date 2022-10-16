package com.example.myapp.app.dependency_holders.data

import com.example.common_impl.di.CommonComponentHolder
import com.example.common_impl.di.CommonFeatureApi
import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder2
import com.example.network_api.RetrofitProvider
import com.example.network_impl.di.NetworkComponentHolder
import com.example.network_impl.di.NetworkFeatureApi
import givemesomecoffee.ru.test_repository_impl.di.TestRepositoryFeatureComponentHolder
import givemesomecoffee.ru.test_repository_impl.di.TestRepositoryFeatureDependencies

object TestRepositoryFeatureInjector {
    fun testRepositoryFeatureInjection() {
        TestRepositoryFeatureComponentHolder.dependencyProvider = {
            class MainComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<TestRepositoryFeatureDependencies>,
                    api1: CommonFeatureApi,
                    api2: NetworkFeatureApi
                ) -> TestRepositoryFeatureDependencies
            ) : DependencyHolder2<CommonFeatureApi, NetworkFeatureApi, TestRepositoryFeatureDependencies>(
                api1 = CommonComponentHolder.get(),
                api2 = NetworkComponentHolder.get()
            )

            MainComponentDependencyHolder { dependencyHolder, commonApi, netApi ->
                object : TestRepositoryFeatureDependencies {
                    override val retrofitProvider: RetrofitProvider = netApi.retrofitProvider
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> =
                        dependencyHolder
                }
            }.dependencies
        }
    }
}