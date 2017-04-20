package org.github.omnbmh.commons.poi;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @author *_*
 * @version 2017/4/12 下午7:42
 * @since 1.7
 */
public class WordDocxOperation implements IWordOperation {

  private static Logger logger = Logger.getLogger(WordDocxOperation.class);

  private XWPFDocument docx;

  @Override
  public void loadFile(String filePath) {
    logger.info("加载文件 " + filePath);
    try {

      InputStream is = new FileInputStream(filePath);
      docx = new XWPFDocument(is);
      is.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void replace(Map<String, Object> params) {
    logger.info("替换变量");
    // 替换段落的变量
    Iterator<XWPFParagraph> iterator = docx.getParagraphsIterator();
    while (iterator.hasNext()) {
      XWPFParagraph xwpfParagraph = iterator.next();

      // 开始替换变量
      List<XWPFRun> runs;
      Matcher matcher;
      if (matcher(xwpfParagraph.getParagraphText()).find()) {
        logger.info("替换变量 命中 " + xwpfParagraph.getParagraphText());
        System.out.println("替换变量 命中 " + xwpfParagraph.getParagraphText());
        runs = xwpfParagraph.getRuns();
        for (int i = 0; i < runs.size(); i++) {
          XWPFRun run = runs.get(i);
          String runText = run.toString();
          matcher = matcher(runText);
          if (matcher.find()) {
            while ((matcher = matcher(runText)).find()) {
              logger.info("替换变量 命中" + runText);
              System.out.println("替换变量 命中" + runText);
              runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
              logger.info("替换变量 命中" + runText);
              System.out.println("替换变量 命中" + runText);

            }
            // 此处 使用 下面的代码 会有异常
            run.setText(runText, 0);

            //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
            //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
//            xwpfParagraph.removeRun(i);
//            xwpfParagraph.insertNewRun(i).setText(runText);

          }
        }
      }
    }

    replaceInTable(params);
  }

  @Override
  public String saveTo(String filePath) {
    logger.info("另存为文件 " + filePath);
    try {
      OutputStream os = new FileOutputStream(filePath);
      docx.write(os);
      os.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return filePath;
  }

  @Override
  public void toHtml(String filePath) {
    throw new RuntimeException();
  }

  private Matcher matcher(String str) {
    Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(str);
    return matcher;
  }

  /**
   * 替换表格里面的变量
   *
   * @param params 参数
   */
  private void replaceInTable(Map<String, Object> params) {
    Iterator<XWPFTable> iterator = docx.getTablesIterator();
    XWPFTable table;
    List<XWPFTableRow> rows;
    List<XWPFTableCell> cells;
    List<XWPFParagraph> paras;
    while (iterator.hasNext()) {
      table = iterator.next();
      rows = table.getRows();
      for (XWPFTableRow row : rows) {
        cells = row.getTableCells();
        for (XWPFTableCell cell : cells) {
          paras = cell.getParagraphs();
          for (XWPFParagraph para : paras) {
            replaceInPara(para, params);
          }
        }
      }
    }
  }

  /**
   * 替换段落里面的变量
   *
   * @param para 要替换的段落
   * @param params 参数
   */
  private void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
    List<XWPFRun> runs;
    Matcher matcher;
    if (this.matcher(para.getParagraphText()).find()) {
      runs = para.getRuns();
      for (int i = 0; i < runs.size(); i++) {
        XWPFRun run = runs.get(i);
        String runText = run.toString();
        matcher = this.matcher(runText);
        if (matcher.find()) {
          while ((matcher = this.matcher(runText)).find()) {
//            runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
            logger.info("替换变量 命中" + runText);
            System.out.println("替换变量 命中" + runText);
            runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
            logger.info("替换变量 命中" + runText);
            System.out.println("替换变量 命中" + runText);
          }
          //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
          //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
//          para.removeRun(i);
//          para.insertNewRun(i).setText(runText);
          run.setText(runText, 0);

        }
      }
    }
  }


}