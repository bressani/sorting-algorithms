import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuickSortKtTest {

    @ParameterizedTest
    @MethodSource("provide test arguments for quickSort")
    fun `test quickSort`(expected: IntArray, array: IntArray) {
        quickSort(array, 0, array.size - 1)

        for (i in array.indices) {
            assertEquals(expected[i], array[i])
        }
    }

    fun `provide test arguments for quickSort`(): Stream<Arguments> =
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