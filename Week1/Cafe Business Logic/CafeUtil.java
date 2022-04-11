import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(int num) {
        int sum = 0;
        int numweeks = num;
        for(int week = 1; week <= numweeks; week++) {
            sum += week;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0;

        for (double orderitem: prices) {
            sum += orderitem;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s %s %n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s!", userName);
        System.out.printf("There are %s people in front of you.", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.printf("%s\n", product);
        for(int quantity = 1; quantity <= maxQuantity; quantity++) {
            System.out.printf("%s: $%.2f\n", quantity, quantity * price);
        }
    }


    public void printPriceChartDiscounts(String product, double price, int maxQuantity) {
        System.out.printf("%s\n", product);
        for(int quantity = 1; quantity <= maxQuantity; quantity++) {
            if (quantity == 1) {
                System.out.printf("%s: $%.2f\n", quantity, quantity * price);
            }
            else {
                System.out.printf("%s: $%.2f\n", quantity, price + (quantity - 1) * (price - 0.50));
            }
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> itemPrices) {
        if (menuItems.size() != itemPrices.size()) {
            return false;
        }
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s - %s: $%.2f %n", i, menuItems.get(i), itemPrices.get(i));
        }
        return true;
    }

// Copied sensei to study later

    public void addCustomers(ArrayList<String> customerList) {
        boolean finished = false;
        String input;
        while (!finished) {
            System.out.println("Please enter a customer name or press Q to quit:");
            input = System.console().readLine();
            if (input.equals("Q")) {
                finished = true;
                return;
            }
            customerList.add(input);
            System.out.printf("%s was added to the list.", input);
            System.out.println(customerList);
        }
    }

}



