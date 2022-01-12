# CS03 데이터구조

## 미션 1
- [x] 영상 데이터 구조를 13개 생성한다.

- [x] 각 영상 데이터에는 고유한 id가 할당된다.

- [x] 데이터 구조를 생성하고 저장하지 않고 출력만 한다.

- [x] 제목은 "제목1" 부터 시작해서 "제목13" 까지로 할당한다.

- [x] 재생 시간은 랜덤하게 1초에서 15초 내로 지정한다.

- [ ] 다음 영상 정보는 우선 지정하지 않는다.

- [x] 13개 모두 생성하고 나면, 생성한 영상 순서대로 제목(id):재생시간 형식으로 출력한다.

- [x] 생성한 데이터를 적절한 콜랙션에 보관한다 (이 부분을 링크드 리스트로 구현하지 않아도 된다)

## 미션 2
- [x] 앞 단계에서 생성한 데이터를 선택해서 편집하려는 순서대로 링크드 리스트로 연결하는 방식이다.

- [x] 다음과 같이 메뉴 동작에 맞춰서 동작한다.

- [x] 메뉴는 명령어 + 공백 + 영상id 또는 명령어 + 공백 + 영상id + 공백 + 위치형식을 갖는다.

- [x] add abab를 입력하면 맨 뒤에 abab 영상을 추가한다.

- [x] insert cafe 0를 입력하면 맨 앞에 0번째에 cafe 영상을 추가한다.

- [x] 만약 맨 뒤에 순서값이 현재 링크드 리스트에 개수보다 같거나 크면 맨 뒤에 입력한다.

- [x] add 나 insert 시에 이미 만들어진 영상id가 없으면 추가하지 않는다.

- [x] delete abcd를 입력하면 링크드 리스트 시작 위치부터 abcd를 찾아서 삭제한다.
- [x] 만약 뒤에 다른 영상 데이터 정보가 있으면 이전 정보를 연결한다.
- [x] [cafe]---[abcd]---[bdfa] 에서 [abcd]를 삭제하면 [cafe]---[bdfa] 상태가 되어야 한다.

- [x] render를 입력하면 링크드 리스트를 전체를 탐색하면서 재생 시간을 더한다.

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

### Single Linked List 이므로 마지막 노드를 가리키는 last 는 없앴다

## addLast 메소드
```java
    void addLast(Node node) {
        temp = head;
        if (head == null) {
            head = node;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
```

## insert 메소드
```java
   void insert(Node node, int index) {
        temp = head;
        // 인덱스 0 입력하거나, List가 비어있을 경우
        if (index == 0 || temp == null) {
            node.next = temp;
            head = node;
        } else {
            for (int i = 1; i < index; i++) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }
```

## delete 메소드
```java
    void delete(Node node) {
        temp = head;
        //delete 할 항목이 head에 있을 때
        if (temp.videoNode == node.videoNode) {
            head = temp.next;
        } else {
            while (temp.next != null) {
                if (temp.next.videoNode == node.videoNode) {
                    temp.next = temp.next.next;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
    }
```

## printTimeLine 메소드
```java 
    void printTimeLine() {
        temp = head;
        System.out.print("|---");
        while (temp != null) {
            System.out.printf("[%s, %d" + "sec]", temp.videoNode.getId(),
                temp.videoNode.getLength());
            System.out.print("---");
            temp = temp.next;
        }
        System.out.println("[end]");
    }
```

## render 메소드
```java
    void render() {
        int count = 0;
        int length = 0;
        temp = head;
        while (temp != null) {
            count++;
            length += temp.videoNode.getLength();
            temp = temp.next;
        }
        System.out.println("영상클립 :" + count + "개");
        System.out.println("전체길이 :" + length + "sec");
    }
```