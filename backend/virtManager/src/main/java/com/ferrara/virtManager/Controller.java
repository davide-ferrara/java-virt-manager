package com.ferrara.virtManager;

import org.apache.catalina.connector.Response;
import org.apache.catalina.security.TLSCertificateReloadListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    final String DbUrl = "jdbc:postgresql://localhost/db?user=admin&password=1234&ssl=false";
    // final String frontendDbUrl = "http://localhost:6969";
    final String frontendDbUrl = "http://localhost:8080";

    @GetMapping("/")
    public String index(@RequestParam(value = "name", defaultValue = "Index") String name) {
        return String.format("Welcome to %s!", name);
    }

    @CrossOrigin(origins = frontendDbUrl)
    @GetMapping("/api/hello")
    public String hello(@RequestParam(value = "name") String name, @RequestParam(value = "lastname") String lastname) {
        return String.format("Ciao %s %s!", name, lastname);
    }

    @CrossOrigin(origins = frontendDbUrl)
    @RequestMapping(method = RequestMethod.POST, value = "/api/signup/student")
    public void signup(@RequestBody Student student) {
        System.out.println(student);
    }

    @CrossOrigin(origins = frontendDbUrl)
    @GetMapping("/api/q")
    public ResponseEntity<Object> query(@RequestParam(value = "id", required = true) int id) throws SQLException {
        String query = String.format(
                "SELECT json_agg(row_to_json(t)) AS result FROM (SELECT * FROM public.\"Person\" WHERE id=%d) t", id);

        return this.dbRequest(query);

    }

    public ResponseEntity<Object> dbRequest(String query) throws SQLException {

        try (Connection conn = DriverManager.getConnection(DbUrl)) {

            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                ObjectMapper mapper = new ObjectMapper();
                while (rs.next()) {
                    String jsonResult = rs.getString("result");

                    JsonNode jsonNode = mapper.readTree(jsonResult);
                    return ResponseEntity.ok(jsonNode);
                }
            } catch (SQLException e) {
                return ResponseEntity.status(500).body(e.toString());
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.toString());
        }

        return ResponseEntity.status(404).body("No result");
    }
}
