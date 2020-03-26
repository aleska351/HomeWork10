package com.company;

import java.util.Date;
import java.util.Objects;

public class CallLog {
    public String remotePhoneNumber;
    public int duration;
    public Date startDate;

    public CallLog(String remotePhoneNumber, int duration, Date startDate) {
        this.remotePhoneNumber = remotePhoneNumber;
        this.duration = duration;
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CallLog)) return false;
        CallLog callLog = (CallLog) o;
        return duration == callLog.duration &&
                remotePhoneNumber.equals(callLog.remotePhoneNumber) &&
                startDate.equals(callLog.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remotePhoneNumber, duration, startDate);
    }

    @Override
    public String toString() {
        return "CallLog{" +
                "remotePhoneNumber='" + remotePhoneNumber + '\'' +
                ", duration=" + duration +
                ", startDate=" + startDate +
                '}';
    }
}
