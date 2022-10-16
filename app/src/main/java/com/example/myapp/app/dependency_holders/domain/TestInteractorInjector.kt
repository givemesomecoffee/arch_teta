package com.example.myapp.app.dependency_holders.domain

import com.example.common_impl.di.CommonComponentHolder
import com.example.common_impl.di.CommonFeatureApi
import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder2
import givemesomecoffee.ru.test_interactor_impl.di.TestInteractorFeatureComponentHolder
import givemesomecoffee.ru.test_interactor_impl.di.TestInteractorFeatureDependencies
import givemesomecoffee.ru.test_repository_api1.api.TestRepositoryApi
import givemesomecoffee.ru.test_repository_impl.di.TestRepositoryFeatureApi
import givemesomecoffee.ru.test_repository_impl.di.TestRepositoryFeatureComponentHolder

object TestInteractorInjector {
    fun testInteractorFeatureInjection() {
        TestInteractorFeatureComponentHolder.dependencyProvider = {
            class TestInteractorFeatureDependencyHolder(
                override val block: (
                    BaseDependencyHolder<TestInteractorFeatureDependencies>,
                    api1: CommonFeatureApi,
                    api2: TestRepositoryFeatureApi
                ) -> TestInteractorFeatureDependencies
            ) : DependencyHolder2<CommonFeatureApi, TestRepositoryFeatureApi, TestInteractorFeatureDependencies>(
                api1 = CommonComponentHolder.get(),
                api2 = TestRepositoryFeatureComponentHolder.get()
            )

            TestInteractorFeatureDependencyHolder { dependencyHolder, commonApi, repositoryApi ->
                object : TestInteractorFeatureDependencies {
                    override val testRepository: TestRepositoryApi
                        get() = repositoryApi.testRepository
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> =
                        dependencyHolder
                }
            }.dependencies
        }
    }
}
