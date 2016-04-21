package invest.history;

import javax.sql.DataSource;

import invest.session.Session;
import invest.session.ShareSession;
import invest.session.mapper.ShareSessionMapper;

public class ShareHistory extends History {
   public ShareHistory(String id, DataSource dataSource) {
      super(id, dataSource);
      mapper = new ShareSessionMapper();
   }

   @Override
   public void addSession(Session session) {
      String SQL = "INSERT INTO " + id +
                   " (date, openPrice, closePrice, intraMax, intraMin, per) " +
                   "values (?, ?, ?, ?, ? ,?)";
      java.sql.Date sqlDate = new java.sql.Date(session.getDate().getTime());
      double per = ((ShareSession)session).getPER(); 
      jdbcTemplateObject.update( 
            SQL, id, sqlDate, session.getOpeningPrice(), session.getClosingPrice(),
            session.getIntraDayMax(), session.getIntraDayMin(), per);
      return;
   }

   @Override
   public void create() {
      String SQL = "CREATE TABLE " + id + " ( " +
            "id INTEGER UNSIGNED AUTO_INCREMENT," + 
            "date DATETIME DEFAULT NULL," +
            "openPrice FLOAT," +
            "closePrice FLOAT," +
            "intraMax FLOAT," +
            "intraMin FLOAT," +
            "per FLOAT," +
            "PRIMARY KEY (id)" +
            ");";
            
      jdbcTemplateObject.execute( SQL );
      return;
   }
}