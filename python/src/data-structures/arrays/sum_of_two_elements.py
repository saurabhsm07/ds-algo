import math

"""Problem Statement: Given an array that is sorted and then rotated around an unknown point. Find if the array has a 
pair with a given sum ‘x’. It may be assumed that all elements in the array are distinct. 
link: https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
"""

"""
 Algorithm:
    let len = array length;  value = sum value to be matched
    find pos of largest element in array as a[prev_pos] < a[ele_pos] > a[next_pos]
    where  next_pos =  (len + (ele_pos + 1)) mod len;
           prev_pos =  (len - (ele_pos - 1)) mod len
    set largest = ele_pos, smallest = next_pos
    while largest != smallest
     if arr[largest] + arr[smallest] > value
        largest = largest -> next 
     if arr[largest] + arr[smallest] < value   
        smallest = smallest -> next
    else 
       value matched return smallest, largest position values 
"""


def find_sum_in_arr(input_arr, sum_value, search_algo=1):
    """
    :param search_algo: search algorithm to use between linear or binary
    :param input_arr:  input sorted rotated array
    :param sum_value: value we have to match as sum of 2 elements in array
    :return: position tuple in array that match the given sum if it exists ; (-1, -1) otherwise
    """

    if search_algo == 1:
        smallest, largest = get_smallest_largest_linear(input_arr)
    else:
        smallest, largest = get_smallest_largest_binary(input_arr)

    while smallest != largest:
        if input_arr[smallest] + input_arr[largest] < sum_value:
            smallest = int(math.fmod((len(input_arr) + (smallest + 1)), len(input_arr)))
        elif input_arr[smallest] + input_arr[largest] > sum_value:
            largest = int(math.fmod((len(input_arr) + (largest - 1)), len(input_arr)))
        else:
            return smallest, largest
    return -1, -1


def get_smallest_largest_linear(input_arr):
    """
    time-complexity =  O(n)
    returns touple of smallest and largest elements in a array
    :param input_arr:
    :return: (ele1, ele2)
    """
    smallest = 0
    largest = 0
    for i in range(0, len(input_arr)):
        prev_pos = int(math.fmod((len(input_arr) - (i - 1)), len(input_arr)))
        next_pos = int(math.fmod((len(input_arr) + (i + 1)), len(input_arr)))
        if input_arr[i] > input_arr[prev_pos] and input_arr[i] > input_arr[next_pos]:
            largest = i
            smallest = next_pos
            break

    return smallest, largest


"""
Time complexity: O(log n) 
Algorithm: Binary search: 
The minimum element is the only element whose previous is greater than it.
If there is no previous element element, then there is no rotation (first element is minimum). 
We check this condition for middle element by comparing it with (mid-1)’th and (mid+1)’th elements. 
If minimum element is not at middle (neither mid nor mid + 1), then minimum element lies in either left half or right half.
If middle element is smaller than last element, then the minimum element lies in left half Else minimum element lies in right 
half. 
"""


def get_smallest_largest_binary(input_arr):
    middle = int(len(input_arr) / 2)
    low = 0
    high = len(input_arr) - 1

    while low < high:
        if input_arr[middle - 1] > input_arr[middle]:
            if middle == 0:
                return middle, len(input_arr) - 1
            else:
                return middle, middle - 1
        elif input_arr[middle] > input_arr[high]:
            low = middle + 1
            middle = int((low + high) / 2)
        else:
            high = middle - 1
            middle = int((low + high) / 2)
    return -1, -1


def check_if_exists(arr, val, switch=1):
    x, y = find_sum_in_arr(arr, val, switch)
    if x == y and x == -1:
        print('sum {} does not exist in the array'.format(val))
    else:
        print('sum {} is gained from (val_1, pos_1) = ({}, {}) and (val_2, pos_2) = ({}, {})'.format(val, arr[x], x,
                                                                                                     arr[y], y))


"""
Test Cases:
"""

# test case 1:
ip_arr = [4, 5, 1, 2, 3]
sum_val = 9
check_if_exists(ip_arr, sum_val)

# test case 2:
ip_arr = [11, 15, 26, 38, 9, 10]
sum_val = 21
check_if_exists(ip_arr, sum_val)

# test case 3:
ip_arr = [4, 5, 1, 2, 3]
sum_val = 9
check_if_exists(ip_arr, sum_val, 2)

# test case 4:
ip_arr = [11, 15, 26, 38, 9, 10]
sum_val = 21
check_if_exists(ip_arr, sum_val, 2)