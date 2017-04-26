package edu.hzuapps.androidlabs.homeworks.net1412070501227;

/**
 * 一个订单类，定义的变量均为订单的内容
 */

public class orders {
     private int id;
     public String price,standard;
     public String sendname,senderphone,sendaddress;
     public String receivename,receivephone,receiveaddress;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getPrice() {
          return price;
     }

     public void setPrice(String price) {
          this.price = price;
     }

     public String getStandard() {
          return standard;
     }

     public void setStandard(String standard) {
          this.standard = standard;
     }

     public String getSendname() {
          return sendname;
     }

     public void setSendname(String sendname) {
          this.sendname = sendname;
     }

     public String getSenderphone() {
          return senderphone;
     }

     public void setSenderphone(String senderphone) {
          this.senderphone = senderphone;
     }

     public String getSendaddress() {
          return sendaddress;
     }

     public void setSendaddress(String sendaddress) {
          this.sendaddress = sendaddress;
     }

     public String getReceivename() {
          return receivename;
     }

     public void setReceivename(String receivename) {
          this.receivename = receivename;
     }

     public String getReceivephone() {
          return receivephone;
     }

     public void setReceivephone(String receivephone) {
          this.receivephone = receivephone;
     }

     public String getReceiveaddress() {
          return receiveaddress;
     }

     public void setReceiveaddress(String receiveaddress) {
          this.receiveaddress = receiveaddress;
     }
}
