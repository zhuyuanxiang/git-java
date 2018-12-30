package com.design.patterns.refactoring.Catalog;

import java.util.HashMap;
import java.util.Map;

public class CatalogApp {
  private Map<String, Handler> handlers;
  static final String NEW_WORKSHOP = null;
  static final String ALL_WORKSHOPS = null;

  public void Catalog() {
    createHandlers();
  }

  public void createHandlers() {
    handlers = new HashMap<>();
    handlers.put(CatalogApp.NEW_WORKSHOP, new NewWorkshopHandler(this));
    handlers.put(CatalogApp.ALL_WORKSHOPS, new AllWorkshopHandler(this));
  }

  HandlerResponse executeActionAndGetResponse(String handlerName, Map parameters) throws Exception {
    Handler handler = lookupHandlerBy(handlerName);
    return handler.execute(parameters);
  }

  private Handler lookupHandlerBy(String handlerName) {
    return handlers.get(handlerName);
  }

}
