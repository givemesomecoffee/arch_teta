include (":feature:afeatureimpl")
include (":feature:afeatureapi")
include (":feature:bfeatureimpl")
include (":feature:bfeatureapi")
include (":feature:cfeatureimpl")
include (":feature:cfeatureapi")

include (":core:modulinjection")
include (":core:commonimpl")
include (":core:commonapi")
include (":core:database")
include (":core:networkimpl")
include (":core:networkapi")

include (":app")
rootProject.name = "MyApp"
include(":feature:test_repository_impl")
include(":feature:test_interactor_impl")
include(":feature:test_repository_api1")
include(":feature:test_interactor_api1")
