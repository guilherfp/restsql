package br.com.devsource.lab.restsql;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author guilherme.pacheco
 */
@Repository
public class PathSqlRepository {

  private JdbcTemplate template;
  private PathSqlMapper mapper;

  @Autowired
  public PathSqlRepository(DataSource dataSource) {
    template = new JdbcTemplate(dataSource);
    mapper = new PathSqlMapper();
  }

  public Optional<PathSql> getPathSql(String path, String method) {
    return getPathSql(path, method, Collections.emptyList());
  }

  public Optional<PathSql> getPathSql(String path, String method, Collection<String> params) {
    try {
      String sql = "select * from path_sql where path = ? and method = ?";
      List<PathSql> paths = template.query(sql, mapper, path, method);
      return paths.stream().filter(withParams(params)).findFirst();
    } catch (DataAccessException ex) {
      return Optional.empty();
    }
  }

  private Predicate<? super PathSql> withParams(Collection<String> params) {
    return p -> p.getParams().containsAll(params);
  }

}
