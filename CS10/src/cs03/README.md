# CS03 데이터구조

---

#### Node Class 객체 3개(head, temp, list)를 이용해 LinkedList 구현
```java
void add(Video clip) {

        Node node = new Node(clip);
        if (head == null) {
            head = node;
        }
        if (temp != null) {
            temp.link = node;
        }
        temp = node;
    }
```
다음과 같은 표를 만들면서 코드를 작성하니 이해하기 쉬웠다.

temp|data|head|link
:--:|:--:|:--:|:--:
null|1|1|null|
1|2|"|2|
2|3|"|3|
⁞|⁞|⁞|⁞
12|13|"|13
13| | | null


#### `PrintTimeLine()` 실행 시 `temp`가 `null`이 되는 것을 `last`를 추가하여 해결하였다.  
`addLast()` 할 때 `temp = last`를 통해 temp 복구

```java
 void addLast(Node node) {
        temp = last;
        if (head == null) {
            head = node;
        }
        if (temp != null) {
            temp.linkNode = node;
        }
        temp = node;
        last = node;
    }
```

메소드|node|temp(=last)|head|temp.linkNode|temp|last
-|:-:|:-:|:-:|:-:|:-:|:-:
addLast|1|0|1|0|1|1
printTimeLine|||||1->0|
addLast|2|1|1|2|2|2
printTimeLine|||||2->1->0||

*여기서 0은 null
