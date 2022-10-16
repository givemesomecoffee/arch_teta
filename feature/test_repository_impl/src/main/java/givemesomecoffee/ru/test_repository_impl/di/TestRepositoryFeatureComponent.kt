package givemesomecoffee.ru.test_repository_impl.di

import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [TestRepositoryFeatureDependencies::class],
    modules = [TestRepositoryFeatureModuleProvide::class, TestRepositoryModuleBind::class]
)
@Singleton
internal interface TestRepositoryFeatureComponent : TestRepositoryFeatureApi {

    companion object {
        fun initAndGet(TestRepositoryFeatureDependencies: TestRepositoryFeatureDependencies): TestRepositoryFeatureComponent {
            return DaggerTestRepositoryFeatureComponent.builder()
                .testRepositoryFeatureDependencies(TestRepositoryFeatureDependencies)
                .build()
        }
    }
}
