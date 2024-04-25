package hust.soict.dsai.aims.media;

public abstract class Media {
	private static int nbMedia = 0;
	private int id;
	private String title;
	private String category;
	private float cost;

	 public Media(String title) {
	        this.title = title;
			this.id = ++nbMedia;
	    }
	    public Media(String title, String category) {
	        this.title = title;
	        this.category = category;
	        this.id = ++nbMedia;
	    }
	    public Media(String title, String category, float cost) {
	        this.title = title;
	        this.category = category;
	        this.cost = cost;
	        this.id = ++nbMedia;
	    }
	    
	    public boolean isMatch(String title) {
	        return this.getTitle().toLowerCase().contains(title.toLowerCase());
	    }
	    
	public String getTitle() {
		return title;
	}
	public int getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}

	//Override equals method
	@Override
    	public boolean equals(Object obj) {
        	if (obj == this) {
            		return true;
        	}
        	if (!(obj instanceof Media)) {
            		return false;
        	}
        	return ((Media)obj).getTitle() == this.getTitle();
    	}	
}
