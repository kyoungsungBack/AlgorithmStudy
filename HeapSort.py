def heap_sort(s):
    return s

s = [1, 4, 2, 0, 9]
heap_sort(s)
# 왼쪽 자식노드index = 부모노드index*2 + 1
# 오른쪽 자식노드index = 부모노드index*2 + 2

# test1. 최대힙 구조를 만들 때 자식이 부모보다 큰 경우
lst1 = [1, 4, 2, 0, 9]
print("기댓값: [9, 4, 2, 0, 1]")
print(heap_sort(lst1))
print("------------------------")

# test2. 리스트가 한 개일 경우
lst2 = [1]
print("기댓값: [1]")
print(heap_sort(lst2))
print("------------------------")

# test3. 리스트가 비었을 경우
lst3 = []
print("기댓값: []")
print(heap_sort(lst3))
print("------------------------")

# test4. 정렬할 때 가장 큰 수가 두 개일 경우
lst4 = [1, 4, 2, 9, 9]
print("기댓값: [9, 9, 2, 1, 4]")
print(heap_sort(lst4))
print("------------------------")
