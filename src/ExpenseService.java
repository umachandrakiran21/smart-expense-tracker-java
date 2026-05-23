import java.util.ArrayList;
import java.util.HashMap;
public class ExpenseService {

    FileHandler fileHandler = new FileHandler();
    ArrayList<Expense> expenses = fileHandler.loadExpenses();
    double budgetLimit = 0;

    // Add Expense
    public void addExpense(Expense expense) {

        expenses.add(expense);
        fileHandler.saveExpenses(expenses);
        System.out.println("Expense Added Successfully!");
    }

    // View Expenses
    public void viewExpenses() {

        if(expenses.isEmpty()) {

            System.out.println("No Expenses Found!");
            return;
        }

        for(Expense e : expenses) {

            e.displayExpense();
        }
    }
    // Delete Expense
// Delete Expense
public void deleteExpense(int id) {

    boolean found = false;

    for(int i = 0; i < expenses.size(); i++) {

        if(expenses.get(i).id == id) {

            expenses.remove(i);

            System.out.println("Expense Deleted Successfully!");

            found = true;

            break;
        }
    }

    fileHandler.saveExpenses(expenses);

    if(!found) {

        System.out.println("Expense ID Not Found!");
    }
}
    // Update Expense
public void updateExpense(int id, String title, double amount, String category) {

    boolean found = false;

    for(Expense e : expenses) {

        if(e.id == id) {

            e.title = title;
            e.amount = amount;
            e.category = category;

            System.out.println("Expense Updated Successfully!");

            found = true;

            break;
        }
    }
    fileHandler.saveExpenses(expenses);
    if(!found) {

        System.out.println("Expense ID Not Found!");
    }
    }
    // Search Expense By Category
public void searchByCategory(String category) {

    boolean found = false;

    for(Expense e : expenses) {

        if(e.category.equalsIgnoreCase(category)) {

            e.displayExpense();

            found = true;
        }
    }

    if(!found) {

        System.out.println("No Expenses Found In This Category!");
    }
    }
    // Total Expense Summary
public void showTotalExpenses() {

    double total = 0;

    for(Expense e : expenses) {

        total = total + e.amount;
    }

    System.out.println("Total Expenses: " + total);
}
// Set Budget
public void setBudget(double budget) {

    budgetLimit = budget;

    System.out.println("Budget Set Successfully!");
}
// Check Budget
public void checkBudget() {

    double total = 0;

    for(Expense e : expenses) {

        total = total + e.amount;
    }

    System.out.println("Budget Limit: " + budgetLimit);
    System.out.println("Total Expenses: " + total);

    if(total > budgetLimit) {

        System.out.println("Warning! Budget Exceeded!");
    }
    else {

        System.out.println("You Are Within Budget.");
    }
}
// Category Wise Report
public void categoryReport() {

    HashMap<String, Double> report = new HashMap<>();

    for(Expense e : expenses) {

        if(report.containsKey(e.category)) {

            double oldAmount = report.get(e.category);

            report.put(e.category, oldAmount + e.amount);
        }
        else {

            report.put(e.category, e.amount);
        }
    }

    System.out.println("===== Category Report =====");

    for(String category : report.keySet()) {

        System.out.println(category + " -> " + report.get(category));
    }
}
}