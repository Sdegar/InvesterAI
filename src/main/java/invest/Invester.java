package invest;

import javax.sql.DataSource;

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

public class Invester {

   private DataSource dataSource = null;

   public Invester(DataSource dataSource) {
      this.dataSource = dataSource;
   }

   private static InvestmentType getInvestmentType(Investment invest) {
      return InvestmentType.valueOf(invest.getType());
   }

   private History getHistory(Investment invest) {
      InvestmentType type = getInvestmentType(invest);
      History history = null;
      switch (type) {
         case SHARE:
            history = new ShareHistory(invest.getId(), dataSource);
            break;
         case COMMODITY:
            history = new CommodityHistory(invest.getId(), dataSource);
            break;
         case CURRENCY:
            history = new CurrencyHistory(invest.getId(), dataSource);
            break;
         case INDEX:
            history = new IndexHistory(invest.getId(), dataSource);
            break;
         default:
            // TODO Error case
            break;
      }
      return history;
   }

   public Session getSession(Investment invest) {
      InvestmentWebs iWebs = InvestmentWebs.valueOf(invest.getWeb());
      InvestmentType type = getInvestmentType(invest);
      SessionBuilder builder = null;
      Session session = null;

      switch (type) {
         case SHARE:
            switch (iWebs) {
               case BLOOMBERG:
                  builder = new BloombergShareSessionBuilder();
                  break;
               default:
                  // TODO Error case
            }
            break;
         case COMMODITY:
            switch (iWebs) {
               case YAHOO:
                  builder = new YahooCommoditySessionBuilder();
                  break;
               default:
                  // TODO Error case
            }
            break;
         case CURRENCY:
            switch (iWebs) {
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
      if (builder != null) {
         session = builder.getSession(invest.getWebId());
      }

      return session;
   }

   public void update(Investment invest) {
      /* Get current session */
      Session currentSession = getSession(invest);

      /* Get history */
      History history = getHistory(invest);

      /* TODO Get Indicators from old sessions */

      /* TODO Update Knowledge */

      /* TODO Get Indicators from current session */

      /* TODO Make predictions */

      /* Add current session to history */
      // history.addSession(currentSession);

      System.out.println(currentSession);
   }

}
