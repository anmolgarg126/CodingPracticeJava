package main.java.common;

public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }

    public String print(LinkedListNode<T> head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.data);
            sb.append(",");
            head = head.next;
        }
        String substring = sb.substring(0, sb.length() - 1);
        return substring + "]";
    }
}