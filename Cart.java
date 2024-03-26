package lab02;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println("The disc with name " + disc.getTitle() + " has been added.");
		}
		else {
			System.out.println("The cart is almost full.");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int pos = -1;
		for (int i = 0; i < qtyOrdered; i ++) {
			if (itemsOrdered[i].equals(disc)) {
				pos = i;
			}
		}
		if (pos == -1) {
			System.out.println("Not found DVD in cart");
			return;
		}
		else {
			for (int i = pos; i < this.qtyOrdered; i++) {
				this.itemsOrdered[i] = this.itemsOrdered[i+1];
			}
			this.qtyOrdered = this.qtyOrdered - 1;
		}
		
	}
	public float totalCost() {
		float total = 0.0f;
		for (int i = 0; i < qtyOrdered; i ++) {
			total = total + this.itemsOrdered[i].getCost();
		
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", null, 0, 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.removeDigitalVideoDisc(dvd2);
		float totalCost = anOrder.totalCost();
		String formattedTotalCost = String.format("%.2f", totalCost);
		System.out.println(formattedTotalCost);

	}
	//Overloading by parameters
	public void addDigitalVideoDisc(DigitalVideoDisc... discs) {
	    for (DigitalVideoDisc disc : discs) {
	        addDigitalVideoDisc(disc);
	    }
	}
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", null, 0, 18.99f);
		anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		float totalCost = anOrder.totalCost();
		String formattedTotalCost = String.format("%.2f", totalCost);
		System.out.println(formattedTotalCost);
	}
}
