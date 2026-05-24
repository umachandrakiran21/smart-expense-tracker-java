import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class ExpenseService {

    Connection con;
    ExpenseDAO dao;

    public ExpenseService() throws Exception {

        con = DBConnection.getConnection();

        dao = new ExpenseDAO(con);
    }

    // Add Expense
    public void addExpense(Expense expense) throws Exception {

        dao.addExpense(expense);

        System.out.println("Expense Added Successfully!");
    }

    // View Expenses
    public void viewExpenses() throws Exception {

        ArrayList<Expense> expenses = dao.getAllExpenses();

        if(expenses.isEmpty()) {

            System.out.println("No Expenses Found!");
            return;
        }

        for(Expense e : expenses) {

            e.displayExpense();
        }
    }

    // Delete Expense
    public void deleteExpense(int id) throws Exception {

        dao.deleteExpense(id);

        System.out.println("Expense Deleted Successfully!");
    }

    // Update Expense
    public void updateExpense(int id, String title, double amount, String category) throws Exception {

        dao.updateExpense(id, title, amount, category);

        System.out.println("Expense Updated Successfully!");
    }

    // Search By Category
    public void searchByCategory(String category) throws Exception {

        ArrayList<Expense> expenses = dao.getAllExpenses();

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

    // Total Expenses
    public void showTotalExpenses() throws Exception {

        ArrayList<Expense> expenses = dao.getAllExpenses();

        double total = 0;

        for(Expense e : expenses) {

            total += e.amount;
        }

        System.out.println("Total Expenses: " + total);
    }

    // Category Report
    public void categoryReport() throws Exception {

        ArrayList<Expense> expenses = dao.getAllExpenses();

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