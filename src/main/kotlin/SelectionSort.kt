fun main() {
    val array = intArrayOf(3, 2, 6, 0, 5, 20, 1, 4, 0, 0, 0, 0, 1, 1, 1, 25, 25, 25, 2, 1, 3)

    val sortedArray = selectionSort(array)

    sortedArray.map { element -> print("${element}, ") }
}

fun selectionSort(intArray: IntArray): IntArray {
    var array = intArray.clone()
    var unsortedArrayStartIndex = 0
    var currentMinNumberIndex: Int

    do {
        currentMinNumberIndex = unsortedArrayStartIndex
        for (i in unsortedArrayStartIndex until array.size) {
            if (array[i] <= array[currentMinNumberIndex]) {
                currentMinNumberIndex = i
            }
        }

        array = selectionSwap(array, currentMinNumberIndex, unsortedArrayStartIndex++)

    } while (unsortedArrayStartIndex < array.size - 1)

    return array
}

fun selectionSwap(array: IntArray, currentMinNumberIndex: Int, unsortedArrayStartIndex: Int): IntArray {
    val maxPositionNum = array.size - 1

    if (currentMinNumberIndex > maxPositionNum || unsortedArrayStartIndex > maxPositionNum) return array

    val swappedArray = array.clone()

    val temp = swappedArray[unsortedArrayStartIndex]
    swappedArray[unsortedArrayStartIndex] = swappedArray[currentMinNumberIndex]
    swappedArray[currentMinNumberIndex] = temp

    return swappedArray
}
