package com.brioal.messagedemo.util;

import com.brioal.messagedemo.entity.MessageEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brioal on 2016/6/20.
 */

public class DataLoader {
    public static List<MessageEntity> getMessages() {
        List<MessageEntity> list = new ArrayList<>();
        list.add(new MessageEntity(0, "我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我", 1));
        list.add(new MessageEntity(0, "你你你你你你你你你你你你你你", 0));
        list.add(new MessageEntity(0, "我我我我我我我我我我", 1));
        list.add(new MessageEntity(0, "你你你你你你你你你你你你你", 0));
        list.add(new MessageEntity(0, "我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我", 1));
        return list;
    }
}
