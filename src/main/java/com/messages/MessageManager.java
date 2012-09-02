package com.messages;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

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
    @Inject
    private MessageService service;

    /**
     * <p>
     * JSF form action that 'posts' messages through MessageService.
     * </p>
     */
    public String post() {
        message.setTimeStamp(new Date());
        service.saveMessage(message);
        return "messages?faces-redirect=true";
    }

    /**
     * <p>
     * Managed bean method for retrieving the list of messages.
     * </p>
     */
    public List<Message> getList() {
        return service.loadMessageList();
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
