/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderProcessing;

import java.util.Random;


/**
 *
 * @author Matt
 */
public class OrderProcessing {

    public static final int NUM_TRANSACTIONS = 100000;
    public static final int NUM_TRANSACTION_TYPES = 4;
    
    public static final int EXCHANGE = 1;
    public static final int INVENTORY_ADJUSTMENT = 2;
    public static final int ORDER = 3;
    public static final int RETURN = 4;

    public static Thread[] transactions = new Thread[NUM_TRANSACTIONS];
    
    
    /**
     * @param args the command line arguments
     */
             
             
    public static void main(String[] args) {
        generateTransactions();
        runTransactions();
    }
    
    public static void generateTransactions()
    {
        Random rand = new Random();
        
        Customer customer = new Customer(0,"Mike",100.0);
                
        for(int x = 0; x< NUM_TRANSACTIONS; x++)
        {
            int transactionType = rand.nextInt(NUM_TRANSACTION_TYPES) + 1;
            Transaction transaction = null;
            
            switch (transactionType)
            {
                case EXCHANGE:
                    transaction = new Exchange(x,"pen", "paper");
                    break;
                case INVENTORY_ADJUSTMENT:
                    transaction = new InventoryAdjustment(x,"pen", 1);
                    break;
                case ORDER:
                    transaction = new Order(x,"pen",2, customer);
                    break; 
                case RETURN:
                    transaction = new Return(x,"pen",2);
                    break; 
                default:
                    System.out.println("UNKONWN TRANSACTION TYPE");
                    break;
            }     
            transactions[x] = new Thread(transaction);
        }
    }
    
    public static void runTransactions()
    {
        for(int x = 0; x< NUM_TRANSACTIONS; x++)
        {
            transactions[x].start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // handle the exception...        
                // For example consider calling Thread.currentThread().interrupt(); here.
            }
        }
    }
    
    
}
