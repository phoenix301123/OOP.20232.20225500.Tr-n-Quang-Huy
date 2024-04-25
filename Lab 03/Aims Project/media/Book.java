package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {

	private List<String> authors = new ArrayList <String>();
	
    // Constructor 
    public Book(String title) {
        super(title);
    }
    public Book(String title, String category) {
        super(title, category);
    }
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
	//Add author
	public void addAuthor(String authorName) {
	        if (!authors.contains(authorName)) {
	            authors.add(authorName);
	        } else {
	            System.out.println("The author has already been in the list.");
	        }
	    }
	 //Remove author
	 public void removeAuthor(String authorName) {
	        if (authors.contains(authorName)) {
	            authors.remove(authorName);
	        } else {
	            System.out.println("No author can be found to remove.");
	        }
	    }

	 @Override
	    public String toString() {
	        return this.getId() + " - Book: " + this.getTitle() +
	                " - Category: " + this.getCategory() +
	                " - Cost: " + this.getCost() + "$";
	    }
	 
}
