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
   private InvestmentType type;
   private String webId;
   private String[] indicators;
   private History history;
   private SessionBuilder builder;
   
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
      this.type = InvestmentType.valueOf(type);
      switch (this.type)
      {
         case SHARE:
            history = new ShareHistory(id);
            break;
         case COMMODITY:
            history = new CommodityHistory(id);
            break;
         case CURRENCY:
            history = new CurrencyHistory(id);
            break;
         case INDEX:
            history = new IndexHistory(id);
            break;
         default:
            // TODO Error case
            break;
      }
   }   
   
   @XmlElement
   public void setWeb(String web){
      InvestmentWebs iWebs = InvestmentWebs.valueOf(web);
      switch (this.type)
      {
         case SHARE:
            switch (iWebs){
               case BLOOMBERG:
                  builder = new BloombergShareSessionBuilder();
                  break;
               default:
                  // TODO Error case
            }
            break;
         case COMMODITY:
            switch (iWebs){
               case YAHOO:
                  builder = new YahooCommoditySessionBuilder();
                  break;
               default:
                  // TODO Error case
            }
            break;
         case CURRENCY:
            switch (iWebs){
               case YAHOO:
                  builder = new YahooCurrencySessionBuilder();
                  break;
               default:
                  // TODO Error case
            }
            break;
         case INDEX:
            // TODO
            break;
         default:
            // TODO Error case
            break;
      }
   }
   
   public void update(){      
      /* Get current session */
      Session session = builder.getSession(webId);
      
      /* TODO Get Indicators from old sessions */
      
      /* TODO Update Knowledge */
      
      /* TODO Get Indicators from current session */
      
      /* TODO Make predictions */
      
      /* Add current session to history */
      history.addSession(session);
   }
}