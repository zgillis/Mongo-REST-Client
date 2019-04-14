package com.zgillis.mongorest;

import lombok.Data;

@Data
public class DocumentField {

    private String key;
    private Object value;

    public DocumentField(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}
