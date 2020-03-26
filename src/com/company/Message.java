package com.company;

import java.util.Date;
import java.util.Objects;

public class Message {
    public String remotePhoneNumber;
    public String textMassage;
    public Date startDate;

    public Message(String remotePhoneNumber, String textMassage, Date startDate) {
        this.remotePhoneNumber = remotePhoneNumber;
        this.textMassage = textMassage;
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return remotePhoneNumber.equals(message.remotePhoneNumber) &&
                textMassage.equals(message.textMassage) &&
                startDate.equals(message.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remotePhoneNumber, textMassage, startDate);
    }

    @Override
    public String toString() {
        return "Message{" +
                "remotePhoneNumber='" + remotePhoneNumber + '\'' +
                ", textMassage='" + textMassage + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
