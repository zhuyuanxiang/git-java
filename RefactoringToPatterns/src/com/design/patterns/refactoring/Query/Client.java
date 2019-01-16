package com.design.patterns.refactoring.Query;

public class Client {
  public void loginToDatabase(String db, String user, String password) {
    Query query;
    if (usingSDVersion52())
      // login to SD 5.2
      query = new QuerySD52(getSD52ConfigFileName());
    else
      // login to SD 5.1
      query = new QuerySD51();
    try {
      query.login(db, user, password);
    } catch (QueryException qe) {

    }
  }
}
