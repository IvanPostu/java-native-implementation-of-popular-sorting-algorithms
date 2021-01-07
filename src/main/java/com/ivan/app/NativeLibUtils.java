package com.ivan.app;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public final class NativeLibUtils {
  static public void resolveLibrary(final String libName) {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    URL res = loader.getResource(libName);
    File file;
    try {
      file = Paths.get(res.toURI()).toFile();
      String absolutePath = file.getAbsolutePath();
      System.load(absolutePath);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }
}