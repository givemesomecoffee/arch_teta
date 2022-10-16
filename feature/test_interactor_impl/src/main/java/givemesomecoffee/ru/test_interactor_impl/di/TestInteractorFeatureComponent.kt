package givemesomecoffee.ru.test_interactor_impl.di

import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [TestInteractorFeatureDependencies::class], modules = [TestInteractorFeatureModuleBind::class])
@Singleton
internal interface TestInteractorFeatureComponent : TestInteractorFeatureApi {

    companion object {
        fun initAndGet(TestInteractorFeatureDependencies: TestInteractorFeatureDependencies): TestInteractorFeatureComponent {
            return DaggerTestInteractorFeatureComponent.builder()
                .testInteractorFeatureDependencies(TestInteractorFeatureDependencies)
                .build()
        }
    }
}
