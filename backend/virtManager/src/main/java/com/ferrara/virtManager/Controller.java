package com.ferrara.virtManager;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    String dbUrl = "jdbc:postgresql://localhost/db?user=admin&password=1234&ssl=false";
    final String frontenddbUrl = "http://localhost:6969";

    @GetMapping("/")
    public String index(@RequestParam(value = "name", defaultValue = "Index") String name) {
        return String.format("Welcome to %s!", name);
    }

    @CrossOrigin(origins = frontenddbUrl)
    @GetMapping("/API/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Davide") String name) {
        return String.format("Ciao %s!", name);
    }

    @CrossOrigin(origins = frontenddbUrl)
    @GetMapping("/API/test")
    public Map<String, Object> jsontest() throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT now()");

        Map<String, Object> result = new HashMap<>();
        if (rs.next()) {
            result.put("current_time", rs.getString(1));
        }

        rs.close();
        st.close();
        conn.close();

        return result;
    }

    @CrossOrigin(origins = frontenddbUrl)
    @RequestMapping(method = RequestMethod.POST, value = "/API/signup/student")
    public void signup(@RequestBody Student student) {
        System.out.println(student);
    }

}
