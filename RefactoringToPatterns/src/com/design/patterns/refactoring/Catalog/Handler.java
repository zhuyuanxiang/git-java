package com.design.patterns.refactoring.Catalog;

import java.util.Map;

public abstract class Handler {

  protected CatalogApp catalogApp;

  public Handler(CatalogApp catalogApp) {
    this.catalogApp = catalogApp;
  }

  public abstract HandlerResponse execute(Map parameters) throws Exception;

}
