/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderProcessing;

import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Matt
 */
public class OrderProcessing {

    /*
    
    Order : check inventory -> tell it to make a sale (generate sale)
    Sale: make sale (don't check inventory?)
    */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Inventory inv = Inventory.getInstance();
                
        Customer customer1 = new Customer(0, "John");
        
        //Order order = new Order(0,"pen",1, customer1);
        //customer1.submitTransaction(order);

        Return ret = new Return(0, "pen", 5);
        customer1.submitTransaction(ret);
        
        System.out.println("blah");
        
        // this will iterate over all the elements of the inventory hashMap
        /*Iterator it = inv.getItems().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            
            String name = (String) pair.getKey();
            InventoryItem item = (InventoryItem) pair.getValue();
            
            System.out.println("item : " + name + ", quantity: " + item.getQuantity() + ", cost: " + item.getCost());
            it.remove(); // avoids a ConcurrentModificationException
        }*/
    }
}
