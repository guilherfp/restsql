package br.com.devsource.lab.restsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author guilherme.pacheco
 */
public class PathSqlMapper implements RowMapper<PathSql> {

  @Override
  public PathSql mapRow(ResultSet rs, int rowNum) throws SQLException {
    RequestMethod method = RequestMethod.valueOf(rs.getString("method"));
    String script = rs.getString("script");
    String path = rs.getString("path");
    boolean list = rs.getBoolean("list");
    PathSql pathSql = new PathSql(path, method, script);
    List<String> params = params(rs);
    pathSql.setParams(params);
    pathSql.setList(list);
    return pathSql;
  }

  private List<String> params(ResultSet rs) throws SQLException {
    String params = ObjectUtils.defaultIfNull(rs.getString("params"), "");
    return Arrays.asList(StringUtils.split(params, ','));
  }

}
