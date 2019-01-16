package com.design.patterns.refactoring.Catalog;

import java.util.Map;

public class AllWorkshopHandler extends Handler {
  private static String ALL_WORKSHOPS_STYLESHEET = "allWorkshops.xls";
  private PrettyPrinter prettyPrinter = new PrettyPrinter();

  public AllWorkshopHandler(CatalogApp catalogApp) {
    super(catalogApp);
  }

  @Override
  public HandlerResponse execute(Map parameters) throws Exception {
    createAnotherThing(parameters);
    return new HandlerResponse(new StringBuffer(prettyPrint(allWokshopsData())),
        AllWorkshopHandler.ALL_WORKSHOPS_STYLESHEET);
  }

  private String prettyPrint(String buffer) {
    // TODO Auto-generated method stub
    return null;
  }

  private String allWokshopsData() {
    // TODO Auto-generated method stub
    return null;
  }

  private void createAnotherThing(Map parameters) {

  }

}
