package com.demo.stringencryption.encryption;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

@Component
public class DBHashingUtil {

    private final JdbcTemplate jdbcTemplate;

    public DBHashingUtil(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String encrypt(String data) {
        if (!data.isEmpty()) {
            String query = "SELECT HEX(AES_ENCRYPT(?, ?)) AS encrypted_data_hex";
            return jdbcTemplate.queryForObject(query, String.class, data, "1234");
        }
        return "input data not found";
    }

    public String decrypt(String encryptedData) {
        if (!encryptedData.isEmpty()) {
            String query = "SELECT CONVERT(AES_DECRYPT(UNHEX(?),?) USING utf8) AS decrypted_data";
            return jdbcTemplate.queryForObject(query, String.class, encryptedData, "1234");
        }
        return "encryptedData data not found";
    }

}
