package givemesomecoffee.ru.test_repository_impl.di

import com.example.modulinjection.ComponentHolder
import com.example.modulinjection.ComponentHolderDelegate

object TestRepositoryFeatureComponentHolder :
    ComponentHolder<TestRepositoryFeatureApi, TestRepositoryFeatureDependencies> {
    private val componentHolderDelegate = ComponentHolderDelegate<
            TestRepositoryFeatureApi,
            TestRepositoryFeatureDependencies,
            TestRepositoryFeatureComponent> { dependencies: TestRepositoryFeatureDependencies ->
        TestRepositoryFeatureComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> TestRepositoryFeatureDependencies)? by
    componentHolderDelegate::dependencyProvider

    override fun get(): TestRepositoryFeatureApi = componentHolderDelegate.get()
}
