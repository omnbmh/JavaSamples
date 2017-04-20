package org.github.omnbmh.commons.tools;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by b1rd on 2017/1/4.
 */
public final class FileTools {

  private static Logger LOGGER = Logger.getLogger(FileTools.class);

  public static String currentDir() {
    String dir = ".";
    File f = new File(dir);
    try {
      dir = f.getCanonicalPath();
    } catch (IOException e) {
      LOGGER.error("IO Error", e);
    }
    return dir;
  }

  public static boolean exists(String path, boolean isCreate) {
    File f = new File(path);
    boolean isexists = f.exists();
    if (!isexists && isCreate) {
      try {
        f.createNewFile();
      } catch (IOException e) {
        LOGGER.error("IO Error", e);
      }
    }
    return isexists;
  }

  /*
* Java文件操作 获取文件扩展名
*
*
*/
  public static String getExtensionName(String filename) {
    if ((filename != null) && (filename.length() > 0)) {
      int dot = filename.lastIndexOf('.');
      if ((dot > -1) && (dot < (filename.length() - 1))) {
        return filename.substring(dot + 1);
      }
    }
    return filename;
  }

  /*
   * Java文件操作 获取不带扩展名的文件名
   *
   */
  public static String getFileNameNoEx(String filename) {
    if ((filename != null) && (filename.length() > 0)) {
      int dot = filename.lastIndexOf('.');
      if ((dot > -1) && (dot < (filename.length()))) {
        return filename.substring(0, dot);
      }
    }
    return filename;
  }
}
