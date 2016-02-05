
public class Item {
	private String name;
	private String description;
	private int quantity;
	private int weight;

	public Item(String name, String description, int quantity, int weight) {
		this.name = name; 
		this.quantity = quantity;
		this.description = description;
		this.weight = weight;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void useItem(int x) {
		quantity = quantity - x;
	}
	
	public void addItem(int x) {
		quantity = quantity + x;
	}
	
	public void setItemQuantity(int x) {
		quantity = x;
	}
	
	public int totalWeight() {
		return weight*quantity;
	}
}
