import java.util.Scanner;

public class lab3 {
    // str array to int array
    public static int[] toIntArr(String[] strArr) {
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    public static void main(String args[]) {
        // Create MyList
        MyList myList = args.length == 0 ? new MyList() : new MyList(toIntArr(args));

        Scanner sc = new Scanner(System.in);
        int command = -1;
        while (command != 11) {
            command = sc.nextInt();
            int i, v;
            switch(command) {
                // size
                case 1:
                    System.out.println("List size is " + myList.size());
                    break;

                // get
                case 2:
                    i = sc.nextInt();
                    System.out.printf("Value at index %d is %d\n", i, myList.get(i));
                    break;

                // set
                case 3:
                    i = sc.nextInt();
                    v = sc.nextInt();
                    System.out.printf("Value %d at index %d is set to %d\n", myList.get(i), i, v);
                    myList.display("Previous: ");
                    myList.set(i, v);
                    myList.display("Updated : ");
                    break;

                // indexOf
                case 4:
                    v = sc.nextInt();
                    System.out.printf("Index of value %d is %d\n", v, myList.indexOf(v));
                    break;

                // append
                case 5:
                    v = sc.nextInt();
                    myList.display("Previous: ");
                    myList.append(v);
                    myList.display("Updated : ");
                    break;

                // insert
                case 6:
                    i = sc.nextInt();
                    v = sc.nextInt();
                    System.out.printf("Inserted %d at index %d\n", v, i);
                    myList.display("Previous: ");
                    myList.insert(i, v);
                    myList.display("Updated : ");
                    break;

                // pop
                case 7:
                    myList.display("Previous: ");
                    v = myList.pop();
                    myList.display("Updated : ");
                    System.out.printf("Pop: %d\n", v);
                    break;

                // clear
                case 8:
                    myList.display("Previous: ");
                    myList.clear();
                    myList.display("Updated : ");
                    break;

                // equals
                case 9:
                    v = sc.nextInt();
                    int[] intArr = v <= 0 ? null : new int[v];
                    for (int j = 0; j < v; j++) {
                        intArr[j] = sc.nextInt();
                    }
                    String str = sc.nextLine();
                    MyList other = v == 0 ? new MyList() : new MyList(intArr);
                    myList.display("mylist: ");
                    other.display("other : ");
                    System.out.println(myList.equals(other));
                    break;

                // print
                case 0:
                    myList.display("Current: ");

                // quit
                case 11:
                    break;

                default:
                    System.out.println("unknown command.");
            }
        }
    }
}