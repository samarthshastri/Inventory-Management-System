import java.util.HashMap;

//Class implementing the required interface
public class items implements InventoryManagementSystem{
	private HashMap<String,Product> product;
	private HashMap<String,Warehouse> warehouse1;
	
	public items()
	{
		this.product= new HashMap<String,Product>();
		this.warehouse1 = new HashMap<String,Warehouse>();
	}
	
	public void addProduct(Product prod)
	{
		product.put(prod.getName(), prod);
	}
	
	public void addWarehouse(Warehouse warehouse)
	{
		warehouse1.put(warehouse.getlevel(),warehouse);
	}

	@Override
	public PickingResult pickProduct(String productId, int amountToPick) {
		Product prod = product.get(productId);
		if(prod==null)
		{
			return null;
		}
		//System.out.println(prod.getStock());
		prod.removeStock(amountToPick);
		product.put(productId, prod);
		PickingResult pickingResult = new PickingResult();
		pickingResult.setName(prod.getName());
		pickingResult.setLevel(prod.getLevel());
		pickingResult.setStock(prod.getStock());
		pickingResult.setWarehouse(prod.getWarehouse());
		
		return pickingResult;
	}

	@Override
	public RestockingResult restockProduct(String productId, int amountToRestock) {
		
		Product prod = product.get(productId);
		if(prod==null)
		{
			return null;
		}
		prod.addStock(amountToRestock);
		product.put(productId, prod);
		RestockingResult restockingResult= new RestockingResult();
		restockingResult.setName(prod.getName());
		restockingResult.setLevel(prod.getLevel());
		restockingResult.setStock(prod.getStock());
		restockingResult.setWarehouse(prod.getWarehouse());
		
		//System.out.println("\n\n "+restockingResult.getWarehouse());
		
		return restockingResult;
	}

}
