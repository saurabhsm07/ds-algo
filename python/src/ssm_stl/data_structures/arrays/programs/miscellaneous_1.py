"""
Miscellaneous problems related to the array data structure:
"""

"""
Problem statement 1: Rearrange an array such that arr[i] = i; -1 if element not present
link: https://www.geeksforgeeks.org/rearrange-array-arri/
"""


# Solution 1:  swap element with rightful position if not -1


def rearrange_array_p1s1(input_arr):
    for i in range(0, len(input_arr)):
        if input_arr[i] != -1 and input_arr[i] != i:
            input_arr[i] = input_arr[i] + input_arr[input_arr[i]]
            input_arr[input_arr[i]] = input_arr[i] - input_arr[input_arr[i]]
            input_arr[i] = input_arr[i] - input_arr[input_arr[i]]
    print(input_arr)


# solution 2: use hash set to save unique elements


def rearrange_array_p1s2(input_arr):
    ele_set = set()
    for i in range(0, len(input_arr)):
        if input_arr[i] != -1:
            ele_set.add(input_arr[i])

    for i in range(0, len(input_arr)):
        if i in ele_set:
            input_arr[i] = i
        else:
            input_arr[i] = -1

    print(input_arr)


"""
Test cases:
"""

if __name__ == "__main__":
    print("************* \n TESTING P1S1 \n")
    A = [-1, -1, 6, 1, 9, 3, 2, -1, 4, -1]
    rearrange_array_p1s2(A)
    print("************* \n TESTING P1S2 \n")
    rearrange_array_p1s1(A)

"""
Problem statement 2: Given an array of size n where all elements are distinct and in range from 0 to n-1, 
                        change contents of arr[] so that arr[i] = j is changed to arr[j] = i.
link: https://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/ 
"""


# solution 1:

def rearrange_array_p2s1(input_arr):
    next_val = [-1, -1]
    current_val = [input_arr[0], 0]

    for i in range(0, len(input_arr)):

        if next_val[1] == 0:
            current_val[0] = input_arr[i]
            current_val[1] = i
            # print(current_val)
        next_val[0] = input_arr[current_val[0]]
        next_val[1] = current_val[0]
        # print(next_val)
        input_arr[current_val[0]] = current_val[1]
        current_val[0] = next_val[0]
        current_val[1] = next_val[1]
    print(input_arr)


"""
Test cases:        
"""
print("************* \n TESTING P2S1 \n")

# test case 1:
in_arr = [1, 3, 0, 2]
rearrange_array_p2s1(in_arr)

# test case 2:
in_arr = [2, 0, 1, 4, 5, 3]
rearrange_array_p2s1(in_arr)

# test case 3:
in_arr = [0, 1, 2, 3]
rearrange_array_p2s1(in_arr)

"""
Problem Statement: Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
                    For example, 
                    if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.
Link: https://www.geeksforgeeks.org/move-zeroes-end-array/
"""


# solution 1:


def rearrange_array_p3s1(input_arr):
    count = 0
    for i in range(len(input_arr)):
        if input_arr[i] != 0:
            input_arr[count] = input_arr[i]
            count += 1

    while count < len(input_arr):
        input_arr[count] = 0
        count += 1
    print(input_arr)


"""
Test cases:        
"""
print("************* \n TESTING P3S1 \n")

# test case 1:
in_arr = [1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0]
rearrange_array_p3s1(in_arr)

"""
Difficult, read solution
Problem Statement: Given a sorted array of positive integers, rearrange the array alternately 
                    i.e first element should be the maximum value, second minimum value, third-second max, fourth-second min and so on.
                    in 0(n) time and 0(1) space
link: https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/                
"""

"""
"From G4Gs 
Algorithm: 
    even index : remaining maximum element.
    odd index  : remaining minimum element.
    
    max_index : Index of remaining maximum element
            (Moves from right to left)
    min_index : Index of remaining minimum element
            (Moves from left to right)
    
    Initialize: max_index = 'n-1'
            min_index = 0  
            max_element = arr[max_index] + 1 //can be any element which is more than the maximum value in array
    
    For i = 0 to n-1            
    If 'i' is even
       arr[i] += arr[max_index] % max_element * max_element 
       max_index--     
    ELSE // if 'i' is odd
       arr[i] +=  arr[min_index] % max_element * max_element
       min_index++

    **IMPORTANT** 
    How does expression “arr[i] += arr[max_index] % max_element * max_element” work ?
    The purpose of this expression is to store two elements at index arr[i]. arr[max_index] is stored as multiplier and 
    “arr[i]” is stored as remainder. For example in {1 2 3 4 5 6 7 8 9}, 
    max_element is 10 and we store 91 at index 0. With 91, we can get original element as 91%10 and new element as 91/10.
"""


# solution 1


def rearrange_array_p4s1(input_arr):
    min_index = 0
    max_index = len(input_arr) - 1
    max_element = input_arr[max_index] * 10

    for i in range(len(input_arr)):
        print("ITERATION :", (i + 1))
        if i % 2 == 0:
            print('even element', input_arr[i], 'max index ele', input_arr[max_index])
            input_arr[i] += input_arr[max_index] % max_element * max_element
            max_index -= 1
        else:
            print('odd :', input_arr[i], 'min index ele', input_arr[min_index])
            input_arr[i] += input_arr[min_index] % max_element * max_element
            min_index += 1

    print('internal step', input_arr)
    for i in range(len(input_arr)):
        input_arr[i] = int(input_arr[i] / max_element)
    print(input_arr)


"""
Test Cases:
"""

# test case 1:
print("************* \n TESTING P4S1 \n")
text_arr = [1, 2, 3, 4, 5, 6, 7]
rearrange_array_p4s1(text_arr)
