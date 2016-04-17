package invest.history;

import java.util.ArrayList;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import invest.session.Session;
import invest.session.mapper.SessionMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class History {

   private String id;

   protected SessionMapper mapper = null;
   
   private JdbcTemplate jdbcTemplateObject;
   
   /**
    * 
    * @element-type Session
    */
   private ArrayList<Session>  sessions;

   public History(String id, DataSource dataSource){
      this.id = id;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }
   
   public abstract void addSession(Session session);

   public abstract void getIndicators(int index);

   public Session getSession(int index) {
      String SQL = "select * from " + id + " where id = ?";
      Session session = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{index}, mapper);
      return session;
   }

   public void loadDataBase(String sqlDB) {
      // TODO Auto-generated method stub
      
   }

}