package br.com.devsource.lab.restsql;

import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.Test;

public class RestSqlUtilsTest {

  @Test
  public void testUnion() throws Exception {
    Map<String, Object> map1 = singletonMap("a", 1);
    Map<String, Object> map2 = singletonMap("b", 2);
    Map<String, Object> result = RestSqlUtils.union(map1, map2);
    assertThat(result).containsEntry("a", 1);
    assertThat(result).containsEntry("b", 2);

  }

  @Test
  public void testFormatPath() throws Exception {
    assertThat("/teste").isEqualTo(RestSqlUtils.formatPath("teste"));
  }

  @Test
  public void testFormatPath_ComBarra() throws Exception {
    assertThat("/teste").isEqualTo(RestSqlUtils.formatPath("/teste"));
  }

}
