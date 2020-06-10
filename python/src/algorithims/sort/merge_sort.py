"""
Problem Statement: Sort array using divide and conquer merge sort algorithm
Time Complexity = 0(nlog(n))
Link: https://www.geeksforgeeks.org/merge-sort/
"""

"""
Algorithm:
    MergeSort(arr[], l,  r)
    If r > l
         1. Find the middle point to divide the array into two halves:  
                 middle m = (l+r)/2
         2. Call mergeSort for first half:   
                 Call mergeSort(arr, l, m)
         3. Call mergeSort for second half:
                 Call mergeSort(arr, m+1, r)
         4. Merge the two halves sorted in step 2 and 3:
                 Call merge(arr, l, m, r)
"""


def merge_sort(input_arr, low, high):
    """
    divides the array and sorts adjacent parts then merges them
    :param input_arr: array to be sorted
    :param low: the starting point from which sorting sub-array begins
    :param high: the end point of sorting the sub-array
    :return:
    """
    if high - 1 > low:
        middle = int((high + low) / 2)

        # uncomment below lines of code to see the steps:
        # print("******************* \n i/p = ", input_arr[low: high])
        # print("DIVIDE; low = {}, mid = {}, high = {}:".format(low, middle, high))
        # print("o/p = ", input_arr[low: middle], input_arr[middle: high])

        merge_sort(input_arr, low, middle)
        merge_sort(input_arr, middle, high)
        merge_arr(input_arr, low, middle, high)


def merge_arr(arr, l, m, h):
    """
    merges 2 sorted sub-arrays into one
    :param arr: input array to be merged
    :param l: low point of the sub-array
    :param m: middle of the sub-array split
    :param h: end point of the sub-array to be merged
    :return:
    """

    arr_a = arr[l:m]
    arr_b = arr[m:h]

    i = j = 0
    k = l
    while i < len(arr_a) and j < len(arr_b):
        if arr_a[i] < arr_b[j]:
            arr[k] = arr_a[i]
            i += 1
        else:
            arr[k] = arr_b[j]
            j += 1
        k += 1

    while i < len(arr_a):
        arr[k] = arr_a[i]
        i += 1
        k += 1

    while j < len(arr_b):
        arr[k] = arr_b[j]
        j += 1
        k += 1

# uncomment below lines of code to see the steps:
#     print("*******************  \n i/p = ", arr_a, arr_b)
#     print("CONQUER; low = {}, mid = {}, high = {}:".format(l, m, h))
#     print("o/p = ", arr[l: h])


"""
Test Cases:
"""
if __name__ == '__main__':
    test_arr = [22, 32, 45, 53, 22]
    merge_sort(test_arr, 0, len(test_arr))
    print("*********** \n sorted array = ", test_arr)
