fun main() {
    val array = intArrayOf(3, 2, 6, 0, 5, 20, 1, 4, 0, 0, 0, 0, 1, 1, 1, 25, 25, 25, 2, 1, 3)

    val sortedArray = selectionSort(array)

    sortedArray.map { a -> print("${a}, ") }
}

fun selectionSort(array: IntArray): IntArray {
    var unsortedArrayStartIndex = 0
    var currentMinNumberIndex = 0

    do {

        for (i in unsortedArrayStartIndex until array.size) {
            if (array[i] <= array[currentMinNumberIndex]) {
                currentMinNumberIndex = i
            }
        }

        swap(array, currentMinNumberIndex, unsortedArrayStartIndex++)

    } while (unsortedArrayStartIndex < array.size - 1)

    return array
}

fun swap(array: IntArray, currentMinNumberIndex: Int, unsortedArrayStartIndex: Int) {
    val temp = array[unsortedArrayStartIndex]
    array[unsortedArrayStartIndex] = array[currentMinNumberIndex]
    array[currentMinNumberIndex] = temp
}
