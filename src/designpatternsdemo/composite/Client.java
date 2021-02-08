package designpatternsdemo.composite;

import java.util.ArrayList;
import java.util.List;


public class Client {
    public static void main(String[] args) {
        Employee manager = new Employee("John");
        
        Employee leadEng = new Employee("Sam");
        Employee eng1 = new Employee("Susie");
        Employee eng2 = new Employee("Bill");
        
        leadEng.addReportee(eng1);
        leadEng.addReportee(eng2);
        manager.addReportee(leadEng);
        
        System.out.println("Manager: " + manager.toString());
        System.out.println("Lead Eng: " + leadEng);
        System.out.println("Eng: " + eng1);
        System.out.println("Eng: " + eng2);
    }
}


class Employee {
   private String name;
   private List<Employee> reportees;

   // constructor
   public Employee(String name) {
      this.name = name;
      reportees = new ArrayList<>();
   }

   public void addReportee(Employee e) {
      reportees.add(e);
   }

   public void removeReportee(Employee e) {
      reportees.remove(e);
   }

   public List<Employee> getReportees(){
     return reportees;
   }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", reportees=" + reportees + '}';
    }
}