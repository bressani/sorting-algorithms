import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InsertionSortKtTest {

    @ParameterizedTest
    @MethodSource("provide test arguments for swapWithPreviousIndex")
    fun `test swapWithPreviousIndex`(expected: IntArray, array: IntArray, position: Int) {
        val actualSwappedArray = swapWithPreviousIndex(array, position)

        for (i in array.indices) {
            assertEquals(expected[i], actualSwappedArray[i])
        }
    }

    fun `provide test arguments for swapWithPreviousIndex`(): Stream<Arguments> =
        Stream.of(
            Arguments.of(intArrayOf(1, 2), intArrayOf(2, 1), 1),
            Arguments.of(intArrayOf(1, 2, 3, 5, 4), intArrayOf(1, 2, 3, 4, 5), 4),
            Arguments.of(intArrayOf(1, 2), intArrayOf(1, 2), 0),
            Arguments.of(intArrayOf(1, 2), intArrayOf(1, 2), -1),
            Arguments.of(intArrayOf(), intArrayOf(), 0),
            Arguments.of(intArrayOf(), intArrayOf(), 1)
        )

    @ParameterizedTest
    @MethodSource("provide test arguments for insertionSort")
    fun `test insertionSort`(expected: IntArray, array: IntArray) {
        val actual = insertionSort(array)

        for (i in array.indices) {
            assertEquals(expected[i], actual[i])
        }
    }

    fun `provide test arguments for insertionSort`(): Stream<Arguments> =
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