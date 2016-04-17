package invest;

enum InvestmentType {
   SHARE("SHARE"),
   COMMODITY("COMMODITY"),
   CURRENCY("CURRENCY"),
   INDEX("INDEX");
   
   private final String text;
   private InvestmentType(final String text){
      this.text = text;
   }
   @Override
   public String toString(){
      return text;
   }
}
