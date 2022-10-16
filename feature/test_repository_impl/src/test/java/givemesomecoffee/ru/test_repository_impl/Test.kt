package givemesomecoffee.ru.test_repository_impl

import givemesomecoffee.ru.test_repository_api1.MyClass
import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun addition_isCorrect() {
      val test =   MyClass()
        Assert.assertEquals(4, test.test + test.test)
    }
}