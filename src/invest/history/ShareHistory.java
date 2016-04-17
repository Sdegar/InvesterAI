package invest.history;

import javax.sql.DataSource;

import invest.session.Session;
import invest.session.ShareSession;
import invest.session.mapper.ShareSessionMapper;

public class ShareHistory extends History {

   private final String CHECK_SQL = 
         "SELECT * FROM INFORMATION_SCHEMA.TABLES " +  
                  "WHERE TABLE_SCHEMA = 'TheSchema'" +  
                  "AND  TABLE_NAME = 'TheTable')";
   
   public ShareHistory(String id, DataSource dataSource) {
      super(id, dataSource);
      mapper = new ShareSessionMapper();
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