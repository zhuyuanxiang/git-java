package com.design.patterns.refactoring.Query;

public class QuerySD52 extends AbstractQuery {
  private String sdConfigFileName;
  private SDLoginSession sdLoginSession;// SD 5.2

  public QuerySD52(String sdConfigFileName) {
    this.sdConfigFileName = sdConfigFileName;
  }

  public void login(String server, String user, String password) throws QueryException {
    sdLoginSession = new SDLoginSession(sdConfigFileName, false);
    try {
      sdLoginSession.loginSession(server, user, password);
    } catch (SDLoginFailedException lfe) {
      throw new QueryException(QueryException.LOGIN_FAILED, "Login failure\n" + lfe, lfe);
    } catch (SDSocketInitFailedException ife) {
      throw new QueryException(QueryException.LOGIN_FAILED, "Socket fail\n" + ife, ife);
    } catch (SDNotFoundException ife) {
      throw new QueryException(QueryException.LOGIN_FAILED, "Not found exception\n" + ife, ife);
    }
  }

  @Override
  protected SDQuery createQuery() {
    sdLoginSession.createQuery(SDQuery.OPEN_FOR_QUERY);
  }

}
