package br.com.devsource.lab.restsql;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author guilherme.pacheco
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Import(InfraConfigTest.class)
public class PathSqlRepositoryTest {

  @Autowired
  private PathSqlRepository pathSqlRepository;

  @Test
  public void testGetPathSql() throws Exception {
    Optional<PathSql> pathSql = pathSqlRepository.getPathSql("/usuarios", "GET");
    assertThat(pathSql).isNotNull();
    assertThat(pathSql).isPresent();
    assertThat(pathSql.get().getPath()).isEqualTo("/usuarios");
    assertThat(pathSql.get().getMethod()).isEqualTo(RequestMethod.GET);
    assertThat(pathSql.get().getParams()).isEmpty();
  }

  @Test
  public void testGetPathSql_WithParam() throws Exception {
    Optional<PathSql> pathSql = pathSqlRepository.getPathSql("/usuarios", "GET", asList("id"));
    assertThat(pathSql).isNotNull();
    assertThat(pathSql).isPresent();
    assertThat(pathSql.get().getPath()).isEqualTo("/usuarios");
    assertThat(pathSql.get().getMethod()).isEqualTo(RequestMethod.GET);
    assertThat(pathSql.get().getParams()).contains("id");
  }

}
