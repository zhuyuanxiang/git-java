package com.design.patterns.refactoring.Query;

public abstract class AbstractQuery implements Query {
  protected SDQuery sdQuery;// SD 5.1 & 5.2

  /*
   * @author zYx.Tom(zhuyuanxiang@gmail.com) 2018Äê12ÔÂ30ÈÕ
   * @see com.design.patterns.refactoring.Query.Query#doQuery()
   */
  @Override
  public void doQuery() throws QueryException {
    if (sdQuery != null)
      sdQuery.clearResultSet();
    sdQuery = createQuery();
    executeQuery();
  }

  protected abstract SDQuery createQuery();
}
