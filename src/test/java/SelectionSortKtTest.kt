import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SelectionSortKtTest {

    @ParameterizedTest
    @MethodSource("provide test arguments for swap")
    fun `test swap`(expected: IntArray, actual: IntArray, position1: Int, position2: Int) {
        val actualSwappedArray = swap(actual, position1, position2)

        for (i in actual.indices) {
            assertEquals(expected[i], actualSwappedArray[i])
        }
    }

    fun `provide test arguments for swap`(): Stream<Arguments> =
        Stream.of(
            Arguments.of(intArrayOf(1, 2), intArrayOf(2, 1), 1, 0),
            Arguments.of(intArrayOf(1, 2, 3, 5, 4), intArrayOf(1, 2, 3, 5, 4), 3, 3),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 5, 4), 3, 4),
            Arguments.of(intArrayOf(1, 2), intArrayOf(1, 2), 1, 2),
            Arguments.of(intArrayOf(1, 2), intArrayOf(1, 2), 3, 4)
        )

    @ParameterizedTest
    @MethodSource("provide test arguments for selectionSort")
    fun `test selectionSort`(expected: IntArray, array: IntArray) {
        val actual = selectionSort(array)

        for (i in array.indices) {
            assertEquals(expected[i], actual[i])
        }
    }

    fun `provide test arguments for selectionSort`(): Stream<Arguments> =
        Stream.of(
            Arguments.of(intArrayOf(1, 2), intArrayOf(1, 2)),
            Arguments.of(intArrayOf(1, 2), intArrayOf(2, 1)),
            Arguments.of(intArrayOf(2), intArrayOf(2)),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5)),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), intArrayOf(5, 4, 3, 2, 1)),
            Arguments.of(intArrayOf(1, 3, 3, 3, 3, 4, 5), intArrayOf(5, 4, 3, 3, 3, 3, 1)),
            Arguments.of(intArrayOf(1, 1, 3, 3, 3, 3, 4, 5), intArrayOf(5, 4, 3, 3, 3, 3, 1, 1)),
            Arguments.of(intArrayOf(3, 3, 3, 3, 3), intArrayOf(3, 3, 3, 3, 3)),
            Arguments.of(intArrayOf(), intArrayOf())
        )
}