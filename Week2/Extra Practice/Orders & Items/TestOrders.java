import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items

        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 1.0;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 2.0;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 3.0;

        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 4.0;

        // Order variables -- order1, order2 etc.
    

        Order order1 = new Order();
        order1.name = "Cindhuri";

        Order order2 = new Order();
        order2.name = "Jimmy";

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";

        // Application Simulations
        // Use this example code to test various orders' updates

        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);

        // System.out.println(order1.total);
        order2.items.add(item1);
        order2.total += item1.price;
        // System.out.println(order2.items); // looks like its an array list so won't show array, just location
        // System.out.println(order2.total);

        order3.items.add(item4);
        order3.total += item4.price;
        // System.out.println(order3.total);

        order4.items.add(item2);
        order4.total += item2.price;
        // System.out.println(order4.total);

        order1.ready = true;
        // System.out.println(order1.ready);

        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price*2;
        // System.out.println(order4.total);

        order2.ready = true;
        // System.out.println(order2.ready);
    }
}
