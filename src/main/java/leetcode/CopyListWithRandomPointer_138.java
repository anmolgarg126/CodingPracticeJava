package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
Question: 138. Copy List with Random Pointer
Link: https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer_138 {
    public static void main(String[] args) {
        var obj = new CopyListWithRandomPointer_138();
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node head = new Node(7);
        Node second = new Node(13);
        Node third = new Node(11);
        Node fourth = new Node(10);
        Node fifth = new Node(1);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        head.random = null;
        second.random = head;
        third.random = fourth;
        fourth.random = second;
        fifth.random = head;
        System.out.println(obj.copyRandomList(head));
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val && Objects.equals(next, node.next) && Objects.equals(random, node.random);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next, random);
        }
    }
}
