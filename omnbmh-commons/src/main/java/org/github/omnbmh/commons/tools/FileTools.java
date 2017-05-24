package org.github.omnbmh.commons.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

  public static byte[] getBytes(String filePath) {
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
    } finally {
    }
    return key;
  }

  public static void writeFile(String content, String filePath) {
    try (FileWriter fw = new FileWriter(filePath)) {
      fw.write(content);
      fw.close();
      LOGGER.info("file write finish :" + filePath);
    } catch (IOException e) {
      LOGGER.error("IO Error", e);

    }
  }

  //Classic, < JDK7
  private static void writeBytesToFileClassic(byte[] bFile, String fileDest) {

    FileOutputStream fileOuputStream = null;

    try {
      fileOuputStream = new FileOutputStream(fileDest);
      fileOuputStream.write(bFile);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fileOuputStream != null) {
        try {
          fileOuputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  //Since JDK 7 - try resources
  private static void writeBytesToFile(byte[] bFile, String fileDest) {

    try (FileOutputStream fileOuputStream = new FileOutputStream(fileDest)) {
      fileOuputStream.write(bFile);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  //Since JDK 7, NIO
  private static void writeBytesToFileNio(byte[] bFile, String fileDest) {

    try {
      Path path = Paths.get(fileDest);
      Files.write(path, bFile);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static boolean moveTo() {
    return true;
  }

  public static boolean copyTo() {
    return true;
  }

  public static boolean writeMultiLines(String fileDest, String[] lines) {
    try {
      //使用面向字符流的BufferedWriter类。
      //相当于在FileWriter类上再套上一层管道。
      BufferedWriter out = new BufferedWriter(new FileWriter(fileDest));

      for (String str : lines) {
        //FileWriter类的Write（）方法向文件中写入字符。
        out.write(str);
        out.newLine();
      }
      //清空流里的内容并关闭它，如果不调用该方法还没有完成所有数据的写操作，程序就结束了。
      out.close();
    } catch (IOException e) {
      LOGGER.error("Problem writing" + fileDest + e.getMessage(), e);
      return false;
    }

    return true;
  }
}
