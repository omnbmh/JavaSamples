package org.github.omnbmh.commons.tools;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import org.github.omnbmh.commons.utils.GsonTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: PDF工具
 * <p>基于itext处理PDF</p>
 *
 * @version 2017/4/19 上午11:38
 * @since 1.7
 */
public final class PdfTools {

  private static Logger logger = LoggerFactory.getLogger(PdfTools.class);

  public static void createPdfFromTemplate(String pdfTplPath, String pdfFilePath,
      Map<String, Object> params) {
    logger.info("PDF模版 - " + pdfTplPath);
    logger.info("PDF模版参数 - " + GsonTools.toJsonString(params));
    logger.info("PDF文件 - " + pdfFilePath);
    try(OutputStream fos = new FileOutputStream(pdfFilePath)) {
      String templateFileName = pdfTplPath; // pdf模板
      PdfReader reader = new PdfReader(templateFileName);
      ByteArrayOutputStream bos = new ByteArrayOutputStream();

      PdfStamper ps = new PdfStamper(reader, bos);
      AcroFields fields = ps.getAcroFields();
      fillData(fields, params);
      ps.setFormFlattening(true);
      ps.close();
      fos.write(bos.toByteArray());
      logger.info("PDF文件生成成功" + pdfFilePath);
    } catch (Exception e) {
      logger.error("PDF模版替换变量处理异常");
      logger.error(e.getMessage(), e);
    }
  }

  private static void fillData(AcroFields fields, Map<String, Object> data)
      throws IOException, DocumentException {
    for (String key : data.keySet()) {
      String value = (String) data.get(key);
      fields.setField(key, value);
    }
  }

}
