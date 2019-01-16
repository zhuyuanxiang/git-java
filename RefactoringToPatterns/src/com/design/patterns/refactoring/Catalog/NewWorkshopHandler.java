package com.design.patterns.refactoring.Catalog;

import java.util.Map;

public class NewWorkshopHandler extends Handler {
  public NewWorkshopHandler(CatalogApp catalogApp) {
    super(catalogApp);
  }

  @Override
  public HandlerResponse execute(Map parameters) throws Exception {
    createOneThing(parameters);
    return catalogApp.executeActionAndGetResponse(CatalogApp.ALL_WORKSHOPS, parameters);
    // TODO Auto-generated method stub
  }

  private void createOneThing(Map parameters) {
    // TODO Auto-generated method stub

  }
}
