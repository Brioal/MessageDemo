package com.brioal.messagedemo.entity;

/**
 * Created by Brioal on 2016/6/20.
 */

public class MessageEntity {
    private int mId ; //序号
    private String mContent ; //内容
    private int mType ; //类型 0 from 1 to

    public MessageEntity(int id,String content,  int type) {
        mContent = content;
        mId = id;
        mType = type;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }
}
