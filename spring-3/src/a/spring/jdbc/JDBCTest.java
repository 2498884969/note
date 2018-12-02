package a.spring.jdbc;

import a.spring.jdbc.dao.EmployeeDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JDBCTest {


    /**
     * xml扫描出的包只能通过上下文的方式从依赖注入中获取对象
     */
    @Test
    public void testEmployeeDao(){
        EmployeeDao employeeDao = ctx.getBean(EmployeeDao.class);
        System.out.println(employeeDao.get(2));
    }

    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate = null;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
    }

    /**
     * 使用具名参数时
     * 1>.sql的参数名和类的属性一致
     * 2>.使用BeanPropertySqlParameterSource实现类，作为参数
     */
    @Test
    public void TestNamedParameterJdbcTemplate2(){
        String sql = "INSERT INTO employees(LAST_NAME,EMAIL,DEPT_ID) VALUES(:lastName,:email,:deptId)";

        Employee employee = new Employee();
        employee.setLastName("XYZ");
        employee.setEmail("xyz@163.com");
        employee.setDeptId(5);

        SqlParameterSource paraSource = new BeanPropertySqlParameterSource(employee);

        namedParameterJdbcTemplate.update(sql,paraSource);
    }

    /**
     * 可以为参数起名字
     * 好处：
     * 1.若有多个参数，不用去对参数位置
     * 坏处：
     * 较为麻烦
     */
    @Test
    public void TestNamedParameterJdbcTemplate(){
        String sql = "INSERT INTO employees(LAST_NAME,EMAIL,DEPT_ID) VALUES(:ln,:email,:deptid)";

        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("ln","FF");
        paraMap.put("email","ff@163.com");
        paraMap.put("deptid",6);

        namedParameterJdbcTemplate.update(sql,paraMap);
    }

    /**
     *  使用public <T> T queryForObject(String sql, Class<T> requiredType)获取单个列的值
     */
    @Test
    public void queryForObject2(){
        String sql = "SELECT COUNT(e.ID) FROM employees e";
        long count = jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(count);
    }

    /**
     * 执行批量更新可以是insert、update
     */
    @Test
    public void batchTestUpdate(){
        String sql = "INSERT INTO employees(LAST_NAME,EMAIL,DEPT_ID) VALUES(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"AA","AA@163.com",1});
        batchArgs.add(new Object[]{"BB","BB@163.com",2});
        batchArgs.add(new Object[]{"CC","CC@163.com",3});
        batchArgs.add(new Object[]{"DD","DD@163.com",4});
        batchArgs.add(new Object[]{"EE","EE@163.com",5});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }
    /**
     * 执行Insert,Update和Delete
     */
    @Test
    public void TestUpdate(){
        String sql = "UPDATE employees SET LAST_NAME=? WHERE ID=?";
        jdbcTemplate.update(sql,"hengheng",5);
    }

    @Test
    public void testDatasource(){
        DataSource dataSource = ctx.getBean(DataSource.class);
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从数据库中获取一条记录,实际得到对应的对象。
     * 不是调用queryForObject(String sql, Class<T> requiredType, Object... args)方法
     * 而需要调用queryForObject(String sql, RowMapper<T> rowMapper, Object... args)方法，
     * 1>.其中RowMapper指定如何去映射行，常见的实现类为BeanPropertyRowMapper
     * 2>.使用sql完成别名和属性名之间的映射，例如：e.LAST_NAME lastName
     * 3>.不支持级联属性jdbcTemplate是一个jdbc小工具，不是orm框架
     */
    @Test
    public void testQueryForObject(){
        String sql = "SELECT e.ID, e.LAST_NAME lastName, e.EMAIL FROM employees e WHERE e.ID=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,1);
        System.out.println(employee);
    }




    @Test
    public void testQueryForList(){
        String sql = "SELECT e.ID, e.LAST_NAME, e.EMAIL from employees e WHERE e.ID>?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employeeList = jdbcTemplate.query(sql,rowMapper,5);
        System.out.println(employeeList);
    }

}
