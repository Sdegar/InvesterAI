package invest.session.builder;

import invest.session.Session;
import invest.Investment;

public abstract class SessionBuilder {

    public Investment builder;

  public abstract Session getSession();

}