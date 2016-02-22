
public class Item {
	//Initializing the item variables
	private String name;
	private String description;
	private int quantity;
	private int weight;

	/**
	 * Constructor for an Item.
	 * @param name
	 * @param description
	 * @param quantity
	 * @param weight
	 */
	public Item(String name, String description, int quantity, int weight) {
		this.name = name; 
		this.quantity = quantity;
		this.description = description;
		this.weight = weight;
	}
	
	//Method returning the Quantity of the item.
	public int getQuantity() {
		return quantity;
	}

	//Method returning the Description of the item.
	public String getDescription() {
		return description;
	}

	//Method returning the Name of the item.
	public String getName() {
		return name;
	}

	//Method returning the Weight of the item.
	public int getWeight() {
		return weight;
	}
	
	//Method subtracting the amount of the item used from the quantity.
	public void useItem(int x) {
		quantity = quantity - x;
	}

	//Method adding x amount to the quantity
	public void addItem(int x) {
		quantity = quantity + x;
	}
	
	//Method setting the quantity to the value of x. 
	public void setItemQuantity(int x) {
		quantity = x;
	}
	
	//Method returning the total weight of an item type.
	public int totalWeight() {
		return weight*quantity;
	}
}
