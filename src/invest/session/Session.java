package invest.session;

import java.util.Date;

public abstract class Session {

   private Date date;
   private Double closingPrice;
   private Double openingPrice;
   private Double intraDayMax;
   private Double intraDayMin;

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public Double getClosingPrice() {
      return closingPrice;
   }

   public void setClosingPrice(Double closingPrice) {
      this.closingPrice = closingPrice;
   }

   public Double getOpeningPrice() {
      return openingPrice;
   }

   public void setOpeningPrice(Double openingPrice) {
      this.openingPrice = openingPrice;
   }

   public Double getIntraDayMax() {
      return intraDayMax;
   }

   public void setIntraDayMax(Double intraDayMax) {
      this.intraDayMax = intraDayMax;
   }

   public Double getIntraDayMin() {
      return intraDayMin;
   }

   public void setIntraDayMin(Double intraDayMin) {
      this.intraDayMin = intraDayMin;
   }

   @Override
   public String toString(){
      String output = String.format(
            "Date: %s, Close: %.2f, Open: %.2f, Intra Min: %.2f, Intra Max: %.2f", 
            date, closingPrice, openingPrice, intraDayMin, intraDayMax);
      return output;
   }

}