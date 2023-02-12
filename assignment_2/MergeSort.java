import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class MergeSort {

    Node head;

    void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = sortList(head);
        Node right = sortList(nextOfMiddle);
        Node sortedList = sortedMerge(left, right);
        return sortedList;
    }

    Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node sortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            MergeSort llist1 = new MergeSort();
            MergeSort llist2 = new MergeSort();
            for (int i = 1; i <= n; i++) {
                int a = sc.nextInt();
                llist1.addToTheLast(new Node(a));
            }
            for (int i = 1; i <= m; i++) {
                int b = sc.nextInt();
                llist2.addToTheLast(new Node(b));
            }
            MergeSort llist3 = new MergeSort();
            llist3.head = llist3.sortedMerge(llist1.head, llist2.head);
            llist3.head = llist3.sortList(llist3.head);
            llist3.printList();
            t--;
        }
    }
}