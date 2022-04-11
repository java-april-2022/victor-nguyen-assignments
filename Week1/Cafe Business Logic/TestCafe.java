import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCafe {
    public static void main(String[] args) {
        
    /* 
        You will need add 1 line to this file to create an instance 
        of the CafeUtil class. 
        Hint: it will need to correspond with the variable name used below..
    */
        CafeUtil appTest = new CafeUtil();
        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week %s: %s \n\n", 16, appTest.getStreakGoal(16));

        /* ============ getOrderTotal ============= */
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        

        /* ============ displayMenu ============= */
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);
    

        /* ============ addCustomer ============= */
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }


        /* ============ Bonus Ninja & Sensei Functionalities ============= */

        /* ============ printPriceChart ============= */
        System.out.println("\n----- Print Price Chart Test-----");
        appTest.printPriceChart("Columbian Coffee Grounds", 15.00, 3);
        System.out.println("\n----- Print Price Chart  Discount Test-----");
        appTest.printPriceChartDiscounts("Columbian Coffee Grounds", 2.00, 4);

        /* ============ boolean displayMenu ============= */
        System.out.println("\n----- boolean Display Menu Test-----");

        ArrayList<Double> prices = new ArrayList<Double>();
        List<Double> listPrices = Arrays.asList(1.5, 2.5, 3.5, 4.5);
        prices.addAll(listPrices);

        appTest.displayMenu(menu, prices);

        /* ============ Add Customers Test ============= */
        // copied Sensei to study later
        System.out.println("\n----- Add Customers Test-----");

        ArrayList<String> newCustomers = new ArrayList<String>();

        appTest.addCustomers(newCustomers);
    }
}
