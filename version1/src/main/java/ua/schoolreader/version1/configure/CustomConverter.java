package ua.schoolreader.version1.configure;

import ua.schoolreader.version1.entity.Status;

import javax.persistence.AttributeConverter;

public class CustomConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status attribute)
    { if(attribute ==null){
        return null;
    }
        return attribute.getName();
    }

    @Override
    public Status convertToEntityAttribute(String dbData) {
        return  Status.valueOf(dbData);
    }

}