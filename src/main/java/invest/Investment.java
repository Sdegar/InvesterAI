package invest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Investment {

   private String   id;
   private String   type;
   private String   webId;
   private String[] indicators;
   private String   web;

   @XmlElement
   public void setId(String id) {
      this.id = id;
   }

   public String getId() {
      return id;
   }

   @XmlElement
   public void setWebId(String webId) {
      this.webId = webId;
   }

   public String getWebId() {
      return webId;
   }

   @XmlElement
   public void setType(String type) {
      this.type = type;
   }

   public String getType() {
      return type;
   }

   @XmlElement
   public void setWeb(String web) {
      this.web = web;
   }

   public String getWeb() {
      return web;
   }

   @XmlElement
   public String[] getIndicators() {
      return indicators;
   }

   public void setIndicators(String[] indicators) {
      this.indicators = indicators;
   }
}