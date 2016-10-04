package br.com.devsource.lab.restsql;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author guilherme.pacheco
 */
@Service
public class DataService {

  private final NamedParameterJdbcTemplate template;
  private final PathSqlRepository repository;

  @Autowired
  public DataService(DataSource dataSource, PathSqlRepository repository) {
    template = new NamedParameterJdbcTemplate(dataSource);
    this.repository = repository;
  }

  public void execute(String path, String method, Map<String, Object> paramMap) {
    Optional<PathSql> pathSql = pathSql(path, method, paramMap);
    if (pathSql.isPresent()) {
      template.update(pathSql.get().getScript(), paramMap);
    }
  }

  public Object query(String path, String method, Map<String, Object> paramMap) {
    Optional<PathSql> pathSql = pathSql(path, method, paramMap);
    if (pathSql.isPresent()) {
      return execute(pathSql.get(), paramMap);
    } else {
      return null;
    }
  }

  private Object execute(PathSql pathSql, Map<String, Object> paramMap) {
    if (pathSql.isList()) {
      return list(pathSql, paramMap);
    } else {
      return query(pathSql, paramMap);
    }
  }

  private List<Map<String, Object>> list(PathSql pathSql, Map<String, Object> paramMap) {
    try {
      return template.queryForList(pathSql.getScript(), paramMap);
    } catch (DataAccessException ex) {
      return Collections.emptyList();
    }
  }

  private Map<String, Object> query(PathSql pathSql, Map<String, Object> paramMap) {
    try {
      return template.queryForMap(pathSql.getScript(), paramMap);
    } catch (DataAccessException ex) {
      return Collections.emptyMap();
    }
  }

  private Optional<PathSql> pathSql(String path, String method, Map<String, Object> paramMap) {
    String pathFormat = RestSqlUtils.formatPath(path);
    return repository.getPathSql(pathFormat, method, paramMap.keySet());
  }

}
