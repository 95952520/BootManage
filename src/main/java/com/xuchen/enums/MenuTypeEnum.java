package com.xuchen.enums;

import java.util.HashMap;

public enum MenuTypeEnum {
    parentMenu(0,"父级"),
    sonMenu(1,"子级");
    private int id;
    private String value;

    MenuTypeEnum(int id, String value){
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
        MenuTypeEnum[] values = values();
        for (MenuTypeEnum enums : values) {
            map.put(enums.id,enums.value);
        }
        return map;
    }

}
