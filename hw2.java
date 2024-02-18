import java.util.Random;

public class hw2 {
    private static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    public class DoublyLinkedList {
        // 定义双向链表节点
        public Node head;
        public Node trailer;

        public DoublyLinkedList(int l,int r){
            head = new Node(l);
            trailer = new Node(r);
        }


        public static Node findMiddle(Node header, Node trailer) {

            Node slow = header.next;
            Node fast = header.next;

            while (fast != trailer && fast.next != trailer) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

    }

    public class CircularlyLinkedList<E> {
        // 嵌套的节点类，与 SinglyLinkedList 类的节点类相同
        private static class Node<E> {
            private E element;
            private Node<E> next;

            public Node(E element, Node<E> next) {
                this.element = element;
                this.next = next;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setNext(Node<E> next) {
                this.next = next;
            }
        }

        private Node<E> tail = null; // 尾部节点，不存储头部节点
        private int size = 0; // 链表中的节点数

        public CircularlyLinkedList() { } // 构造一个初始为空的链表

        // 访问方法
        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public E first() {
            // 返回（但不移除）第一个元素
            if (isEmpty()) return null;
            return tail.getNext().getElement(); // 头部在尾部的后面
        }

        public E last() {
            // 返回（但不移除）最后一个元素
            if (isEmpty()) return null;
            return tail.getElement();
        }

        // 更新方法
        public void rotate() {
            // 将第一个元素旋转到链表末尾
            if (tail != null) // 如果为空，不做任何操作
                tail = tail.getNext(); // 旧头部变为新尾部
        }

        public void addFirst(E e) {
            // 在链表前端添加元素
            if (size == 0) {
                tail = new Node<>(e, null);
                tail.setNext(tail); // 形成循环链接到自身
            } else {
                Node<E> newest = new Node<>(e, tail.getNext());
                tail.setNext(newest);
            }
            size++;
        }

        public void addLast(E e) {
            // 在链表末尾添加元素
            addFirst(e); // 在链表前端插入新元素
            tail = tail.getNext(); // 现在新元素变为尾部
        }

        public E removeFirst() {
            // 移除并返回第一个元素
            if (isEmpty()) return null; // 没有要移除的内容
            Node<E> head = tail.getNext();
            if (head == tail) tail = null; // 必须是最后一个节点
            else tail.setNext(head.getNext()); // 从链表中移除"头部"
            size--;
            return head.getElement();
        }

        public boolean equals(Object obj) {
            // 检查是否是CircularlyLinkedList类型的对象
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            // 将对象转换为CircularlyLinkedList
            CircularlyLinkedList<?> otherList = (CircularlyLinkedList<?>) obj;

            // 检查两个链表的大小是否相等
            if (size != otherList.size) return false;

            // 检查链表中对应位置的元素是否相等
            Node<E> currentThis = tail.getNext();
            Node<E> currentOther = (Node<E>) otherList.tail.getNext();

            for (int i = 0; i < size; i++) {
                if (!currentThis.getElement().equals(currentOther.getElement())) {
                    return false;
                }
                currentThis = currentThis.getNext();
                currentOther = currentOther.getNext();
            }

            return true;
        }


        public CircularlyLinkedList<E> clone() {
            try {
                // 调用父类的 clone 方法创建一个新的 CircularlyLinkedList 对象
                CircularlyLinkedList<E> clonedList = (CircularlyLinkedList<E>) super.clone();

                if (size > 0) {
                    // 克隆头部节点
                    clonedList.tail = new Node<>(tail.getElement(), null);
                    clonedList.tail.setNext(clonedList.tail);

                    // 克隆链表中的其他节点
                    Node<E> current = tail.getNext();
                    Node<E> clonedCurrent = clonedList.tail.getNext();

                    while (current != tail) {
                        Node<E> newNode = new Node<>(current.getElement(), null);
                        clonedCurrent.setNext(newNode);
                        clonedCurrent = newNode;

                        current = current.getNext();
                    }

                    // 将克隆链表的尾部指向新添加的尾部节点
                    clonedList.tail = clonedCurrent;
                    clonedList.tail.setNext(clonedList.tail);
                }

                return clonedList;
            } catch (CloneNotSupportedException e) {
                // 捕获异常并处理
                return null;
            }
        }



        public static String encrypt(String message, int shift) {
            StringBuilder encryptedMessage = new StringBuilder();

            for (char ch : message.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    // 大写字母的加密
                    char encryptedChar = (char) ((ch - 'A' + shift) % 26 + 'A');
                    encryptedMessage.append(encryptedChar);
                } else if (Character.isLowerCase(ch)) {
                    // 小写字母的加密
                    char encryptedChar = (char) ((ch - 'a' + shift) % 26 + 'a');
                    encryptedMessage.append(encryptedChar);
                } else {
                    // 非字母字符保持不变
                    encryptedMessage.append(ch);
                }
            }

            return encryptedMessage.toString();
        }

        public static String decrypt(String encryptedMessage, int shift) {
            // 解密即加密的逆过程，将移位值取反
            return encrypt(encryptedMessage, -shift);
        }

    }

    public static void shuffle(int[] A) {
        Random rand = new Random();

        for (int i = A.length - 1; i > 0; i--) {
            // 生成一个介于 0 和 i（含）之间的随机索引
            int j = rand.nextInt(i + 1);

            // 将当前元素与随机选择的元素交换
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    public class DoublyLinkedListConcatenation {
        // 定义双向链表节点
        public static class Node {

            Node prev;
            int val;
            Node next;

        }

        // 定义带有头尾哨兵节点的双向链表类
        private static class DoublyLinkedList {
            // 头部哨兵节点
            Node header;

            // 尾部哨兵节点
            Node trailer;

            public DoublyLinkedList(Node header, Node trailer) {
                this.header=header;
                this.trailer=trailer;
            }


            // 连接两个双向链表的方法
            public static DoublyLinkedList concatenate(DoublyLinkedList L, DoublyLinkedList M) {
                // 如果其中一个链表为空，返回另一个链表
                if (L==null) {
                    return M;
                } else if (M==null) {
                    return L;
                }

                // 获取 L 的尾部哨兵节点 L_trailer 和 M 的头部哨兵节点 M_header
                Node L_trailer = L.trailer;
                Node M_header = M.header;

                // 将 L_trailer 的 next 指向 M_header.next，即将链表 L 的尾部连接到链表 M 的头部
                L_trailer.next = M_header.next;

                // 如果 M 不为空，则将 M 的尾部哨兵节点 M_trailer 的 next 指向 L_trailer.next
                if (M!=null) {
                    Node M_trailer = M.trailer;
                    M_trailer.next = L_trailer.next;
                }

                // 返回合并后的链表
                return new DoublyLinkedList(L.header, M.trailer);
            }

            // 判断链表是否为空的方法
        }
    }



}
