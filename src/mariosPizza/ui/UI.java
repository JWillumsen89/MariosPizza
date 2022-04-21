package mariosPizza.ui;

public class UI {

    public UI(Marios marios) {
        //this.marios = marios;
    }

    public void helpMenu() {
        System.out.println("""
                
        Use can use the following commands throughout:
                
        [1] Create new order
        [2] Print list of orders
        [3] Change order status
        [4] Show menu card""");

    }

    public void createNewOrder() {
        /*
        System.out.println("");
        System.out.print("Pick a pizza: ");
        int input = in.nextInt() - 1;
        System.out.println("Decide pick up time [HH:mm]: ");
        double time = 10.10;
        System.out.println();
        String order = "#" + idNum + " - " + (marios.pz.pizzaList.get(input) + ". PICK UP TIME: 10:35");
        System.out.println(marios.pz.pizzaList.get(input));
        orderList.add(order);
        idNum++;
         */
    }

    public void removeOrder() {
        System.out.println("");
        System.out.println("Remove order: ");
        //int input = in.nextInt();
    }

    public void printOrders() {
        /*
        System.out.println("--------------------------------------------------Order List--------------------------------------------------");
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i));
        }
         */
    }

}
