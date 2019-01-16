package com.design.patterns.refactoring.Query;

public class QuerySD51 extends AbstractQuery {
  private SDLogin sdLogin; // SD 5.1
  private SDSession sdSession;// SD 5.1

  public QuerySD51() {
    super();
  }

  @Override
  public void login(String server, String user, String password) throws QueryException {
    try {
      sdSession = sdLogin.loginSession(server, user, password);
    } catch (SDLoginFailedException lfe) {
      throw new QueryException(QueryException.LOGIN_FAILED, "Login failure\n" + lfe, lfe);
    } catch (SDSocketInitFailedException ife) {
      throw new QueryException(QueryException.LOGIN_FAILED, "Socket fail\n" + ife, ife);
    }
  }

  @Override
  protected SDQuery createQuery() {
    sdSession.createQuery(SDQuery.OPEN_FOR_QUERY);
  }
}
