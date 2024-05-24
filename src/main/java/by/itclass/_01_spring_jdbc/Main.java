package by.itclass._01_spring_jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Main {
    public static void main(String[] args) {
        //var datasource = new DriverManagerDataSource();
        var datasource = new SimpleDriverDataSource();
        datasource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        datasource.setUrl("jdbc:mysql://localhost:3306/po_2304");
        datasource.setUsername("root");
        datasource.setPassword("");

        var jdbcTemplate = new JdbcTemplate(datasource);

        var users = jdbcTemplate.query("SELECT id,fio,age FROM users", new UserRowMapping());
        users.forEach(System.out::println);

        System.out.println("_________________________________________________");
        var anna = jdbcTemplate.query("SELECT id,fio,age FROM users WHERE fio=?",
                new UserRowMapping(), new Object[]{"Анна Smith"}).get(0);
        System.out.println(anna);

        System.out.println("_________________________________________________");
        jdbcTemplate.update("UPDATE users SET fio = ? WHERE id = ?", "Анна Абрамович", 5);
        anna = jdbcTemplate.query("SELECT id,fio,age FROM users WHERE id=?",
                new UserRowMapping(), new Object[]{5}).get(0);
        System.out.println(anna);
    }
}
