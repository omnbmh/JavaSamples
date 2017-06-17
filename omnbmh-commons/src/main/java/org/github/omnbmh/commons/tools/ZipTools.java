package org.github.omnbmh.commons.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.log4j.Logger;

/**
 * Created With IntelliJ IDEA CE
 * Desc: 使用 JDK 压缩和解压 zip!
 *
 * 2017/5/26 下午6:59
 */
public final class ZipTools {

  private static Logger logger = Logger.getLogger(ZipTools.class);

  public static void zip(String zipFileName, File inputFile) throws Exception {
    logger.info("Compressing...");
    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
        zipFileName));
    BufferedOutputStream bo = new BufferedOutputStream(out);
    zip(out, inputFile, inputFile.getName(), bo);
    bo.close();
    out.close(); // 输出流关闭
    logger.info("Compressing Finish");
  }

  private static void zip(ZipOutputStream out, File f, String base,
      BufferedOutputStream bo) throws Exception { // 方法重载
    if (f.isDirectory()) {
      File[] fl = f.listFiles();
      if (fl.length == 0) {
        out.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base
        logger.info(base + "/");
      }
      for (int i = 0; i < fl.length; i++) {
        zip(out, fl[i], base + "/" + fl[i].getName(), bo); // 递归遍历子文件夹
      }
//      System.out.println("第" + k + "次递归");
//      k++;
    } else {
      out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base
      logger.info(base);
      FileInputStream in = new FileInputStream(f);
      BufferedInputStream bi = new BufferedInputStream(in);
      int b;
      while ((b = bi.read()) != -1) {
        bo.write(b); // 将字节流写入当前zip目录
      }
      bi.close();
      in.close(); // 输入流关闭
    }
  }

  public static  void  unzip(String zipfile,String destPath){
    long startTime=System.currentTimeMillis();
    try {
      ZipInputStream Zin=new ZipInputStream(new FileInputStream(
          zipfile));//输入源zip路径
      BufferedInputStream Bin=new BufferedInputStream(Zin);
      String Parent=destPath; //输出路径（文件夹目录）
      File Fout=null;
      ZipEntry entry;
      try {
        while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){
          Fout=new File(Parent,entry.getName());
          if(!Fout.exists()){
            (new File(Fout.getParent())).mkdirs();
          }
          FileOutputStream out=new FileOutputStream(Fout);
          BufferedOutputStream Bout=new BufferedOutputStream(out);
          int b;
          while((b=Bin.read())!=-1){
            Bout.write(b);
          }
          Bout.close();
          out.close();
          logger.info(Fout+"UnCompressing Finish");
        }
        Bin.close();
        Zin.close();
      } catch (IOException e) {
        logger.error(e.getMessage(),e);
      }
    } catch (FileNotFoundException e) {
      logger.error(e.getMessage(),e);
    }
    long endTime=System.currentTimeMillis();
    logger.info("耗费时间： "+(endTime-startTime)+" ms");
  }

}
