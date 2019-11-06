public class MyList {
    private int size;
    private Node head;

    public MyList() {
        this.size = 0;
        this.head = null;
    }

    public MyList(int[] arr) {
        this.size = arr.length;
        this.head = arr == null || arr.length = 0 ? null : new Node(arr[0]);

        Node node = this.head;
        for (int i = 1; i < arr.length; i++) {
            node.next = new Node(arr[i]);
            node = node.next;
        }
    }

    public int size() {
        return this.size;
    }

    public int get(int index) {
        Node temp = this.head;
        while (index-->0) {
            temp = temp.next;
        }
        return temp.value;
    }

    public void set(int index, int value) {
        Node temp = this.head;
        while (index-->0) {
            temp=temp.next;
        }
        temp.value = value;
    }

    public int indexOf(int value) {
        Node temp = this.head;
        int index = 0;
        while (temp != null) {
            if (temp.value == value) {
                return index;
            } else {
                temp = temp.next;
                index++;
            }
        }
        return -1;
    }

    public void append(int value) {
        Node node = new Node(value);

        if (this.head == null) {
            this.head = node;
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        this.size++;
    }

    public void insert(int index, int value) {
        Node node = new Node(value);

        if (index <= 0 || this.head == null) {
            node.next = this.head;
            this.head = node;
        } else if (index >= this.size) {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        } else {
            Node temp = this.head;
            while (index-->1) {
                temp = temp.next;
            }
            node.next = temp.next;

            temp.next = node;
        }
        this.size++;
    }

    public int pop() {
        Node tail = this.head;
        Node prev = null;

        if (this.head.next == null) {
            this.head = null;
            return tail.value;
        }

        while (tail.next != null) {
            prev = tail;
            tail = tail.next;
        }

        prev.next = null;
        this.size--;

        return tail.value;
    }

    public void clear() {
        this.size = 0;
        this.head = null;
    }

    public boolean equals(MyList other) {
        Node list0 = this.head, list1 = other.head;

        if (this.size != other.size) {
            return false;
        }

        for (int i = 0, len = this.size; i < len; i++) {
            if (list0.value != list1.value) {
                return false;
            }
            list0 = list0.next;
            list1 = list1.next;
        }

        return true;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        Node temp = this.head;
        for (int i = 0; i < this.size; i++) {
            str.append(temp.value + " ");
            temp = temp.next;
        }

        return this.isNull() ? null : str.toString();
    }

    public void display(String prompt) {
        System.out.println(prompt + this);
    }

    public boolean isNull() {
        if (this.head == null) {
            return true;
        }
        return false;
    }
}