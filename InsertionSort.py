def insertion_sort(lst):
    for i in range(len(lst)):
        for j in range(i):
            if lst[j] > lst[i]:
                lst.insert(j, lst.pop(i))
    return print(lst)

lst = [1, 4, 2, 0, 9, 5, 3]
insertion_sort(lst)