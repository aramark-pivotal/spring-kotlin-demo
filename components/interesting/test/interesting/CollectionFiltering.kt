import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.Spec
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith


class SomeCollection {
    val numbers = listOf(1,2,3,4,5,6,7,8,9)
    var divisor = 2

    fun matches(n : Int) =
        n.rem(divisor) == 0

    fun filter(): List<Int> {
        val matchesFunction = this::matches

        return numbers.filter(matchesFunction)
    }
}

@RunWith(JUnitPlatform::class)
class CollectionFilteringSpec : Spek(object {
    var spec: Spec.() -> Unit = {
        it("allows methods of a class to be passed around as first class functions") {
            val someCollection = SomeCollection()
            someCollection.divisor = 2
            val even = someCollection.filter()
            assertThat(even).isEqualTo(listOf(2,4,6,8))

            someCollection.divisor = 3
            val triples = someCollection.filter()
            assertThat(triples).isEqualTo(listOf(3,6,9))
        }
    }
}.spec)
