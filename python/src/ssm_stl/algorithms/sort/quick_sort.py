"""
Problem Statement: Sort array using heap sort algorithm
Time Complexity = 0(nlog(n)) (most cases) ; worst case: 0(n ^ 2)
Link: https://www.geeksforgeeks.org/quick-sort/
"""

"""
Algorithm:
    quickSort:
         /* low  --> Starting index,  high  --> Ending index */
    quickSort(arr[], low, high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is now
               at right place */
            pi = partition(arr, low, high);
    
            quickSort(arr, low, pi - 1);  // Before pi
            quickSort(arr, pi + 1, high); // After pi
        }
} 
"""


def quick_sort(input_arr, low, high):
    """
    sorts the input array using divide and conquer quick sort algorithm
    :param input_arr: array to be sorted
    :param low: starting index of array / sub-array
    :param high: last index of array / sub-array
    :return:  void
    """

    if low < high:
        pivot = partition(input_arr, low, high)
        print('********** \n Quick Sort  INPUT: {} \n Partition OUTPUT: {}, {}'.format(input_arr[low: high + 1],
                                                                                         input_arr[low: pivot],
                                                                                         input_arr[pivot + 1: high + 1]))
        quick_sort(input_arr, low, pivot - 1)
        quick_sort(input_arr, pivot + 1, high)


def partition(in_arr, l, h):
    """
    partitions the input array/ sub-array aroud a pivot point (last element : high)
    :param in_arr: array to be partitioned
    :param l:  first index of array
    :param h: last index of array
    :return: pivot position
    """
    pivot = h
    i = l - 1
    for j in range(l, h):
        if in_arr[j] <  in_arr[pivot]:
            i += 1
            if i != j:
                in_arr[i], in_arr[j] = in_arr[j], in_arr[i]
    i = i + 1
    in_arr[i], in_arr[pivot] = in_arr[pivot], in_arr[i]
    return i


"""
Test Cases:
"""
if __name__ == '__main__':
    test_arr = [12, 55, 2, 14, 66, 3]
    quick_sort(test_arr, 0, len(test_arr) - 1)
    print(test_arr)
