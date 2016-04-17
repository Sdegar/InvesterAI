package invest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Investments {
   private List<Investment> investment;
   
   public Investments(){}
   public Investments(List<Investment> investment) {  
      super();  
      this.investment = investment;  
   }
   
   @XmlElement
   public List<Investment> getInvestment() {  
       return investment;  
   }  
     
   public void setInvestment(List<Investment> investment) {  
       this.investment = investment;  
   }
  
}
