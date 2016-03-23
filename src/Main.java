import invest.session.Session;
import invest.session.builder.SessionBuilder;
import invest.session.builder.bloomberg.BloombergShareSessionBuilder;

public class Main {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      SessionBuilder builder = new BloombergShareSessionBuilder();
      Session session = builder.getSession("ITX:SM");
      
   }

}
