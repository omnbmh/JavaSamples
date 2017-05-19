package org.github.omnbmh.commons.tools;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

  public  static  byte[] getBytes(String filePath){
//    String key = "";
//    try (FileReader fr = new FileReader(filePath)) {fr.
//      BufferedReader br = new BufferedReader(fr);
//      String brl = br.readLine();
//      key = brl;
//      while (brl != null) {
//        brl = br.readLine();
//        key += brl;
//      }
//      br.close();
//      fr.close();
//      LOGGER.debug("read file content :");
//      LOGGER.debug(key);
//      return key;
//    } catch (IOException e) {
//      LOGGER.error("IO Error", e);
//    }
//    finally {
//    }
//    return key;

    byte[] buffer = null;
    try {
      File file = new File(filePath);
      FileInputStream fis = new FileInputStream(file);
      ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
      byte[] b = new byte[1000];
      int n;
      while ((n = fis.read(b)) != -1) {
        bos.write(b, 0, n);
      }
      fis.close();
      bos.close();
      buffer = bos.toByteArray();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return buffer;
  }

  public static String getText(String filePath) {
    String key = "";
    try (FileReader fr = new FileReader(filePath)) {
      BufferedReader br = new BufferedReader(fr);
      String brl = br.readLine();
      key = brl;
      while (brl != null) {
        brl = br.readLine();
        key += brl;
      }
      br.close();
      fr.close();
      LOGGER.debug("read file content :");
      LOGGER.debug(key);
      return key;
    } catch (IOException e) {
      LOGGER.error("IO Error", e);
    }
    finally {
    }
    return key;
  }

  public  static  void  writeFile(String content,String filePath){
    try(FileWriter fw = new FileWriter(filePath))
    {
      fw.write(content);
      fw.close();
      LOGGER.info("file write finish :" + filePath);
    }catch (IOException e){
      LOGGER.error("IO Error", e);

    }
  }
}
