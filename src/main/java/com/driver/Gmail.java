package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    LinkedList<MAIL> inbox;
    LinkedList<MAIL> trash;
    String mailid;
    public Gmail(String emailId, int inboxCapacity) {
         super(emailId);
        this.inboxCapacity=inboxCapacity;
         this.mailid=emailId;
         inbox=new LinkedList<MAIL>();
        trash=new LinkedList<MAIL>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(inbox.size()==inboxCapacity)trash.add(inbox.removeFirst());
        inbox.addLast(new MAIL(date,sender,message));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(int i=0;i<inbox.size();i++){
            if(inbox.get(i).Message_==message)trash.addLast(inbox.remove(i));
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inbox.size()==0) return null;
        return inbox.get(inbox.size()-1).Message_;

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.size()==0) return null;
        return inbox.get(0).Message_;

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int ans=0;

        for(int i=0;i<inbox.size();i++){

            if(inbox.get(i).date.after(start) || inbox.get(i).date.compareTo(start)==0 && inbox.get(i).date.before(end) || inbox.get(i).date.compareTo(end)==0   )ans++;
        }
        return ans;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
       return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
class MAIL{
    Date date;
    String sender_id;
    String Message_;
    public MAIL(Date date,String sender_id,String Message_){
        this.date=date;
        this.sender_id=sender_id;
        this.Message_=Message_;
    }
}
class a{
    a(){
        System.out.println("0");
    }
}
