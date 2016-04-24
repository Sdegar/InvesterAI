package invest.session.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import invest.session.Session;

public abstract class SessionMapper implements RowMapper<Session> {

   public abstract Session mapRow(ResultSet rs, int rowNum) throws SQLException;

   protected void fillSession(Session session, ResultSet rs, int rowNum) throws SQLException {
      session.setDate(rs.getDate("date"));
      session.setOpeningPrice(rs.getDouble("openPrice"));
      session.setClosingPrice(rs.getDouble("closePrice"));
      session.setIntraDayMax(rs.getDouble("intraMax"));
      session.setIntraDayMin(rs.getDouble("intraMin"));
   }
}
