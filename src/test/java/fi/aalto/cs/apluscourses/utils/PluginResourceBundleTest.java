package fi.aalto.cs.apluscourses.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PluginResourceBundleTest {

  @Test
  public void testGetSimpleProperty() {
    String actual = PluginResourceBundle.getText("test.single");
    assertEquals("The retrieved bundle value is correct.", "blaaaah!", actual);
  }

  @Test
  public void testGetCombinedProperty() {
    String actual = PluginResourceBundle.getAndReplaceText("test.compound",
        "blaaaah!", "blaaaah!");
    assertEquals("The retrieved bundle value is correct.",
        "blaaaah! blaaaah! blaaaah!", actual);
  }
}