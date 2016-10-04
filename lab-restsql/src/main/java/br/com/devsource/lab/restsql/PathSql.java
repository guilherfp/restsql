package br.com.devsource.lab.restsql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author guilherme.pacheco
 */
public class PathSql {

  private String path;
  private List<String> params;
  private RequestMethod method;
  private String script;
  private boolean list;

  public PathSql(String path, RequestMethod method, String script) {
    params = new ArrayList<>();
    this.method = method;
    this.script = script;
    this.path = path;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public List<String> getParams() {
    return params;
  }

  public void setParams(List<String> params) {
    this.params = params;
  }

  public RequestMethod getMethod() {
    return method;
  }

  public void setMethod(RequestMethod method) {
    this.method = method;
  }

  public String getScript() {
    return script;
  }

  public void setScript(String script) {
    this.script = script;
  }

  public boolean isList() {
    return list;
  }

  public void setList(boolean list) {
    this.list = list;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (method == null ? 0 : method.hashCode());
    result = prime * result + (path == null ? 0 : path.hashCode());
    result = prime * result + (script == null ? 0 : script.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    PathSql other = (PathSql) obj;
    if (method != other.method) {
      return false;
    }
    if (path == null) {
      if (other.path != null) {
        return false;
      }
    } else if (!path.equals(other.path)) {
      return false;
    }
    if (script == null) {
      if (other.script != null) {
        return false;
      }
    } else if (!script.equals(other.script)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    String format = "PathSql [path=%s, params=%s, method=%s, script=%s]";
    return String.format(format, path, params, method, script);
  }

}
