def quick_sort(lst):
    if len(lst) <= 1:
        return lst

    pivot = len(lst)//2
    min_lst = []
    max_lst = []

    for num in lst:
        if num < lst[pivot]:
            min_lst.append(num)
        elif num > lst[pivot]:
            max_lst.append(num)

    return quick_sort(min_lst) + [lst[pivot]] + quick_sort(max_lst)

# [1,2,3] + [4,5,6] => o
# [1,2] + [3] + [4,5] => o
# [1,2] + 3 + [4,5] => x

lst = [1, 4, 2, 0, 9, 5, 3]
print(quick_sort(lst))

# test1. pivot값이 가장 작은 수 일때
lst1 = [2,3,1,6,5]
print("기댓값: [1,2,3,5,6]")
print(quick_sort(lst1))
print("------------------------")

# test2. pivot값이 가장 큰 수 일때
lst2 = [2,3,6,1,5]
print("기댓값: [1,2,3,5,6]")
print(quick_sort(lst2))
print("------------------------")

# test3. pivot값이 중간 수 일때
lst3 = [2,6,3,1,5]
print("기댓값: [1,2,3,5,6]")
print(quick_sort(lst3))
print("------------------------")

# test4. lst의 길이가 짝수 일때
lst4 = [2,6,3,4,1,5]
print("기댓값: [1,2,3,4,5,6]")
print(quick_sort(lst4))
print("------------------------")

# test5. lst의 길이가 1 일때
lst5 = [2]
print("기댓값: [2]")
print(quick_sort(lst5))
print("------------------------")

# test6. lst의 길이가 짝수 일때
lst6 = []
print("기댓값: []")
print(quick_sort(lst6))
print("------------------------")
