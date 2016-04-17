package invest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import invest.history.CommodityHistory;
import invest.history.CurrencyHistory;
import invest.history.History;
import invest.history.IndexHistory;
import invest.history.ShareHistory;
import invest.session.Session;
import invest.session.builder.SessionBuilder;
import invest.session.builder.bloomberg.BloombergShareSessionBuilder;
import invest.session.builder.yahoo.YahooCommoditySessionBuilder;
import invest.session.builder.yahoo.YahooCurrencySessionBuilder;

@XmlRootElement
public class Investment {

   private String id;
   private String type;
   private String webId;
   private String[] indicators;
   private String web;
   
   @XmlElement
   public void setId(String id){
      this.id = id;
   }
   
   @XmlElement
   public void setWebId(String webId){
      this.webId = webId;
   }
   
   @XmlElement
   public void setType(String type){
      this.type = type;
   }   
   
   @XmlElement
   public void setWeb(String web){
      this.web = web;
   }

   public String getId() {
      return id;
   }

   public String getType() {
      return type;
   }

   public String getWebId() {
      return webId;
   }

   public String[] getIndicators() {
      return indicators;
   }

   public String getWeb() {
      return web;
   }
}