def selection_sort(s):
    for i in range(len(s)):
        for j in range(i+1,): #i+1 ~ 끝
            if s[i] < s[j]: # 여기서 작은 수를 찾으면 앞으로 보내주는건데 큰 수일 때 찾아서 바꿔줌 하지만 정렬은 됨
                s[i], s[j] = s[j], s[i]
    return print(s)

# def selection_sort(s):
#     for i in range(len(s)):
#         for j in range(len(s)):
#             if s[i] < s[j]:
#                 s[i], s[j] = s[j], s[i]
#
#     return print(s)

s = [1, 4, 2, 0, 9, 5, 3]
selection_sort(s)