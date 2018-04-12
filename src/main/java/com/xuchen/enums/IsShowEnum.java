package com.xuchen.enums;

import java.util.HashMap;

public enum IsShowEnum {
    notShow(0,"不展示"),
    show(1,"展示");
    private int id;
    private String value;

    IsShowEnum(int id, String value){
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return this.id;
    }

    public String getValue() {
        return this.value;
    }

    public static HashMap<Integer,String> getMap(){
        HashMap<Integer,String> map=new HashMap<>();
        IsShowEnum[] values = values();
        for (IsShowEnum enums : values) {
            map.put(enums.id,enums.value);
        }
        return map;
    }

}
