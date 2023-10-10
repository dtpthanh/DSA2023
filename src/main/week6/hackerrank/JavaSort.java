import java.util.*;


public class JavaSort
{
  class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
      super();
      this.id = id;
      this.fname = fname;
      this.cgpa = cgpa;
    }
    public int getId() {
      return id;
    }
    public String getFname() {
      return fname;
    }
    public double getCgpa() {
      return cgpa;
    }
  }

  //Complete the code
  class StudentComparator implements Comparator<Student> {
    @Override
    public int compare (Student x, Student y) {
      if(x.getCgpa() != y.getCgpa()) {
        if(x.getCgpa() > y.getCgpa()) return -1;
        else return 1;
      }
      else if(!(x.getFname().equals(y.getFname()))) {
        return x.getFname().compareTo(y.getFname());
      }
      else return x.getId() - y.getId();
    }
  }
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());

    List<Student> studentList = new ArrayList<Student>();
    while(testCases>0){
      int id = in.nextInt();
      String fname = in.next();
      double cgpa = in.nextDouble();
      JavaSort java = new JavaSort();
      Student st = java.new Student(id, fname, cgpa);
      studentList.add(st);

      testCases--;
    }
    Collections.sort(studentList, new JavaSort().new StudentComparator());
    for(Student st: studentList){
      System.out.println(st.getFname());
    }
  }
}



