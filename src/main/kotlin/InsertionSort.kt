fun main() {
    val array = intArrayOf(3, 2, 6, 0, 5, 20, 1, 4, 0, 0, 0, 0, 1, 1, 1, 25, 25, 25, 2, 1, 3)

    val sortedArray = insertionSort(array)

    sortedArray.map { element -> print("${element}, ") }
}

fun insertionSort(intArray: IntArray): IntArray {
    var unsortedArrayFirstIndex = 0
    var sortedArray = intArray.clone()
    intArray.forEach { currentNum ->
        for (i in unsortedArrayFirstIndex downTo 0) {
            if (i == 0) break

            if (currentNum <= sortedArray[i - 1]) {
                sortedArray = swapWithPreviousIndex(sortedArray, i)
            }
        }
        unsortedArrayFirstIndex++
    }

    return sortedArray
}

fun swapWithPreviousIndex(intArray: IntArray, currentPosition: Int): IntArray {
    val array = intArray.copyOf()

    if (currentPosition <= 0 || intArray.isEmpty()) return array

    val temp: Int = array[currentPosition]
    array[currentPosition] = array[currentPosition - 1]
    array[currentPosition - 1] = temp

    return array
}
