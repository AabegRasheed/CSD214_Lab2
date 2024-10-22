package Lab2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private final ArrayList<SaleableItem> saleableItems = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main mainApp = new Main();
        mainApp.start();
    }

    public void start() {
        boolean running = true;

        while (running) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewItems();
                case 2 -> addItem();
                case 3 -> editItem();
                case 4 -> deleteItem();
                case 5 -> sellItem();
                case 6 -> showTotalSales();
                case 7 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Bye.");
    }

    private void showTotalSales() {
        CashTill cashTill = CashTill.getInstance();
        System.out.println("Total sales so far: $" + cashTill.showTotal());
    }

    private void showMainMenu() {
        System.out.println("------Main Menu------");
        System.out.println("1. View Items");
        System.out.println("2. Add Item");
        System.out.println("3. Edit Item");
        System.out.println("4. Delete Item");
        System.out.println("5. Sell Item");
        System.out.println("6. Show Total Sales");
        System.out.println("7. Quit");
        System.out.println("---------------------");
        System.out.print("Enter your choice: ");
    }

    private void viewItems() {
        if (saleableItems.isEmpty()) {
            System.out.println("No items available.");
        } else {
            for (int i = 0; i < saleableItems.size(); i++) {
                System.out.println((i + 1) + ". " + saleableItems.get(i));
            }
        }
    }

    private void addItem() {
        System.out.println("Add Item (1: Book, 2: Ticket, 3: Magazine, 4: Pencil, 5: DiscMag): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        switch (type) {
            case 1 -> addBook();
            case 2 -> addTicket();
            case 3 -> addMagazine();
            case 4 -> addPencil();
            case 5 -> addDiscMag();
            default -> System.out.println("Invalid item type.");
        }
    }

    private void addDiscMag() {
        System.out.println("Enter title: ");
        String title = scanner.nextLine();

        System.out.println("Enter price: ");
        double price = scanner.nextDouble();

        System.out.println("Enter number of copies: ");
        int copies = scanner.nextInt();

        System.out.println("Enter order quantity: ");
        int orderQty = scanner.nextInt();

        System.out.println("Enter 'true' if it includes a disc, otherwise 'false': ");
        boolean hasDisc = scanner.nextBoolean();

        Date currIssue = new Date();

        DiscMag newDiscMag = new DiscMag(title, price, copies, "N/A", hasDisc, orderQty, currIssue);
        saleableItems.add(newDiscMag);
        System.out.println("DiscMag added.");
    }

    private void addPencil() {
        System.out.println("Enter price of the pencil: ");
        double price = scanner.nextDouble();

        Pencil newPencil = new Pencil(price);
        saleableItems.add(newPencil);
        System.out.println("Pencil added.");
    }

    private void addBook() {
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter author: ");
        String author = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter number of copies: ");
        int copies = scanner.nextInt();
        System.out.println("Enter ISBN10: ");
        String ISBN10 = scanner.next();

        Book newBook = new Book(title, price, copies, ISBN10, author);
        saleableItems.add(newBook);
        System.out.println("Book added.");
    }

    private void addTicket() {
        System.out.println("Enter ticket description: ");
        String description = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter number of copies: ");
        int copies = scanner.nextInt();

        Ticket newTicket = new Ticket(description, price, copies, "N/A");
        saleableItems.add(newTicket);
        System.out.println("Ticket added.");
    }

    private void addMagazine() {
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter number of copies: ");
        int copies = scanner.nextInt();
        System.out.println("Enter order quantity: ");
        int orderQty = scanner.nextInt();

        Date currIssue = new Date();

        Magazine newMagazine = new Magazine(title, price, copies, "N/A", orderQty, currIssue);
        saleableItems.add(newMagazine);
        System.out.println("Magazine added.");
    }

    private void editItem() {
        if (saleableItems.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        viewItems();
        System.out.println("Enter the number of the item you want to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < saleableItems.size()) {
            SaleableItem item = saleableItems.get(index);

            if (item instanceof Book) {
                Book book = (Book) item;
                System.out.println("Editing Book: " + book);

                System.out.println("Enter new title: ");
                String newTitle = scanner.nextLine();
                book.setTitle(newTitle);

                System.out.println("Book title updated to: " + book.getTitle());
            } else if (item instanceof Ticket) {
                Ticket ticket = (Ticket) item;
                System.out.println("Editing Ticket: " + ticket);

                System.out.println("Enter new description: ");
                String newDescription = scanner.nextLine();
                ticket.setDescription(newDescription);

                System.out.println("Ticket description updated to: " + ticket.getDescription());
            } else if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                System.out.println("Editing Magazine: " + magazine);

                System.out.println("Enter new title: ");
                String newTitle = scanner.nextLine();
                magazine.setTitle(newTitle);

                System.out.println("Magazine title updated to: " + magazine.getTitle());
            } else if (item instanceof DiscMag) {
                DiscMag discMag = (DiscMag) item;
                System.out.println("Editing DiscMag: " + discMag);

                System.out.println("Enter new title: ");
                String newTitle = scanner.nextLine();
                discMag.setTitle(newTitle);

                System.out.println("Enter 'true' if it includes a disc, otherwise 'false': ");
                boolean hasDisc = scanner.nextBoolean();
                discMag.setHasDisc(hasDisc);

                System.out.println("DiscMag updated to: " + discMag.getTitle() + ", Has Disc: " + discMag.hasDisc());
            }
        } else {
            System.out.println("Invalid item number.");
        }
    }


    private void deleteItem() {
        if (saleableItems.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        viewItems();
        System.out.println("Enter the number of the item you want to delete: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < saleableItems.size()) {
            saleableItems.remove(index);
            System.out.println("Item deleted.");
        } else {
            System.out.println("Invalid item number.");
        }
    }

    private void sellItem() {
        if (saleableItems.isEmpty()) {
            System.out.println("No items available.");
            return;
        }

        viewItems();
        System.out.println("Enter the number of the item you want to sell: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < saleableItems.size()) {
            SaleableItem item = saleableItems.get(index);
            item.sellCopy();

            CashTill cashTill = CashTill.getInstance();
            cashTill.addToTotal(item.getPrice());

            System.out.println("Sold " + item + ". Current total sales: $" + cashTill.showTotal());
        } else {
            System.out.println("Invalid item number.");
        }
    }

    public ArrayList<SaleableItem> getSaleableItems() {
        return this.saleableItems;
    }

}
