package main.java.com.mykola.developer.model;

 public class Developer {

    private int id;
    private String name;
    private String lastName;
    private String position;
    private int salary;
    private int experience;

    public Developer() { }

     public Developer(int id, String name, String lastName, String position, int salary, int experience) {
         this.id = id;
         this.name = name;
         this.lastName = lastName;
         this.position = position;
         this.salary = salary;
         this.experience = experience;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getLastName() {
         return lastName;
     }

     public void setLastName(String lastName) {
         this.lastName = lastName;
     }

     public String getPosition() {
         return position;
     }

     public void setPosition(String position) {
         this.position = position;
     }

     public int getSalary() {
         return salary;
     }

     public void setSalary(int salary) {
         this.salary = salary;
     }

     public int getExperience() {
         return experience;
     }

     public void setExperience(int experience) {
         this.experience = experience;
     }

     @Override
     public String toString() {
         return "Developer{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", lastName='" + lastName + '\'' +
                 ", position='" + position + '\'' +
                 ", salary=" + salary +
                 ", experience=" + experience +
                 '}';
     }
 }
