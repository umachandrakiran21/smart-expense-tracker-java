public class Expense {

    int id;
    String title;
    double amount;
    String category;

    // Constructor
    public Expense(int id, String title, double amount, String category) {

        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    // Display Expense
    public void displayExpense() {

        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Amount: " + amount);
        System.out.println("Category: " + category);
        System.out.println("---------------------------");
    }
}