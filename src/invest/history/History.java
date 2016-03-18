package invest.history;

import java.util.Vector;
import invest.session.Session;
import invest.Investment;

public abstract class History {

  public String id;

    /**
   * 
   * @element-type Session
   */
  public Vector  sessions;
    public Investment history;

  public abstract void addSession(Session session);

  public abstract void getIndicators(Integer sessionsBack);

  public Session getSession(Integer date) {
  return null;
  }

}