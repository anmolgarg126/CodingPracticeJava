package main.java.leetcode;

/*
Question: 622. Design Circular Queue
Link: https://leetcode.com/problems/design-circular-queue/
 */
public class DesignCircularQueue_622 {
    public static void main(String[] args) {
        var obj1 = new DesignCircularQueue_622();
        MyCircularQueue obj = obj1.new MyCircularQueue(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
    }


    class MyCircularQueue {

        final int[] a;
        int front = 0, rear = -1, len = 0;

        public MyCircularQueue(int k) {
            a = new int[k];
        }

        public boolean enQueue(int value) {
            if (!isFull()) {
                rear = (rear + 1) % a.length;
                a[rear] = value;
                len++;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            if (!isEmpty()) {
                front = (front + 1) % a.length;
                len--;
                return true;
            }
            return false;
        }

        public int Front() {
            return isEmpty() ? -1 : a[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : a[rear];
        }

        public boolean isEmpty() {
            return len == 0;
        }

        public boolean isFull() {
            return len == a.length;
        }
    }
}
