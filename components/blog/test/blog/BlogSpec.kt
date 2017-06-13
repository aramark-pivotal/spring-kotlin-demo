package blog

import junit.framework.Assert.assertTrue
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.Spec
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith


class Foo {
    fun doSomething(): Boolean {
        return true
    }
}


@RunWith(JUnitPlatform::class)
class BlogSpec : Spek(object {
    lateinit var foo: Foo

    fun spec(): Spec.() -> Unit = {
        beforeEachTest {
            foo = Foo()
        }

        it("does things") {
            assertTrue(foo.doSomething())
        }
    }
}.spec())



