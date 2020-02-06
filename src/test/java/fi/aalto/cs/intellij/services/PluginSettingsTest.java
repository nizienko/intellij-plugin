package fi.aalto.cs.intellij.services;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import fi.aalto.cs.intellij.notifications.CourseConfigurationError;

import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class PluginSettingsTest {

  @Test
  public void testPluginSettingsWithMissingCourseConfigurationFile() {
    AtomicInteger numberOfCalls = new AtomicInteger(0);
    PluginSettings pluginSettings = new PluginSettings("", (notification, project) -> {
      numberOfCalls.getAndIncrement();
      assertThat("Notification should be an instance of CourseConfigurationError",
          notification, instanceOf(CourseConfigurationError.class));
      assertThat("The notification's cause should be FileNotFoundException",
          ((CourseConfigurationError) notification).getException(),
          instanceOf(FileNotFoundException.class));
    });
    assertEquals("Notification should be shown exactly once.", 1, numberOfCalls.get());
    assertTrue("The currently loaded course should be an empty course",
        pluginSettings.getCurrentlyLoadedCourse().getName().isEmpty());
  }

}