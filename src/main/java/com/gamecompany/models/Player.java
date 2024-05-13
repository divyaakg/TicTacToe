package com.gamecompany.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Player {
    private String mark;
    private String name;

    public Player(String n, String m) {
        name=n;
        mark=m;
    }

    public String toString(){
        return mark+","+name;
    }
}
