public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly.";
        String readyMessage = ", your order is ready.";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 14.5;
        double lattePrice = 7.0;
        double cappucinoPrice = 5.0;

        // double DripCoffePrice = 5.0;
        // double LattePrice = 4.5;
        // double CappucinoPrice = 5.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customerSam = "Sam";
        String customerJimmy = "Jimmy";
        String customerNoah = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrderSam = false;
        boolean isReadyOrderJimmy = true;
        boolean isReadyOrderNoah = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        // Order 1
        // System.out.println(generalGreeting + customer1 + "."); // Displays "Welcome to Cafe Java, Cindhuri"
    	// // ** Your customer interaction print statements will go here ** //
        // System.out.println(customer1 + readyMessage);
        // System.out.println(displayTotalMessage + dripCoffeePrice);

        // Order 2 
        // if (isReadyOrderNoah) {
        //     System.out.println(generalGreeting + customerNoah + ".");
        //     System.out.println(customerNoah + readyMessage);
        //     System.out.println(displayTotalMessage + cappucinoPrice);
        // }
        // else {
        //     System.out.println(generalGreeting + customerNoah + ".");
        //     System.out.println(customerNoah + pendingMessage);
        // }

        // Order 3
        // if (isReadyOrderSam) {
        //     System.out.println(generalGreeting + customerSam + ".");
        //     System.out.println(customerSam + readyMessage);
        //     System.out.println(displayTotalMessage + cappucinoPrice + cappucinoPrice);
        // }
        // else {
        //     System.out.println(generalGreeting + customerSam + ".");
        //     System.out.println(customerSam + pendingMessage);
        //     System.out.println(displayTotalMessage + (cappucinoPrice+cappucinoPrice));
        //     isReadyOrderSam = true;
        //     if (isReadyOrderSam == true) {
        //         System.out.println("The order is now ready.");
        //     } 
        // }

        // Order 4
        System.out.println("Sorry for the mixup, " + customerJimmy);
        if (lattePrice - dripCoffeePrice > 0) {
            System.out.println("Your remaining total is $" + (lattePrice - dripCoffeePrice));
        }
        else {
            System.out.println("You are owed: $" + (-(lattePrice - dripCoffeePrice)));
        }
    }
}