package org.github.omnbmh.commons.tools;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.tool.xml.XMLWorkerHelper;
import fr.opensagres.xdocreport.itext.extension.IPdfWriterConfiguration;
import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.github.omnbmh.commons.WordFactory;
import org.github.omnbmh.commons.poi.IWordOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.jsoup.Jsoup;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Word工具类!
 * <p>支持 doc docx<p/>
 */
public final class WordTools {

  private static Logger logger = LoggerFactory.getLogger(WordTools.class);

  public static boolean replace(String filePath, String newFilePath, Map<String, Object> params) {
    String wordType = FileTools.getExtensionName(filePath);
    logger.info("即将处理文件 " + filePath + " 文件类型 " + wordType);
    IWordOperation wordOpt = WordFactory.getWordOperation(wordType);
    // 加载文件
    wordOpt.loadFile(filePath);
    // 替换变量
    wordOpt.replace(params);
    // 保存 或者 另存为
    wordOpt.saveTo(newFilePath);

//    wordOpt.
    return true;
  }

  private static HWPFDocument loadDocx(String filePath) {
    try {
      InputStream is = new FileInputStream(filePath);
      HWPFDocument doc = new HWPFDocument(is);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  private static void printWorgInfo(String filePath) {
    HWPFDocument hwpfd = loadDocx(filePath);

  }

//  public static boolean toPDF(String wordFilePath, String pdfFilePath) {
//    OutputStream os = null;
//    try {
//      WordprocessingMLPackage mlPackage = WordprocessingMLPackage.load(new File(wordFilePath));
//      //Mapper fontMapper = new BestMatchingMapper();
////      PhysicalFonts.addPhysicalFonts("SimSun", PathTools.getResource("/SIMSUN.TTC"));
//
//      Mapper fontMapper = new IdentityPlusMapper();
//      fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
//      fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
//      fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
////      fontMapper.put("SimSun", PhysicalFonts.get("SimSun"));
//
//      mlPackage.setFontMapper(fontMapper);
//      os = new java.io.FileOutputStream(pdfFilePath);
//      FOSettings foSettings = Docx4J.createFOSettings();
//      foSettings.setWmlPackage(mlPackage);
//      Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
//
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    } finally {
//      IOUtils.closeQuietly(os);
//    }
//    return true;
//  }

  //
  public static boolean toPDF(String wordFilePath, String pdfFilePath) {
    try {
      FileInputStream fs = new FileInputStream(wordFilePath);
      XWPFDocument doc = new XWPFDocument(fs);
      //72 units=1 inch
      Document pdfdoc = new Document(PageSize.A4, 72, 72, 72, 72);
      //设置中文字体
      BaseFont bfChinese = BaseFont
          .createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
      Font font = new Font(bfChinese);
      PdfWriter pwriter = PdfWriter.getInstance(pdfdoc, new FileOutputStream(pdfFilePath));
      //specify the vertical space between the lines of text
      pwriter.setInitialLeading(20);
      //open pdf document for writing
      pdfdoc.open();

      //get all paragraphs from word docx
//      List<XWPFParagraph> plist = doc.getParagraphs();
//
//      for (int i = 0; i < plist.size(); i++) {
//        //read through the list of paragraphs
//        XWPFParagraph pa = plist.get(i);
//        pdfdoc.add(copyparagraph(pa, font));
//        //output new line
//        pdfdoc.add(new Chunk(Chunk.NEWLINE));
//      }

      Iterator<IBodyElement> belist = doc.getBodyElementsIterator();
      while (belist.hasNext()) {
        IBodyElement ibe = belist.next();
        if (ibe instanceof XWPFParagraph) {
          System.out.println("is XWPFParagraph");
          pdfdoc.add(copyparagraph((XWPFParagraph) ibe, font));
          //output new line
          pdfdoc.add(new Chunk(Chunk.NEWLINE));
        }
        if (ibe instanceof XWPFTable) {
          System.out.println("is XWPFTable");
          pdfdoc.add(copytable((XWPFTable) ibe, font));
          //output new line
          pdfdoc.add(new Chunk(Chunk.NEWLINE));
        }

      }
      //close pdf document
      pdfdoc.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return true;
  }

  private static Paragraph copyparagraph(XWPFParagraph docxParagragh, Font font)
      throws UnsupportedEncodingException {
    Paragraph pdfParagragh = new Paragraph();
    if (1 == docxParagragh.getAlignment().getValue()) {
      pdfParagragh.setAlignment(Element.ALIGN_LEFT);
    } else if (2 == docxParagragh.getAlignment().getValue()) {
      pdfParagragh.setAlignment(Element.ALIGN_CENTER);
    } else if (3 == docxParagragh.getAlignment().getValue()) {
      pdfParagragh.setAlignment(Element.ALIGN_RIGHT);
    } else {
      pdfParagragh.setAlignment(Element.ALIGN_LEFT);
    }
//    System.out.println("alignment "+docxParagragh.getAlignment().getValue());
    List<XWPFRun> runs = docxParagragh.getRuns();
    //read through the run objects
    for (int j = 0; j < runs.size(); j++) {
      XWPFRun run = runs.get(j);
      //construct unicode string
      String text = run.getText(-1);
      byte[] bs;
      if (text != null) {
        bs = text.getBytes();
        String str = new String(bs, "UTF-8");
        //add string to the pdf document
        Chunk chunk = new Chunk(str, font);
        Phrase phrase = new Phrase(chunk);
        pdfParagragh.add(phrase);
      }
    }
    return pdfParagragh;
  }

  private static PdfPTable copytable(XWPFTable docxTable, Font font)
      throws UnsupportedEncodingException {
    PdfPTable pdfPTable = new PdfPTable(docxTable.getColBandSize());
    Paragraph pdfParagragh = new Paragraph();
    String text = docxTable.getText();
    byte[] bs;
    if (text != null) {
      bs = text.getBytes();
      String str = new String(bs, "UTF-8");
      //add string to the pdf document
      Chunk chunk = new Chunk(str, font);
      Phrase phrase = new Phrase(chunk);
      pdfParagragh.add(phrase);
      pdfPTable.addCell(phrase);
    }
    return pdfPTable;
  }

  public static void toPDF2(String wordFilePath, String pdfFilePath) {
    try {
      InputStream is = new FileInputStream(wordFilePath);
      XWPFDocument document = new XWPFDocument(is);
      PdfOptions pdfOptions = PdfOptions.create();
      pdfOptions.setConfiguration(new IPdfWriterConfiguration() {
        @Override
        public void configure(com.lowagie.text.pdf.PdfWriter pdfWriter) {
          pdfWriter.setPdfVersion(com.lowagie.text.pdf.PdfWriter.PDF_VERSION_1_7);
        }
      });
      pdfOptions.fontProvider(new IFontProvider() {
        @Override
        public com.lowagie.text.Font getFont(String s, String s1, float v, int i, Color color) {
//          BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
          try {
            com.lowagie.text.pdf.BaseFont bfChinese = com.lowagie.text.pdf.BaseFont
                .createFont("STSong-Light", "UniGB-UCS2-H",
                    com.lowagie.text.pdf.BaseFont.NOT_EMBEDDED);
            com.lowagie.text.Font fff = new com.lowagie.text.Font(bfChinese, v, i, color);
            return fff;
          } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
          } catch (com.lowagie.text.DocumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
          }
          return null;
        }
      });
//      pdfOptions.setConfiguration();

      PdfConverter.getInstance().convert(document, new FileOutputStream(pdfFilePath), pdfOptions);
    } catch (Exception e) {
      e.printStackTrace();
    }

//    String k = null;
//    OutputStream fileForPdf = null;
//    try {
//
//      String fileName = wordFilePath;
//      //Below Code is for .doc file
//      if (fileName.endsWith(".doc")) {
//        HWPFDocument doc = new HWPFDocument(new FileInputStream(
//            fileName));
//        WordExtractor we = new WordExtractor(doc);
//        k = we.getText();
//
//        fileForPdf = new FileOutputStream(new File(
//            pdfFilePath));
//        we.close();
//      }
//
//      //Below Code for
//
//      else if (fileName.endsWith(".docx")) {
//        XWPFDocument docx = new XWPFDocument(new FileInputStream(
//            fileName));
//        // using XWPFWordExtractor Class
//        XWPFWordExtractor we = new XWPFWordExtractor(docx);
//        k = we.getText();
//
//        fileForPdf = new FileOutputStream(new File(
//            pdfFilePath));
//        we.close();
//      }
////设置字体
//      BaseFont bfChinese = BaseFont
//          .createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//      Font font = new Font(bfChinese);
//      Document document = new Document();
//      PdfWriter.getInstance(document, fileForPdf);
//
//      document.open();
//
//      document.add(new Paragraph(k, font));
//
//      document.close();
//      fileForPdf.close();
//
//
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
  }
}

