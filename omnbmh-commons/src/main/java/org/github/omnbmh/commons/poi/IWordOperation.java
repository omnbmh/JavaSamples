package org.github.omnbmh.commons.poi;

import java.util.Map;
import org.apache.poi.util.StringUtil;
import org.github.omnbmh.commons.utils.StringUtils;

/**
 * Created With IntelliJ IDEA CE
 *
 * Desc: Write Something!
 * <p>more info!</p>
 * @version 2017/4/12 下午7:38
 * @since 1.7
 */
public interface IWordOperation {


  /**
   * Created With IntelliJ IDEA CE
   *  Write Something!
   * <p>More Info!</p>
   * @param
   * @return
   * @throws
   * @version 2017/4/13 上午10:35
   * @since 1.7
   * */
  void loadFile(String filePath);

  /**
   * Created With IntelliJ IDEA CE
   *  替换变量
   * <p>${var}</p>
   * @param
   * @return
   * @throws
   * @version 2017/4/13 上午10:36
   * @since 1.7
   * */
  void replace(Map<String,Object> params);
  /**
   * Created With IntelliJ IDEA CE
   *  文件另存为
   * <p>More Info!</p>
   * @param
   * @return 生成的文件路径
   * @throws
   * @version 2017/4/13 上午10:13
   * @since 1.7
   * */
  String saveTo(String filePath);


  void  toHtml(String filePath);
}
