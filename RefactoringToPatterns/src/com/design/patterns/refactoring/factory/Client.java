package com.design.patterns.refactoring.factory;

import java.util.ArrayList;
import java.util.List;

public class Client {
  public List<AttributeDescriptor> createAttributeDescriptors() {
    List<AttributeDescriptor> result = new ArrayList<>();
    result.add(forInteger("remoteID", getClass(), Integer.TYPE));
    return result;
  }

  private AttributeDescriptor forInteger(String string, Class<? extends Client> class1,
      Class<Integer> type) {
    // TODO Auto-generated method stub
    return null;
  }
}
