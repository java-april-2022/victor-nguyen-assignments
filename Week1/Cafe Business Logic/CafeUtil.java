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

}



