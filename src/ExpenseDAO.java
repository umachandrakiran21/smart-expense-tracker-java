import java.sql.*;
import java.util.ArrayList;

public class ExpenseDAO {

    Connection con;

    public ExpenseDAO(Connection con) {

        this.con = con;
    }

    // ADD EXPENSE
    public void addExpense(Expense e) throws Exception {

        String sql = "INSERT INTO expenses(title, amount, category) VALUES (?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, e.title);
        ps.setDouble(2, e.amount);
        ps.setString(3, e.category);

        ps.executeUpdate();
    }

    // VIEW ALL EXPENSES
    public ArrayList<Expense> getAllExpenses() throws Exception {

        ArrayList<Expense> list = new ArrayList<>();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM expenses");

        while(rs.next()) {

            Expense e = new Expense();

            e.id = rs.getInt(1);
            e.title = rs.getString(2);
            e.amount = rs.getDouble(3);
            e.category = rs.getString(4);
            e.date = rs.getString(5);

            list.add(e);
        }

        return list;
    }

    // DELETE EXPENSE
    public void deleteExpense(int id) throws Exception {

        String sql = "DELETE FROM expenses WHERE id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();
    }

    // UPDATE EXPENSE
    public void updateExpense(int id, String title, double amount, String category) throws Exception {

        String sql = "UPDATE expenses SET title=?, amount=?, category=? WHERE id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, title);
        ps.setDouble(2, amount);
        ps.setString(3, category);
        ps.setInt(4, id);

        ps.executeUpdate();
    }
}