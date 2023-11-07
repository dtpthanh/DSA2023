//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.PriorityQueue;
//
//public class JavaPriorityQueue {
//  class Student {
//    private int id;
//    private String name;
//    private double cgpa;
//
//    public Student(int id, String name, double cgpa) {
//      this.id = id;
//      this.name = name;
//      this.cgpa = cgpa;
//    }
//
//    public int getId() {
//      return id;
//    }
//
//    public String getName() {
//      return name;
//    }
//
//    public double getCgpa() {
//      return cgpa;
//    }
//  }
//
//  class StudentComparator implements Comparator {
//    public int compare(Student x, Student y)
//    {
//      if (x.getCgpa() == y.getCgpa()) {
//        if (x.getName().equals(y.getName())) {
//          return x.getId() - y.getId();
//        }
//        return x.getName().compareTo(y.getName());
//      }
//      return x.getCgpa() > y.getCgpa() ? -1 : 1;
//    }
//  }
//
//  class Priorities {
//    public List<Student> getStudents (List<String> events) {
//      List<Student> students = new ArrayList<>();
//      boolean flag = false;
//      for (String event : events) {
//        if (event.equals("ENTER")) {
//          students.add();
//        }
//      }
//    }
//  }
//}
