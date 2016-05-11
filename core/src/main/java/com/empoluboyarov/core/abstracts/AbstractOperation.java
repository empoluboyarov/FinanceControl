package com.empoluboyarov.core.abstracts;

import java.util.Calendar;

/**
 * Created by Evgeniy on 11.05.2016.
 */
public abstract class AbstractOperation {

    private long id;
    private Calendar dateTime;
    private String addInfo;

    public AbstractOperation() {
    }

    public AbstractOperation(long id) {
        this.id = id;
    }

    public AbstractOperation(String addInfo, Calendar dateTime, long id) {
        this.addInfo = addInfo;
        this.dateTime = dateTime;
        this.id = id;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
