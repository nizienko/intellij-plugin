package fi.aalto.cs.intellij.common;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MalformedCourseConfigurationFileException extends Exception {
  @NotNull
  private final String pathToConfigurationFile;

  public MalformedCourseConfigurationFileException(@NotNull String pathToConfigurationFile,
                                                   @NotNull String message,
                                                   @Nullable Throwable cause) {
    super(message, cause);
    this.pathToConfigurationFile = pathToConfigurationFile;
  }

  @NotNull
  public String getPathToConfigurationFile() {
    return pathToConfigurationFile;
  }

}
