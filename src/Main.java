import java.util.Scanner;

/*Author:Samarth.V.Shastri
 Assuming that each Product is associated with ProductID and is located at a particular warehouse number at a particular level;*/
public class Main {
	public static items item = new items();
	public static void main(String[] args)
	{
		
		Warehouse wareHouse1 = new Warehouse("w1");
		Warehouse wareHouse2 = new Warehouse("w2");
		Warehouse wareHouse3 = new Warehouse("w3");
		
		
		Product product1 = new Product("p1",wareHouse1,10,100);
		Product product2 = new Product("p2",wareHouse2,9,100);
		Product product3 = new Product("p3",wareHouse3,11,100);
		item.addProduct(product1);
		item.addProduct(product2);
		item.addProduct(product3);
		
		item.addWarehouse(wareHouse1);
		item.addWarehouse(wareHouse2);
		item.addWarehouse(wareHouse3);
		
		
		threads t1 = new threads(); 
		t1.run(); // Start new thread for every process
		
	}
	
	static class threads extends Thread
	{
		public void run()
		{
			synchronized(this) // Synchronized block to avoid deadlock and race conditions
			{
				input();
			}
			
		}
		
	}
	
	static public void input()
	{
		int in=0;
	   Scanner sc = new Scanner(System.in);
	  // in =0
	   while(in!=3)
	   {
	   System.out.println("\n Enter choice to perform");
	   System.out.println("1)pick product\n2)restock product\n3) exit");
	   in = sc.nextInt();
	   int amount;
	   String productId;
	  
	   
	 
		if(in==1)
	   		{
		  
		   System.out.println("Enter ProductId?");
		   productId = sc.next();
		   System.out.println("Enter amount to pick?");
		   amount = sc.nextInt();
		   PickingResult p = item.pickProduct(productId, amount);
		   if(p==null)
			   System.out.println("Product not found in Inventory");
		   else
		   {
		   System.out.println("Product id is: "+p.getName()+"\n"+"Amount picked: "+amount+"\ncurrent stock of Product after picking: "+p.getStock()+"\n"
		   +"Warehouse number: "+p.getWarehouse().getlevel()+"\n"+"Level in warehouse: "+p.getLevel());
	   		}
	   		}
	   else if(in==2)
	   		{
		   
		   System.out.println("Enter ProductId?");
		   productId = sc.next();
		   System.out.println("Enter amount to stock?");
		   amount = sc.nextInt();
		   RestockingResult r = item.restockProduct(productId, amount);
		   if(r==null)
			   System.out.println("Product not found in Inventory");
		   else
		   {
		   System.out.println("Product id is: "+r.getName()+"\n"+"Amount stocked: "+amount+"\ncurrent stock of Product after stocking: "+r.getStock()+"\n"
				   +"Warehouse number: "+r.getWarehouse().getlevel()+"\n"+"Level in warehouse: "+r.getLevel());
		  
	   	}
	   		}
		
	   }
	}

}
