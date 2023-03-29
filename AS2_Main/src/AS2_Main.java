import java.io.*;
import java.util.Scanner;

public class AS2_Main {
    public static MyList list;
    public static Scanner sc = new Scanner(System.in);
    public static int inputChoice;
    public static void showMenu() {1
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");

    }
    public static void main(String[] args) throws Exception {
        PrintStream file = new PrintStream("Console_output.txt");
        CustomPrintStream custom = new CustomPrintStream(System.out,file);
        System.setOut(custom);
        do {
            showMenu();
            System.out.println();
            System.out.print("Choice: ");
            inputChoice = Integer.parseInt(sc.nextLine());
            file.append(String.valueOf(inputChoice)).append("\n");
            switch (inputChoice) {
                case 1:
                    list = new MyList();
                    OperationToProduct.getAllItemsFromFile("Data.txt",list);
                    System.out.println(list);
                    break;
                case 2:
                    System.out.print("Input new ID: ");
                    String inputID = "";
                    boolean passID = true;
                    while (passID) {
                        inputID = sc.nextLine();
                        Node cur = list.getHead();
                        while (cur != null) {
                            if (cur.getInfo().getCode().equalsIgnoreCase(inputID)) {
                                System.out.print("Existed ID, please enter again ... ");
                                break;
                            }
                            cur = cur.getNextNode();
                            if(cur == null){
                                passID = false;
                            }
                        }
                    }
                    file.append(inputID).append("\n");
                    System.out.print("Input Product's Name: ");
                    String inputName = sc.nextLine();
                    file.append(inputName).append("\n");
                    System.out.print("Input Product's quantity: ");
                    int inputQuantity = sc.nextInt();
                    file.append(String.valueOf(inputQuantity)).append("\n");
                    System.out.print("Input Product's price: ");
                    double inputPrice = sc.nextDouble();
                    sc.nextLine();
                    file.append(String.valueOf(inputPrice)).append("\n");
                    OperationToProduct.addLast(list, new Product(inputID, inputName, inputQuantity, inputPrice));
                    break;
                case 3:
                    OperationToProduct.displayAll(list);
                    break;
                case 4:
                    OperationToProduct.writeAllItemsToFile("Data.txt", list);
                    System.out.println("Successfully!");
                    System.out.println();
                    break;
                case 5:
                    OperationToProduct.searchByCode(list, file);
                    break;
                case 6:
                    OperationToProduct.deleteByCode(list, file);
                    break;
                case 7:
                    OperationToProduct.sortByCode(list, list.getHead(), list.getTail());
                    System.out.println("Successfully!");
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Quantity = " + list.getHead().getInfo().getQuantity());
                    System.out.println("Convert Quantity to Binary: ");
                    OperationToProduct.convertToBinary(list.getHead().getInfo().getQuantity());
                    System.out.println();
                    break;
                case 9:
                    MyStack stack = new MyStack();
                    OperationToProduct.getAllItemsFromFile("Data.txt", stack);
                    stack.display();
                    break;
                case 10:
                    MyQueue queue = new MyQueue();
                    OperationToProduct.getAllItemsFromFile("Data.txt", queue);
                    queue.display();
                    break;
            }
        }while (inputChoice != 0);
    }
}



