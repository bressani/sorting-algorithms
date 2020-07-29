fun main() {
    val array = intArrayOf(3, 2, 6, 0, 5, 20, 1, 4, 0, 0, 0, 0, 1, 1, 1, 25, 25, 25, 2, 1, 3)

    quickSort(array, 0, array.size - 1)

    array.map { element -> print("${element}, ") }
}

fun quickSort(intArray: IntArray, begin: Int, end: Int) {
    if (begin < end) {
        val partitionIndex = partition(intArray, begin, end)
        quickSort(intArray, begin, partitionIndex - 1)
        quickSort(intArray, partitionIndex + 1, end)
    }
}

private fun partition(arr: IntArray, begin: Int, end: Int): Int {
    // pivot (Element to be placed at right position)
    val pivot = arr[end]
    var partitionIndex = begin

    for (i in begin until end) {

        if (arr[i] <= pivot) {
            quickSwap(arr, partitionIndex, i)
            partitionIndex++
        }
    }

    quickSwap(arr, partitionIndex, end)
    return partitionIndex
}

private fun quickSwap(arr: IntArray, i: Int, j: Int) {
    val swapTemp = arr[i]
    arr[i] = arr[j]
    arr[j] = swapTemp
}