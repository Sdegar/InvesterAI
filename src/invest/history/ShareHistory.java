package invest.history;

import invest.session.Session;
import invest.session.ShareSession;

public class ShareHistory extends History {

   private final String CHECK_SQL = 
         "SELECT * FROM INFORMATION_SCHEMA.TABLES " +  
                  "WHERE TABLE_SCHEMA = 'TheSchema'" +  
                  "AND  TABLE_NAME = 'TheTable')";
   
   public ShareHistory(String id) {
      super(id);
      
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