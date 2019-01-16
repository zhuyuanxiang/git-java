package com.design.patterns.refactoring.Query;

public interface Query {

  void doQuery() throws QueryException;

  void login(String server, String user, String password) throws QueryException;

}
