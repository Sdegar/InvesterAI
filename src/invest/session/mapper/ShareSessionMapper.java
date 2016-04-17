package invest.session.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import invest.session.Session;
import invest.session.ShareSession;

public class ShareSessionMapper extends SessionMapper {

   @Override
   public Session mapRow(ResultSet rs, int rowNum) throws SQLException {
      ShareSession session = new ShareSession();
      fillSession(session, rs, rowNum);
      session.setPER(rs.getDouble("per"));
      return session;
   }

}
