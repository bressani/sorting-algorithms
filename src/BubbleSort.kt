fun main() {
    val array = intArrayOf(3, 2, 6, 0, 5, 20, 1, 4, 0, 0, 0, 0, 1, 1, 1, 25, 25, 25, 2, 1, 3)

    sort(array)

    array.map { a -> print("${a}, ") }
}

fun sort(array: IntArray) {
    do {
        var hasSwapped = false;
        for (index in (array.indices)) {
            if (index == (array.size - 1))
                break

            val nextNumber: Int = array[index + 1]

            if (array[index] > nextNumber) {
                swapWithNext(array, index)
                hasSwapped = true
            }
        }


    } while (hasSwapped)

}

fun swapWithNext(array: IntArray, currentPosition: Int) {
    val temp: Int = array[currentPosition]
    array[currentPosition] = array[currentPosition + 1]
    array[currentPosition + 1] = temp
}