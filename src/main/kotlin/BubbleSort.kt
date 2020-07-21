fun main() {
    val array = intArrayOf(3, 2, 6, 0, 5, 20, 1, 4, 0, 0, 0, 0, 1, 1, 1, 25, 25, 25, 2, 1, 3)

    val sortedArray = bubbleSort(array)

    sortedArray.map { a -> print("${a}, ") }
}

fun bubbleSort(intArray: IntArray): IntArray {
    val array = intArray.copyOf()

    do {
        var hasSwapped = false
        for (index in array.indices) {
            if (index == (array.size - 1))
                break

            val nextNumber: Int = array[index + 1]

            if (array[index] > nextNumber) {
                swapWithNext(array, index)
                hasSwapped = true
            }
        }


    } while (hasSwapped)

    return array

}

fun swapWithNext(array: IntArray, currentPosition: Int) {
    if (array.size - 2 < currentPosition) {
        return
    }

    val temp: Int = array[currentPosition]
    array[currentPosition] = array[currentPosition + 1]
    array[currentPosition + 1] = temp
}