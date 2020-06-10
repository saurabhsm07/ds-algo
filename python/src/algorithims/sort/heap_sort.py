"""
Problem Statement: Sort array using heap sort algorithm
Time Complexity = 0(nlog(n))
Link: https://www.geeksforgeeks.org/heap-sort/
"""

"""
Algorithm:
    heapSort:
        1. Build a max heap from the input data.
        2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap, 
           followed by reducing the size of heap by 1. Finally, heapify the root of tree.
        3. Repeat above steps while size of heap is greater than 1.    
"""


def heapify(in_arr, i, n):
    """
    creates a max heap from the recursive array
    :param in_arr: input array whose heap is to be created
    :param i: current parent element
    :param n: length of the array
    :return: void
    """
    l_child = 2 * i + 1
    r_child = 2 * i + 2
    max_ele = i
    if l_child < n and in_arr[l_child] > in_arr[max_ele]:
        max_ele = l_child
    if r_child < n and in_arr[r_child] > in_arr[max_ele]:
        max_ele = r_child
    if max_ele != i:
        in_arr[i], in_arr[max_ele] = in_arr[max_ele], in_arr[i]
        heapify(in_arr, max_ele, n)


def heap_sort(input_arr):
    """
    sorts the input array using heap sort method
    :param input_arr: array to be sorted
    """
    n = len(input_arr)
    for i in range(int(n/2) - 1, -1, -1):
        heapify(input_arr, i, n)
    print("heap done")
    print(input_arr)
    for i in range(1, n):
        input_arr[0], input_arr[n - i] = input_arr[n - i], input_arr[0]
        heapify(input_arr, 0, n - i)

    print(input_arr)


"""
Test Cases:
"""

if __name__ == '__main__':
    test_arr = [22, 1, 55, 43, 12, -6]
    heap_sort(test_arr)

