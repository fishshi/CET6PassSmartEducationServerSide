package com.smarteducationserverside.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户能力类
 */
@AllArgsConstructor
@Data
public class UserAbility {
    private int id;
    private String username;
    private byte ability1;
    private byte ability2;
    private byte ability3;
    private byte ability4;
    private byte ability5;
    private byte ability6;

    public UserAbility(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public List<Byte> toArrayList() {
        List<Byte> list = new ArrayList<>();
        list.add(ability1);
        list.add(ability2);
        list.add(ability3);
        list.add(ability4);
        list.add(ability5);
        list.add(ability6);
        return list;
    }

    public void setAbility(List<Byte> list) {
        ability1 = list.get(0);
        ability2 = list.get(1);
        ability3 = list.get(2);
        ability4 = list.get(3);
        ability5 = list.get(4);
        ability6 = list.get(5);
    }
}