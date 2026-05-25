import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        ExpenseService service = new ExpenseService();

        while(true) {

            System.out.println("\n===== Smart Expense Tracker =====");

            System.out.println("1. Add Expense");
System.out.println("2. View Expenses");
System.out.println("3. Delete Expenses");
System.out.println("4. Update Expense");
System.out.println("5. Search By Category");
System.out.println("6. Show Total Expenses");
System.out.println("7. Category Report");
System.out.println("8. Exit");

            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();
            switch(ch) {

                case 1:

    System.out.print("Enter Title: ");
    String title = sc.nextLine();

    System.out.print("Enter Amount: ");
    double amount = sc.nextDouble();
    sc.nextLine();

    System.out.print("Enter Category: ");
    String category = sc.nextLine();


    Expense expense = new Expense(0, title, amount, category, "");

    service.addExpense(expense);

    break;
                case 2:

                    service.viewExpenses();

                    break;
                case 3:
                    System.out.println("Enter ID want to delete:");
                    int delete_id=sc.nextInt();
                    service.deleteExpense(delete_id);
                
                    break;
                case 4:

    System.out.print("Enter Expense ID to Update: ");

    int updateId = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter New Title: ");
    String newTitle = sc.nextLine();

    System.out.print("Enter New Amount: ");
    double newAmount = sc.nextDouble();
    sc.nextLine();

    System.out.print("Enter New Category: ");
    String newCategory = sc.nextLine();

    service.updateExpense(updateId, newTitle, newAmount, newCategory);

    break;
    case 5:

    sc.nextLine();

    System.out.print("Enter Category To Search: ");

    String searchCategory = sc.nextLine();

    service.searchByCategory(searchCategory);

    break;
    case 6:

    service.showTotalExpenses();

    break;
    /*case 7:

    System.out.print("Enter Budget Limit: ");

    double budget = sc.nextDouble();

    service.setBudget(budget);

    break;

case 8:

    service.checkBudget();

    break;
    case 9:

    service.categoryReport();

    break;*/
                case 7:

    service.categoryReport();

    break;

case 8:

    System.out.println("Thank You!");
    System.exit(0);
        }
    }
}
}