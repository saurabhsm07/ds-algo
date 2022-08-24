"""
Problem Statement: Given an array and a number k where k is smaller than size of array, we need to find the k’th
                    smallest element in the given array. It is given that ll array elements are distinct.
Link: https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
"""

"""
Solution 1:
Sort array and return the element at kh position
Time complexity : 0(nlog(n)) #  depends on sorting algorithm chosen
"""


def get_kth_smallest(input_arr, k):
    input_arr.sort()
    print('{}th smallest element in the sort array method is = {}'.format(k, input_arr[k - 1]))


"""
Solution 2:
create a minimum heap and pop k-1 elements from the top of the heap
return root element of the heap
"""


def heapify(input_arr, i, n):
    l_child = i * 2 + 1
    r_child = i * 2 + 2
    min_pos = i
    if l_child < n and input_arr[min_pos] > input_arr[l_child]:
        min_pos = l_child
    if r_child < n and input_arr[min_pos] > input_arr[r_child]:
        min_pos = r_child

    if min_pos != i:
        input_arr[i], input_arr[min_pos] = input_arr[min_pos], input_arr[i]
        heapify(input_arr, min_pos, n)


def create_heap(ip_arr):
    n = len(ip_arr)
    for i in range(int(n/2) - 1, -1, -1):
        heapify(ip_arr, i, n)


def find_kth_smallest_heap(in_arr, k):
    create_heap(in_arr)
    for i in range(1, k):
        in_arr[0], in_arr[len(in_arr) - i] = in_arr[len(in_arr) - i], in_arr[0]  # swap elements
        heapify(in_arr, 0, len(in_arr) - i)

    print("{}th smallest using heap select method = {}".format(k, in_arr[0]))


"""
Test Cases:
"""

if __name__ == "__main__":
    # test case 1:
    test_arr = [65, 6, 33, 21, 67]
    k = 3
    get_kth_smallest(test_arr, k)

    # test case 2
    test_arr = [4, 10, 3, 5, 1]
    k = 5
    find_kth_smallest_heap(test_arr, k)

