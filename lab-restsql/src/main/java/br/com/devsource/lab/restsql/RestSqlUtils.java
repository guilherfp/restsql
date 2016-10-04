package br.com.devsource.lab.restsql;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author guilherme.pacheco
 */
public final class RestSqlUtils {

  private RestSqlUtils() {
    super();
  }

  public static Map<String, Object> union(Map<String, Object> map1, Map<String, Object> map2) {
    Map<String, Object> union = new HashMap<>(map1);
    union.putAll(map2);
    return union;
  }

  public static String formatPath(String path) {
    return StringUtils.prependIfMissing(path, "/");
  }

}
