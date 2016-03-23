package invest.history;

import java.util.ArrayList;
import invest.session.Session;

public abstract class History {

   private String path; 
   private String id;

   /**
    * 
    * @element-type Session
    */
   private ArrayList<Session>  sessions;

   public History(String id){
      this.id = id;
   }
   
   public abstract void addSession(Session session);

   public abstract void getIndicators(int index);

   public Session getSession(int index) {
      Session session = null;
      if (sessions != null){
         if (sessions.size() > index)
         {
            session = sessions.get(index);
         }
      }
      return session;
   }

   public void loadDataBase(String sqlDB) {
      // TODO Auto-generated method stub
      
   }

}