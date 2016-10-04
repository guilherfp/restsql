package br.com.devsource.lab.restsql;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guilherme.pacheco
 */
@RestController
@RequestMapping({"/rest", "/rest/"})
public class RestSqlResource {

  @Autowired
  private DataService dataService;

  @RequestMapping(value = {"/{path}"}, method = {PUT, POST})
  public Object postPut(@PathVariable String path, HttpServletRequest request,
      @RequestBody Map<String, Object> body, @RequestParam Map<String, Object> params) {
    Map<String, Object> paramMap = RestSqlUtils.union(body, params);
    return dataService.query(path, request.getMethod(), paramMap);
  }

  @RequestMapping(value = {"/{path}"}, method = {GET})
  public Object get(@PathVariable String path, HttpServletRequest request,
      @RequestParam Map<String, Object> paramMap) {
    return dataService.query(path, request.getMethod(), paramMap);
  }

  @RequestMapping(value = {"/{path}"}, method = {DELETE})
  public void delete(@PathVariable String path, HttpServletRequest request,
      @RequestParam Map<String, Object> paramMap) {
    dataService.execute(path, request.getMethod(), paramMap);
  }

}
