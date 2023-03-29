import java.io.*;
import java.util.Scanner;

/**
 * This class manages all functions relate to the product
 */
public class OperationToProduct {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Reading all products from the file and insert them to the list at tail.
     *
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */
    public static void getAllItemsFromFile(String fileName, MyList list) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split("  \\|");
                String code = txt[0];
                String title = txt[1];
                int quantity = Integer.parseInt(txt[2]);
                double price = Double.parseDouble(txt[3]);
                list.insertAtTail(new Product(code,title,quantity,price));
            }
            br.close();
            fr.close();
        }catch (Exception e) {
            System.out.println("Exception!");
        }
    }


    /**
     * Reading all products from the file and insert them to the stack.
     *
     * @param fileName The file name of the file
     * @param stack     The Stack contains all products that read from file
     */
    public static void getAllItemsFromFile(String fileName, MyStack stack) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null){
                    break;
                }
                String[] txt = line.split("  \\|");
                String code = txt[0];
                String title = txt[1];
                int quantity = Integer.parseInt(txt[2]);
                double price = Double.parseDouble(txt[3]);
                stack.push(new Product(code,title,quantity,price));
            }
            br.close();
            fr.close();
        }catch (Exception e) {
            System.out.println("Exception!");
        }
    }


    /**
     * Reading all products from the file and insert them to the queue.
     *
     * @param fileName The file name of the file
     * @param queue     The Queue contains all products that read from file
     */
    public static void getAllItemsFromFile(String fileName, MyQueue queue) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null){
                    break;
                }
                String[] txt = line.split("  \\|");
                String code = txt[0];
                String title = txt[1];
                int quantity = Integer.parseInt(txt[2]);
                double price = Double.parseDouble(txt[3]);
                queue.enqueue(new Product(code, title, quantity, price));
            }
            br.close();
            fr.close();
        }catch (Exception e) {
            System.out.println("Exception!");
        }
    }

    /**
     * Adding a product to the list, info of the product input from keyboard.
     *
     * @param list The Linked list
     */
    public static void addLast(MyList list, Product product) {
        list.insertAtTail(product);
    }


    /**
     * Printing all prodcuts of the list to console screen
     *
     * @param list
     */
    public static void displayAll(MyList list) {
        System.out.println(list);
    }


    /**
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */
    public static void writeAllItemsToFile(String fileName, MyList list) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            Node current = list.getHead();
            while (current != null) {
                bw.write(current.toString());
                bw.newLine();
                current = current.getNextNode();
            }
            bw.close();
            fw.close();


        }catch (Exception e) {
            System.out.println("Exception!");
        }
    }


    /**
     * Searching product by ID input from keyboard.
     *
     * @param list
     */
    public static void searchByCode(MyList list, PrintStream file) {
        sc.nextLine();
        System.out.print("Input the ID to search: ");
        String inputID = sc.nextLine();
        file.append(inputID).append("\n");
        System.out.println("Result: ");
        Node current = list.getHead();
        while (current != null){
            if (inputID.equalsIgnoreCase(current.getInfo().getCode())) {
                System.out.println(current);
                System.out.println();
                return;
            }
            current = current.getNextNode();
        }
        if (current == null) {
            System.out.println("Not found!");
        }
        System.out.println();
    }


    /**
     * Deleting first product that has the ID input from keyboard from the list.
     *
     * @param list
     */
    public static void deleteByCode(MyList list, PrintStream file) {
        System.out.print("Input the ID to delete: ");
        String inputID = sc.nextLine();
        file.append(inputID).append("\n");
        Node current = list.getHead();
        Node prev = null;
        //If head node itself holds the code to be deleted
        if (current != null && inputID.equalsIgnoreCase(current.getInfo().getCode())) {
            list.setHead(current.getNextNode());
            System.out.println("Deleted!");
            return;

        }
        //Continue to search for the code to be deleted
        while (current != null && !inputID.equalsIgnoreCase(current.getInfo().getCode())) {
            prev = current;
            current = current.getNextNode();
        }
        // If code was not present in linked list
        if (current == null) {
            System.out.println("ID was not present in linked list");
            System.out.println();
            return;
        }else {
            // Unlink the node from linked list
            prev.setNextNode(current.getNextNode());
            if (current.getNextNode() == null){
                list.setTail(prev);
            }
            System.out.println("Deleted!");
            System.out.println();
            return;
        }
    }


    /**
     * Sorting products in linked list by ID using Quick sort
     *
     * @param list The Linked list
     */
    public static void sortByCode(MyList list, Node start, Node end) {
        if (start == end) {
            return;
        }
        Node pivot_prev = partitionLast(start, end);
        sortByCode(list, start, pivot_prev);
        if (pivot_prev != null && pivot_prev == start){
            sortByCode(list, pivot_prev.getNextNode(), end);
        }else if (pivot_prev != null && pivot_prev.getNextNode() != null) {
            sortByCode(list, pivot_prev.getNextNode().getNextNode(), end);
        }
    }

    /**
     *
     * @param start
     * @param end
     * @return pivot_prev
     */
    public static Node partitionLast(Node start, Node end) {
        if (start == end || start == null || end == null){
            return start;
        }
        Node pivot_prev = start;
        Node current = start;
        Product pivot = end.getInfo();
        while (start != end) {
            if ((start.getInfo().getCode()).compareTo(pivot.getCode()) < 0){
                pivot_prev = current;
                Product temp = current.getInfo();
                current.setInfo(start.getInfo());
                start.setInfo(temp);
                current = current.getNextNode();
            }
            start = start.getNextNode();
        }
        Product temp = current.getInfo();
        current.setInfo(pivot);
        end.setInfo(temp);

        return pivot_prev;
    }


    /**
     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010
     * @param x Input decimal number
     * @return a integer numbers
     */
    public static void convertToBinary(int x) {
        int[] binary = new int[40];
        int index = 0;
        while (x > 0) {
            binary[index++] = x % 2;
            x = x / 2;
        }
        for (int i = index - 1; i >= 0 ; i--) {
            System.out.print(binary[i] + " ");
        }
        System.out.println();
    }
}
