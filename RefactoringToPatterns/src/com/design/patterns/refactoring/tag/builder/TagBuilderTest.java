package com.design.patterns.refactoring.tag.builder;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zYx.Tom
 *
 */
public class TagBuilderTest {

  @Test
  public final void testBuildNode() {
    String expectedXML = "<flavors/>";
    String actualXML = new TagBuilder("flavors").toXML();
    Assert.assertEquals(expectedXML, actualXML);
  }

  @Test
  public final void testBuildOneChild() {
    String expectedXML = "<flavors><flavor/></flavors>";
    TagBuilder builder = new TagBuilder("flavors");
    builder.addChild("flavor");
    String actualXML = builder.toXML();
    Assert.assertEquals(expectedXML, actualXML);
  }

  @Test
  public final void testBuildChildrenOfChildren() {
    String expectedXML =
        "<flavors><flavor><requirements><requirement/></requirements></flavor></flavors>";
    TagBuilder builder = new TagBuilder("flavors");
    builder.addChild("flavor");
    builder.addChild("requirements");
    builder.addChild("requirement");
    String actualXML = builder.toXML();
    Assert.assertEquals(expectedXML, actualXML);
  }

  @Test
  public final void testRepeatingChildrenAndGrandchildren() {
    String expectedXML =
        "<flavors>" + "<flavor><requirements><requirement/></requirements></flavor>"
            + "<flavor><requirements><requirement/></requirements></flavor>" + "</flavors>";
    TagBuilder builder = new TagBuilder("flavors");
    for (int i = 0; i < 2; i++) {
      builder.addToParent("flavors", "flavor");
      builder.addChild("requirements");
      builder.addChild("requirement");
    }
    String actualXML = builder.toXML();
    Assert.assertEquals(expectedXML, actualXML);
  }

  @Test
  public final void testBuildSibling() {
    String expectedXML = "<flavors><flavor1/><flavor2/></flavors>";
    TagBuilder builder = new TagBuilder("flavors");
    builder.addChild("flavor1");
    builder.addSibling("flavor2");
    String actualXML = builder.toXML();
    Assert.assertEquals(expectedXML, actualXML);
  }

  @Test
  public final void testParents() {
    TagNode root = new TagNode("root");
    Assert.assertNull(root.getParent());

    TagNode childNode = new TagNode("child");
    root.add(childNode);
    Assert.assertEquals(root, childNode.getParent());
    Assert.assertEquals("root", childNode.getParent().getName());
  }

  @Test
  public final void testParentNameNotFound() {
    TagBuilder builder = new TagBuilder("flavors");
    try {
      for (int i = 0; i < 2; i++) {
        builder.addToParent("favors", "flavor");
        builder.addChild("requirements");
        builder.addChild("requirement");
      }
      Assert.fail("should not allow adding to parent that doesn't exist.");
    } catch (RuntimeException runtimeException) {
      String expectedErrorMessage = "missing parent tag: favors";
      Assert.assertEquals(expectedErrorMessage, runtimeException.getMessage());
    }
  }

  @Test
  public final void testAttributesAndValues() {
    String expectedXML = "<flavor name='Test-Driven Development'>" + "<requirements>"
        + "<requirement type='hardware'>" + "1 computer for every 2 participants" + "</requirement>"
        + "<requirement type='software'>" + "IDE" + "</requirement>" + "</requirements>"
        + "</flavor>";

    TagBuilder builder = new TagBuilder("flavor");
    builder.addAttribute("name", "Test-Driven Development");
    builder.addChild("requirements");
    builder.addToParent("requirements", "requirement");
    builder.addAttribute("type", "hardware");
    builder.addValue("1 computer for every 2 participants");
    builder.addToParent("requirements", "requirement");
    builder.addAttribute("type", "software");
    builder.addValue("IDE");
    String actualXML = builder.toXML();

    Assert.assertEquals(expectedXML, actualXML);
  }

  @Test
  public final void testAttributes() {
    String expectedXML = "<flavor name='Test-Driven Development'>" + "<requirements>"
        + "<requirement type='software'/>" + "</requirements>" + "</flavor>";

    TagBuilder builder = new TagBuilder("flavor");
    builder.addAttribute("name", "Test-Driven Development");
    builder.addChild("requirements");
    builder.addToParent("requirements", "requirement");
    builder.addAttribute("type", "software");
    String actualXML = builder.toXML();

    Assert.assertEquals(expectedXML, actualXML);
  }

  @Test
  public final void testToStringBufferSize() {
    String expectedXML = "<flavor name='Test-Driven Development'>" + "<requirements>"
        + "<requirement type='software'/>IDE</requirements>" + "</flavor>";

    TagBuilder builder = new TagBuilder("flavor");
    builder.addAttribute("name", "Test-Driven Development");
    builder.addChild("requirements");
    builder.addToParent("requirements", "requirement");
    builder.addAttribute("type", "software");
    builder.addValue("IDE");

    int stringSize = builder.toXML().length();
    int computedSize = builder.bufferSize();
    Assert.assertEquals("buffer size", computedSize, stringSize);
  }
}
