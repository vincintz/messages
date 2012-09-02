package com.messages;

import java.util.Date;

import javax.faces.bean.ManagedBean;

/**
 * <p>
 * JSF backing bean for messages.xhtml
 * </p>
 * 
 * @author theo
 */
@ManagedBean
public class MessageManager {
    private Message message = new Message();

    public String post() {
        message.setTimeStamp(new Date());
//        service.saveMessage(message);
        return "messages?faces-redirect=true";
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
