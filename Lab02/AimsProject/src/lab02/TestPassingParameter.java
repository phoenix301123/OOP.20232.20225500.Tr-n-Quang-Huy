package lab02;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDvD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDvD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDvD, cinderellaDvD);
		System.out.println("Jungle DvD title: " + jungleDvD.getTitle());
		System.out.println("Cinderella DvD title: " + cinderellaDvD.getTitle());
		
		changeTitle(jungleDvD, cinderellaDvD.getTitle());
		System.out.println("Jungle DvD title: " + jungleDvD.getTitle());
		
	}
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;	
	}
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
