package org.github.omnbmh.commons;

import org.github.omnbmh.commons.poi.IWordOperation;
import org.github.omnbmh.commons.poi.WordDocOperation;
import org.github.omnbmh.commons.poi.WordDocxOperation;
import org.github.omnbmh.commons.utils.StringUtils;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 *
 * @version 2017/4/12 下午7:37
 * @since 1.7
 */
public final class WordFactory {

  public static IWordOperation getWordOperation(String wordType) {
    if (StringUtils.isEmpty(wordType)) {
      return new WordDocOperation();
    }
    switch (wordType) {
      case "docx":
        return new WordDocxOperation();
      case "doc":
      default:
        return new WordDocOperation();
    }


  }
}
