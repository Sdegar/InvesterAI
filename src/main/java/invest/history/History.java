package invest.history;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import invest.session.Session;
import invest.session.mapper.SessionMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class History {

   protected String        id;

   protected SessionMapper mapper = null;

   protected JdbcTemplate  jdbcTemplateObject;

   public History(String id, DataSource dataSource) {
      this.id = id;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public void addSession(Session session) {
      String SQL = "INSERT INTO " + id + " (date, openPrice, closePrice, intraMax, intraMin) "
            + "values (?, ?, ?, ?, ? ,?)";
      java.sql.Date sqlDate = new java.sql.Date(session.getDate().getTime());
      jdbcTemplateObject.update(SQL, id, sqlDate, session.getOpeningPrice(), session.getClosingPrice(),
            session.getIntraDayMax(), session.getIntraDayMin());
      return;
   }

   public Session getSession(int index) {
      String SQL = "SELECT * FROM " + id + " WHERE id = ?";
      Session session = jdbcTemplateObject.queryForObject(SQL, new Object[] { index }, mapper);
      return session;
   }

   public Session getSession(Date date) {
      java.sql.Date sqlDate = new java.sql.Date(date.getTime());
      String SQL = "SELECT * FROM " + id + " WHERE date = ?";
      Session session = jdbcTemplateObject.queryForObject(SQL, new Object[] { sqlDate }, mapper);
      return session;
   }

   public List<Session> getSessionsTo(int index, int count) {
      String SQL = "SELECT * FROM " + id + " WHERE id <= ? LIMIT ?";
      List<Session> sessions = jdbcTemplateObject.query(SQL, new Object[] { index, count }, mapper);
      return sessions;
   }

   public List<Session> getSessionsTo(Date date, int count) {
      java.sql.Date sqlDate = new java.sql.Date(date.getTime());
      String SQL = "SELECT * FROM " + id + " WHERE date <= ?";
      List<Session> sessions = jdbcTemplateObject.query(SQL, new Object[] { sqlDate, count }, mapper);
      return sessions;
   }

   public void create() {
      String SQL = "CREATE TABLE " + id + " ( " + "id INTEGER UNSIGNED AUTO_INCREMENT," + "date DATETIME DEFAULT NULL,"
            + "openPrice FLOAT," + "closePrice FLOAT," + "intraMax FLOAT," + "intraMin FLOAT," + "PRIMARY KEY (id)"
            + ");";

      jdbcTemplateObject.execute(SQL);
      return;
   }

   public void delete() {
      String SQL = "DROM TABLE " + id + ";";
      jdbcTemplateObject.execute(SQL);
      return;
   }

}