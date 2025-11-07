import java.util.Hashtable;
public class Library extends Building implements LibraryRequirements{

  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for Library class
   * @param name
   * @param address
   * @param nFloors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Adds a title to the library collection
   * @param title
   */
  public void addTitle(String title) {
    this.collection.put(title, true);
  }

  /**
   * Removes a title from the library collection
   * @param title
   * @return the removed title
   */
  public String removeTitle(String title) {
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("Title not found in collection.");
    }
    this.collection.remove(title);
    return title;
  }

  /**
   * Checks if a title is available for checkout
   * @param title
   * @return true if available, false otherwise   
   */
  public boolean isAvailable(String title) {
    if (this.collection.containsKey(title)) {
      return this.collection.get(title);
    }
    return false;
  }

  /**
   * Checks out a title from the library
   * @param title
   */
  public void checkOut(String title) {
    if (this.collection.containsKey(title) && this.collection.get(title)) {
      this.collection.put(title, false);
    } else {
      throw new RuntimeException("Title is not available for checkout.");
    }
  }

  /**
   * Returns a title to the library
   * @param title
   */
  public void returnBook(String title) {
    if (this.collection.containsKey(title) && !this.collection.get(title)) {
      this.collection.put(title, true);
    } else if (this.collection.containsKey(title)) {
       throw new RuntimeException("Title is not checked out.");
    } else {
       throw new RuntimeException("Title does not belong to this library.");
    }
  }

  /**
   * Checks if the library contains a title
   * @param title
   * @return true if the title is in the collection, false otherwise
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  /**
   * Prints the entire collection with availability status
   */
  public void printCollection() {
    for (String title : this.collection.keySet()) {
      String status = this.collection.get(title) ? "Available" : "Checked Out";
      System.out.println(title + ": " + status);
    }
  }
  
  public static void main(String[] args) {
    Library library = new Library("Neilson", "7 Neilson Drive, Northampton, MA 01063", 4);
    library.addTitle("anne of Green Gables");
    library.addTitle("the great gatsby");
    library.printCollection();
    library.checkOut("anne of Green Gables");
    library.printCollection();
  }
  
}