package org.github.omnbmh.commons.tools;

import java.net.URI;
import java.net.URL;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @version 2017/4/14 下午3:26
 * @since 1.7
 */
public final class PathTools {

  public static String getClassPath() {
    return getResource("/").getPath();
  }

  public static URL getResource(String name) {
    return PathTools.class.getResource(name);
  }
}
