package invest.history;

import javax.sql.DataSource;

import invest.session.CommoditySession;
import invest.session.Session;

public class CommodityHistory extends History {

	public CommodityHistory(String id, DataSource dataSource) {
      super(id, dataSource);
      // TODO Auto-generated constructor stub
   }

   @Override
	public void addSession(Session session) {
		// TODO Auto-generated method stub
		
	}

   @Override
   public void getIndicators(int index) {
      // TODO Auto-generated method stub
      
   }

}