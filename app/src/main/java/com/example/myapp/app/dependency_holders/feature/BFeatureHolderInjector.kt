package com.example.myapp.app.dependency_holders.feature

import com.example.b_feature_impl.di.BFeatureComponentHolder
import com.example.b_feature_impl.di.BFeatureDependencies
import com.example.modulinjection.BaseDependencyHolder
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.DependencyHolder2
import com.example.myapp.di.AppComponentHolder
import com.example.myapp.di.AppFeatureApi
import givemesomecoffee.ru.test_interactor_api.api.TestInteractorApi
import givemesomecoffee.ru.test_interactor_impl.di.TestInteractorFeatureApi
import givemesomecoffee.ru.test_interactor_impl.di.TestInteractorFeatureComponentHolder

object BFeatureHolderInjector {
    fun bFeatureInjection() {
        BFeatureComponentHolder.dependencyProvider = {
            class BFeatureComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<BFeatureDependencies>,
                    api1: AppFeatureApi,
                    api2: TestInteractorFeatureApi
                ) -> BFeatureDependencies
            ) : DependencyHolder2<AppFeatureApi, TestInteractorFeatureApi, BFeatureDependencies>(
                api1 = AppComponentHolder.get(),
                api2 = TestInteractorFeatureComponentHolder.get()
            )

            BFeatureComponentDependencyHolder { dependencyHolder, appApi, interactorApi ->
                object : BFeatureDependencies {
                    override val testInteractor: TestInteractorApi
                        get() = interactorApi.testInteractor
                    override val dependencyHolder: BaseDependencyHolder<out BaseFeatureDependencies> =
                        dependencyHolder
                }
            }.dependencies
        }
    }
}