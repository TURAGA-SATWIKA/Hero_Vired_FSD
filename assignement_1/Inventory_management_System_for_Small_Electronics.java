import java.util.*;

public class Inventory_management_System_for_Small_Electronics {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Number of Products: ");
        int n = sc.nextInt();
        HashMap<Integer, Product> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Product obj = new Product();
            int iden = mp.size() + 1;
            obj.id = iden;
            System.out.print("Enter Name of Product: ");
            obj.name = sc.next();
            System.out.print("Enter Specification of Product: ");
            obj.spec = sc.next();
            System.out.print("Enter Cost of Product: ");
            obj.cost = sc.nextInt();
            System.out.print("Enter count of Product: ");
            obj.count = sc.nextInt();
            mp.put(iden, obj);
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
                    System.out.println("ID\tName\tSpeci\tCost\tCount");
                    for (Map.Entry<Integer, Product> iter : mp.entrySet()) {
                        Product p = iter.getValue();
                        p.productList();
                    }
                    break;
                case 2:
                    System.out.print("Enter Product ID to show Count : ");
                    int iden = sc.nextInt();
                    if (mp.containsKey(iden) == false) {
                        System.out.println("No Such Product Exists");
                    } else {
                        Product p = mp.get(iden);
                        p.productCount();
                    }
                    break;
                case 3:
                    System.out.print("Enter Product ID for Details : ");
                    iden = sc.nextInt();
                    if (mp.containsKey(iden) == false) {
                        System.out.println("No Such Product Exists");
                    } else {
                        Product p = mp.get(iden);
                        p.viewProductDetails();
                    }
                    break;
                case 4:
                    System.out.print("Enter Product ID Edit : ");
                    iden = sc.nextInt();
                    if (mp.containsKey(iden) == false) {
                        System.out.println("No Such Product Exists");
                    } else {
                        Product p = mp.get(iden);
                        p.editProductDetails();
                    }
                    break;
                case 5:
                    System.out.println("1. Add a Product");
                    System.out.println("2. Delete a Product");
                    int opt = sc.nextInt();
                    if (opt == 1) {
                        Product obj = new Product();
                        int id = mp.size() + 1;
                        obj.id = id;
                        System.out.print("Enter Name of Product: ");
                        obj.name = sc.next();
                        System.out.print("Enter Specification of Product: ");
                        obj.spec = sc.next();
                        System.out.print("Enter Cost of Product: ");
                        obj.cost = sc.nextInt();
                        System.out.print("Enter count of Product: ");
                        obj.count = sc.nextInt();
                        mp.put(id, obj);
                    } else if (opt == 2) {
                        iden = sc.nextInt();
                        if (mp.containsKey(iden) == false) {
                            System.out.println("No Such Product Exists");
                        } else {
                            mp.remove(iden);
                        }
                    }
                    break;
            }
        }
        sc.close();
    }
}

class Product {
    static Scanner sc = new Scanner(System.in);
    public String name, spec;
    public int cost, count, id;

    public void productList() {
        System.out.println(id + "\t" + name + "\t" + spec + "\t" + cost + "\t" + count);
    }

    public void viewProductDetails() {
        System.out.println("The Details of the Product is: ");
        System.out.println("Product ID : " + id);
        System.out.println("Product Name : " + name);
        System.out.println("Product Specification : " + spec);
        System.out.println("Product Cost : " + cost);
        System.out.println("Product Count : " + count);
    }

    public void editProductDetails() {
        System.out.println("1. Edit Product Name");
        System.out.println("2. Edit Product Specification");
        System.out.println("3. Edit Product Cost");
        System.out.println("4. Edit Product Count");
        System.out.print("Enter Option to Edit Product: ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.print("Enter Product Name: ");
                name = sc.next();
                break;
            case 2:
                System.out.print("Enter Product Specification: ");
                spec = sc.next();
                break;
            case 3:
                System.out.print("Enter Product Cost: ");
                cost = sc.nextInt();
                break;
            case 4:
                System.out.print("Enter Product Count: ");
                count = sc.nextInt();
                break;
        }
    }

    public void productCount() {
        System.out.println("The Quantities Available for the Product " + name + " is " + count);
    }
}
