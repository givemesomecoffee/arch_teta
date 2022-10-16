package com.example.b_feature_impl.di

import com.example.modulinjection.BaseFeatureAPI
import com.example.modulinjection.BaseFeatureDependencies
import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate
import givemesomecoffee.ru.test_interactor_api.api.TestInteractorApi

object BFeatureComponentHolder :
    ComponentHolder<BFeatureApi, BFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
            BFeatureApi,
            BFeatureDependencies,
            BFeatureComponent> { dependencies: BFeatureDependencies ->
        BFeatureComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> BFeatureDependencies)? by
    componentHolderDelegate::dependencyProvider

    override fun get(): BFeatureApi = componentHolderDelegate.getComponentImpl()
}
// то что инициализируется в холдере
interface BFeatureDependencies : BaseFeatureDependencies {
    val testInteractor: TestInteractorApi

}
//то что инициализируется в модуле или древе модулей
interface BFeatureApi : BaseFeatureAPI {

}
