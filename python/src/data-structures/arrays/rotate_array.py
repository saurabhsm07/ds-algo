import math

"""
Problem Statement : Write a function rotate_array_method_1 that rotates arr[] of size n by d elements.
link: https://www.geeksforgeeks.org/array-rotation/
"""


"""
    
    algorithm :
        i/p: arr, d
        save arr[0] in temp
        set pos = 0, count = 0
        while count from 0 to len(arr) - 1
            next_pos = (pos + d) % len(arr)    //find element to be placed at current position
            arr[pos] = arr[next_pos]           //replicate that element in its new position and overwrite the current position element
            pos = next_pos                     //move to the next position to be replaced

        arr[pos] = temp                         //place first element at the rightful position
     time complexity = 0(n)
     space complexity = 0(1)

*my solution
"""


def rotate_array_method_1(arr, factor):
    """
     return input_array

    :rtype: rotated array of input elements
    """
    factor = int(math.fmod(factor, len(arr)))
    temp = arr[0]
    count = 0
    pos = 0
    if factor == 0:
        return arr
    else:
        for count in range(0, len(arr) - 1):
            next_pos = math.fmod(pos + factor, len(arr))
            arr[int(pos)] = arr[int(next_pos)]
            pos = next_pos

        arr[int(pos)] = temp

        return arr


"""
    algorithm:
    Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is :

        Reverse A to get ArB, where Ar is reverse of A.
        Reverse B to get ArBr, where Br is reverse of B.
        Reverse all to get (ArBr) r = BA.
        
    
    link: https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
"""


def rotate_array_method_2(arr, factor):
    """
    param arr: input array to be rotated
    :param factor: number of times to be left rotated
    :return: rotated array
    """
    factor = int(math.fmod(factor, len(arr)))
    if factor == 0:
        return arr
    else:
        reverse(arr, 0, factor - 1)
        reverse(arr, factor, len(arr) - 1)
        reverse(arr, 0, len(arr) - 1)
        return arr


def reverse(arr, start, end):
    """
    function reverse the subarray from start point to end point
    :param arr: input array
    :param start: start location from array needs to be rotated
    :param end:  end location from array needs to be rotated
    :return: void
    """
    print(start, end)
    while start < end:
        arr[start] = arr[end] + arr[start]
        arr[end] = arr[start] - arr[end]
        arr[start] = arr[start] - arr[end]
        start = start + 1
        end = end - 1


"""
Test Cases:
"""

# Test method 1:
input_array = [1, 2, 3, 4, 5]
rotation_factor = 3

result = rotate_array_method_1(input_array, rotation_factor)

print(result)

# Test method 2:
input_array = [1, 2, 3, 4, 5]
rotation_factor = 3

result = rotate_array_method_2(input_array, rotation_factor)

print(result)
