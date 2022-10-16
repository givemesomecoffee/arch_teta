package givemesomecoffee.ru.test_interactor_impl.di

import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate

object TestInteractorFeatureComponentHolder:
    ComponentHolder<TestInteractorFeatureApi, TestInteractorFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
            TestInteractorFeatureApi,
            TestInteractorFeatureDependencies,
            TestInteractorFeatureComponent> { dependencies: TestInteractorFeatureDependencies ->
        TestInteractorFeatureComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> TestInteractorFeatureDependencies)? by
    componentHolderDelegate::dependencyProvider

    override fun get(): TestInteractorFeatureApi = componentHolderDelegate.get()
}
