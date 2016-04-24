package invest;

enum InvestmentWebs {
   BLOOMBERG("BLOOMBERG"), YAHOO("YAHOO");

   private final String text;

   private InvestmentWebs(final String text) {
      this.text = text;
   }

   @Override
   public String toString() {
      return text;
   }
}
