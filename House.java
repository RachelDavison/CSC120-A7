import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  /**
   * Constructor for House class
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Adds a student to the house residents
   * @param student
   */
  public void moveIn(Student student) {
    if (this.residents.contains(student)) {
      throw new RuntimeException(student.getName() + " is already a resident of this house.");
    }
    this.residents.add(student);
    System.out.println(student.getName() + " has moved into " + this.getName());
  }

  /**
   * Removes a student from the house residents
   * @param student
   * @return the removed student
   */
  public Student moveOut(Student student) {
    if (!this.residents.contains(student)) {
      throw new RuntimeException(student.getName() + " is not a resident of this house.");
    }
    this.residents.remove(student);
    System.out.println(student.getName() + " has moved out of " + this.getName());
    return student;
  }

  /**
   * Checks if the house has a dining room
   * @return true if the house has a dining room, false otherwise
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Gets the number of residents in the house
   * @return number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Checks if a student is a resident of the house
   * @param student
   * @return true if the student is a resident, false otherwise
   */
  public boolean isResident(Student student) {
    return this.residents.contains(student);
  }

  public static void main(String[] args) {
    new House("house", "123 Main St", 2, true);
  }

}