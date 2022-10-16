package givemesomecoffee.ru.test_repository_impl.remote

import givemesomecoffee.ru.test_repository_api.model.TestRepositoryFeatureDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TestRepositoryFeatureRest {
    @GET("users/posts/links/{postsId}")
    suspend fun getMains(
        @Query("postsId") postsId: Int
    ): TestRepositoryFeatureDto
}