# def bubble_sort(s):
#     for i in range(len(s)):
#         for j in range(len(s)-i-1):
#             if s[j] > s[j+1]:
#                 s[j], s[j+1] = s[j+1], s[j]
#     return print(s)



def bubble_sort(s):
    for i in range(len(s)):
        for j in range(len(s)):
            if s[i] < s[j]:
                s.append(s.pop(j))
    return print(s)

s = [1, 4, 2, 0, 9, 5, 3]
bubble_sort(s)