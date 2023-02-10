
// package Assignment;
import java.util.*;

public class Map_the_inventory {
    static Scanner sc = new Scanner(System.in);

    public static void viewPro(HashMap<Integer, ArrayList<Object>> products) {
        System.out.print("Enter Product ID to get Product details: ");
        int id = sc.nextInt();
        if (products.containsKey(id) == false) {
            System.out.println("No Product");
            return;
        }
        ArrayList<Object> temp = products.get((int) id);
        System.out.println("Please enter Product ID : " + temp.get(0));
        System.out.println("Please enter Product Name : " + temp.get(1));
        System.out.println("Please enter Product Specification : " + temp.get(2));
        System.out.println("Please enter Product Cost : " + temp.get(3));
        System.out.println("Please enter Product Count : " + temp.get(4));
    }

    public static void update_det(HashMap<Integer, ArrayList<Object>> products) {
        System.out.println("Enter 1 to Add Product");
        System.out.println("Enter 2 to Delete a Product");
        int option = sc.nextInt();
        if (option == 1) {
            System.out.print("Enter Name of Product: ");
            String Name = sc.next();
            System.out.print("Enter Specification of Product: ");
            String spec = sc.next();
            System.out.print("Enter Cost of Product: ");
            int cost = sc.nextInt();
            System.out.print("Enter count of Product: ");
            int count = sc.nextInt();
            ArrayList<Object> temp = new ArrayList<>();
            int id = products.size() + 1;
            temp.add(id);
            temp.add(Name);
            temp.add(spec);
            temp.add(cost);
            temp.add(count);
            products.put(id, temp);
        } else if (option == 2) {
            System.out.println("Enter Product ID to remove: ");
            int id = sc.nextInt();
            if (products.containsKey(id) == false) {
                System.out.println("No Such Product Exist");
                return;
            }
            products.remove(id);
        } else {
            System.out.println("Invalid Option");
        }
    }

    public static void show_count(HashMap<Integer, ArrayList<Object>> products) {
        System.out.println("Enter Product ID to show Count: ");
        int id = sc.nextInt();
        if (products.containsKey(id) == false) {
            System.out.println("No Such Product Exist please enter correct details or check again");
            return;
        }
        ArrayList<Object> temp = products.get(id);
        System.out.println("The Available Quantities  for the Product " + temp.get(1) + " is " + temp.get(4));
    }

    public static void editPro(HashMap<Integer, ArrayList<Object>> products) {
        System.out.println("Enter Product ID to edit: ");
        int id = sc.nextInt();
        ArrayList<Object> temp_t = products.get(id);
        products.remove(id);
        System.out.println("1. Edit Product Name");
        System.out.println("2. Edit Product Specification");
        System.out.println("3. Edit Product Cost");
        System.out.println("4. Edit Product Count");
        System.out.print("Enter Option to Edit Product: ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.print("Enter Product Name: ");
                String Name = sc.next();
                temp_t.set(1, Name);
                break;
            case 2:
                System.out.print("Enter Product Specification: ");
                String spec = sc.next();
                temp_t.set(2, spec);
                break;
            case 3:
                System.out.print("Enter Product Cost: ");
                int cost = sc.nextInt();
                temp_t.set(3, cost);
                break;
            case 4:
                System.out.print("Enter Product Count: ");
                int count = sc.nextInt();
                temp_t.set(4, count);
                break;
        }
        products.put(id, temp_t);
    }

    public static void main(String[] args) {
        System.out.println("Enter Number of Products: ");
        int n = sc.nextInt();
        HashMap<Integer, ArrayList<Object>> products = new HashMap<>();
        int id = 1;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Name of Product: ");
            String name = sc.next();
            System.out.print("Enter Specification of Product: ");
            String spec = sc.next();
            System.out.print("Enter Cost of Product: ");
            String cost = sc.next();
            System.out.print("Enter count of Product: ");
            String count = sc.next();
            ArrayList<Object> temp = new ArrayList<>();
            temp.add(id);
            temp.add(name);
            temp.add(spec);
            temp.add(cost);
            temp.add(count);
            products.put(id, temp);
            id++;
        }
        int option = 0;
        while (option < 6) {
            System.out.println("1. List Products");
            System.out.println("2. Product Count");
            System.out.println("3. View Product Details");
            System.out.println("4. Edit Product");
            System.out.println("5. Update Product");
            System.out.println("6. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    productList(products);
                    break;
                case 2:
                    show_count(products);
                    break;
                case 3:
                    viewPro(products);
                    break;
                case 4:
                    editPro(products);
                    break;
                case 5:
                    update_det(products);
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
        sc.close();
    }

    public static void productList(HashMap<Integer, ArrayList<Object>> products) {
        System.out.println("ID\tName\tSpeci\tCost\tCount");
        for (Map.Entry<Integer, ArrayList<Object>> emm : products.entrySet()) {
            ArrayList<Object> temp_get = emm.getValue();
            for (int i = 0; i < temp_get.size(); i++) {
                System.out.print(temp_get.get(i) + "\t");
            }
            System.out.println();
        }
    }
}