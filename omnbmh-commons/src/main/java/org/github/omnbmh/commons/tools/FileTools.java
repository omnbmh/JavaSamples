package org.github.omnbmh.commons.tools;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by b1rd on 2017/1/4.
 */
public final class FileTools {

  private static Logger logger = Logger.getLogger(FileTools.class);

  public static String currentDir() {
    String dir = ".";
    File f = new File(dir);
    try {
      dir = f.getCanonicalPath();
    } catch (IOException e) {
      logger.error("IO Error", e);
    }
    return dir;
  }

  // 创建文件
  public static boolean exists(String path, boolean isCreate) {
    File f = new File(path);
    boolean isexists = f.exists();
    if (!isexists && isCreate) {
      try {
        f.createNewFile();
      } catch (IOException e) {
        logger.error("IO Error", e);
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
//      logger.debug("read file content :");
//      logger.debug(key);
//      return key;
//    } catch (IOException e) {
//      logger.error("IO Error", e);
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
      logger.debug("read file content :");
      logger.debug(key);
      return key;
    } catch (IOException e) {
      logger.error("IO Error", e);
    } finally {
    }
    return key;
  }

  public static void writeFile(String content, String filePath) {
    try (FileWriter fw = new FileWriter(filePath)) {
      fw.write(content);
      fw.close();
      logger.info("file write finish :" + filePath);
    } catch (IOException e) {
      logger.error("IO Error", e);

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

  // nio
  public static boolean copyTo(String sourceFile, String destFile) {
    logger.info("begin cp file");
    logger.info("from " + sourceFile);
    logger.info("to " + destFile);
    try {
      File source = new File(sourceFile);
      File dest = new File(destFile);
      if (!dest.exists()) {
        dest.createNewFile();
      }
      FileInputStream fis = new FileInputStream(source);
      FileOutputStream fos = new FileOutputStream(dest);
      FileChannel sourceCh = fis.getChannel();
      FileChannel destCh = fos.getChannel();
      destCh.transferFrom(sourceCh, 0, sourceCh.size());
      sourceCh.close();
      destCh.close();
    } catch (IOException e) {
      logger.error("end cp file fail");
      logger.error(e.getMessage(),e);
      return false;
    }
    logger.info("end cp file success");
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
      logger.error("Problem writing" + fileDest + e.getMessage(), e);
      return false;
    }

    return true;
  }

  public final static String IMAGE_SUFFIX = ".jpg";//

  public static boolean createFile(File file) {
    return createFile(file, false);
  }

  public static boolean createFile(File file, boolean needMandatory) {
    if (needMandatory) {
      if (file.exists()) {
        file.delete();
      }
    } else {
      if (file.exists()) return true;
    }
    try {
      file.getParentFile().mkdirs();
      return file.createNewFile();

    } catch (Exception e) {
      logger.error("@shilei : " + e.getMessage(), e);
      return false;
    }

  }

  public static boolean createFile(String path) {
    return createFile(new File(path));
  }

  public static boolean existFile(String path) {
    return new File(path).exists();
  }

  public static File bufferedImage2ImageFile(BufferedImage bufferedImage, String imageSuffix) //throws SosException
  {
    try {
      if (bufferedImage == null) {
//				throw new SosException(MessageNo.MSG_20020);
      }
      // bufferedImage转换为file
      File fTemp = File.createTempFile(UUID.randomUUID().toString(), imageSuffix);
      // ImageIO.write(bufferedImage, ImageUtils.IMAGE_TYPE_JPEG, fTemp);
      ImageIO.write(bufferedImage, imageSuffix.substring(1, imageSuffix.length()), fTemp);
      return fTemp;
    } catch (Exception e) {
      logger.error(e.getMessage());
//			throw new SosException(MessageNo.MSG_20020);
    }
    return null;
  }

  /**
   *
   * @Title: getContentType
   * @Description: 根据文件路径获取文件ContentType类型
   * @param @param filePath
   * @param @return
   * @param @throws SosException    参数描述
   * @return String    返回类型描述
   * @throws
   */
  public static String getContentType(String filePath)// throws SosException
  {
    Path path = Paths.get(filePath);
    String contentType = "";
    try {
      contentType = Files.probeContentType(path);
      return contentType;
    } catch (IOException e) {
      logger.error(e.getMessage());
      //TODO 更换错误码
//			throw new SosException(MessageNo.MSG_10001);
    }
    return contentType;

  }
}
