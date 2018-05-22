package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Players extends ArrayList {
    @Override
    public boolean add(Object o) {
        boolean ans = super.add(o);
        System.out.println(o.toString() + " was added");
        System.out.println("They are player number " + this.size());
        return ans;
    }
}
