
public class Product {
	
	private String name;
    private Warehouse warehouseLocation;
    private int level;
    private int stock;
    
    public Product(String name,Warehouse warehouseLocation, int level, int stock)
    {
    	this.name = name;
    	this.warehouseLocation=warehouseLocation;
    	this.level=level;
    	this.setStock(stock);
    }
    
    public String getName()
    {
    	return this.name;
    }
     
    public int getLevel()
    {
    	return this.level;
    }
    
    public Warehouse getWarehouse()
    {
    	return this.warehouseLocation;
    }
    
    public void addStock(int amount)
    {
    	this.setStock(this.getStock() + amount);
    }
    
    public void removeStock(int amount)
    {
     if(amount>this.getStock())
    	 System.out.println("Limit exceeded");
     else
    	this.setStock(this.getStock() - amount);
    }

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
    

}
