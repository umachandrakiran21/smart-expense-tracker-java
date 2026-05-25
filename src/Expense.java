public class Expense {

    int id;
    String title;
    double amount;
    String category;
    String date;

    // Empty Constructor
    public Expense() {

    }

    // Parameterized Constructor
    public Expense(int id, String title, double amount, String category, String date) {

        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Display Expense
    public void displayExpense() {

        System.out.println(
            id + " | " +
            title + " | " +
            amount + " | " +
            category + " | " +
            date
        );
    }
}