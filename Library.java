import java.util.Hashtable;
public class Library extends Building implements LibraryRequirements{

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  public void addTitle(String title) {
    this.collection.put(title, true);
  }

  public String removeTitle(String title) {
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("Title not found in collection.");
    }
    this.collection.remove(title);
    return title;
  }

  public boolean isAvailable(String title) {
    if (this.collection.containsKey(title)) {
      return this.collection.get(title);
    }
    return false;
  }

  public void checkOut(String title) {
    if (this.collection.containsKey(title) && this.collection.get(title)) {
      this.collection.put(title, false);
    } else {
      throw new RuntimeException("Title is not available for checkout.");
    }
  }

  public void returnBook(String title) {
    if (this.collection.containsKey(title) && !this.collection.get(title)) {
      this.collection.put(title, true);
    } else if (this.collection.containsKey(title)) {
       throw new RuntimeException("Title is not checked out.");
    } else {
       throw new RuntimeException("Title does not belong to this library.");
    }
  }

  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  public void printCollection() {
    for (String title : this.collection.keySet()) {
      String status = this.collection.get(title) ? "Available" : "Checked Out";
      System.out.println(title + ": " + status);
    }
  }
  
  public static void main(String[] args) {
    new Library("Neilson", "7 Neilson Drive, Northampton, MA 01063", 4);
  }
  
}