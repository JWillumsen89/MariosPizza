package mariosPizza.DataContext.pizzaOrders;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistOrders {
    private final String _FILE = "Orders.ser";

    public void save(List<Order> orders) throws IOException {
        var file = new File(_FILE);
        if(file.exists()){
            FileOutputStream fileOut = new FileOutputStream(_FILE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(orders);
            out.close();
        }
    }

    public List<Order> read() throws IOException {
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(_FILE);
        } catch (FileNotFoundException e) {
            return new ArrayList<Order>();
        }
        var in = new ObjectInputStream(fileIn);
        List<Order> orders;
        try {
            orders = (List<Order>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
        return orders;
    }
}
