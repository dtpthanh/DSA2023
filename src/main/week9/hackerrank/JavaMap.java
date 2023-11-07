import java.util.*;
import java.math.*;
public class JavaMap {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());
    Map<String, BigInteger> map=new HashMap<String, BigInteger>();
    for(int i=0;i<n;i++) {
      String name=sc.nextLine();
      BigInteger num=new BigInteger(sc.nextLine());
      map.put(name,num);
    }
    while(sc.hasNextLine()){
      String cmd=sc.nextLine();
      if(map.get(cmd)!=null) System.out.println(cmd+"="+map.get(cmd));
      else System.out.println("Not found");
    }
  }
}