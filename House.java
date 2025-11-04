/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  public void moveIn(Student s) {
    if (this.residents.contains(s)) {
      throw new RuntimeException(s.getName() + " is already a resident of this house.");
    }
    this.residents.add(s);
    System.out.println(s.getName() + " has moved into " + this.getName());
  }

  public Student moveOut(Student s) {
    if (!this.residents.contains(s)) {
      throw new RuntimeException(s.getName() + " is not a resident of this house.");
    }
    this.residents.remove(s);
    System.out.println(s.getName() + " has moved out of " + this.getName());
    return s;
  }

  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  public int nResidents() {
    return this.residents.size();
  }

  public boolean isResident(Student s) {
    return this.residents.contains(s);
  }

  public static void main(String[] args) {
    new House("house", "123 Main St", 2, true);
  }

}