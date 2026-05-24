public class Expense {

    int id;
    String title;
    double amount;
    String category;

    // Empty Constructor
    public Expense() {

    }

    // Parameterized Constructor
    public Expense(int id, String title, double amount, String category) {

        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    public void displayExpense() {

        System.out.println(id + " " + title + " " + amount + " " + category);
    }
}