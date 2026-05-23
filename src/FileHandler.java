import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    String fileName = "expenses.txt";

    // Save Expenses To File
    public void saveExpenses(ArrayList<Expense> expenses) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            for(Expense e : expenses) {

                bw.write(e.id + "," + e.title + "," + e.amount + "," + e.category);

                bw.newLine();
            }

            bw.close();

        } catch(Exception e) {

            System.out.println("Error Saving File!");
        }
    }

    // Load Expenses From File
    public ArrayList<Expense> loadExpenses() {

        ArrayList<Expense> expenses = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            while((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                double amount = Double.parseDouble(data[2]);
                String category = data[3];

                Expense expense = new Expense(id, title, amount, category);

                expenses.add(expense);
            }

            br.close();

        } catch(Exception e) {

            System.out.println("File Not Found, Starting Fresh!");
        }

        return expenses;
    }
}