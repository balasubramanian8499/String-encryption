package com.demo.stringencryption.encryption;

import jakarta.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;

public class AttributeEncryptor implements AttributeConverter<String,String> {

    @Autowired
    private DBHashingUtil dbHashingUtil;

    @Override
    public String convertToDatabaseColumn(String data) {
        return dbHashingUtil.encrypt(data);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbHashingUtil.decrypt(dbData);
    }

}
