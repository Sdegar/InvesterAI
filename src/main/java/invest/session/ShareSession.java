package invest.session;

public class ShareSession extends Session {

   private Double PER;

   public Double getPER() {
      return PER;
   }

   public void setPER(Double pER) {
      PER = pER;
   }

   @Override
   public String toString() {
      String output = super.toString();
      output = String.format("%s, PER: %.2f", output, PER);
      return output;
   }

}