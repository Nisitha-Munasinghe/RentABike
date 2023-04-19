package lk.ijse.rentabike.dto.tm;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;



public class AttendenceTm {
    private String attendenceId;
    private String attendencedate;
    private String holidayOrWorkedday;
    private String attendenceSignInTime;
    private String attendenceSignOutTime;
    private String employeeId;

    public AttendenceTm() {
    }

    public AttendenceTm(String attendenceId, String attendencedate, String holidayOrWorkedday, String attendenceSignInTime, String attendenceSignOutTime, String employeeId) {
        this.attendenceId = attendenceId;
        this.attendencedate = attendencedate;
        this.holidayOrWorkedday = holidayOrWorkedday;
        this.attendenceSignInTime = attendenceSignInTime;
        this.attendenceSignOutTime = attendenceSignOutTime;
        this.employeeId = employeeId;
    }

    public String getAttendenceId() {
        return attendenceId;
    }

    public void setAttendenceId(String attendenceId) {
        this.attendenceId = attendenceId;
    }

    public String getAttendencedate() {
        return attendencedate;
    }

    public void setAttendencedate(String attendencedate) {
        this.attendencedate = attendencedate;
    }

    public String getHolidayOrWorkedday() {
        return holidayOrWorkedday;
    }

    public void setHolidayOrWorkedday(String holidayOrWorkedday) {
        this.holidayOrWorkedday = holidayOrWorkedday;
    }

    public String getAttendenceSignInTime() {
        return attendenceSignInTime;
    }

    public void setAttendenceSignInTime(String attendenceSignInTime) {
        this.attendenceSignInTime = attendenceSignInTime;
    }

    public String getAttendenceSignOutTime() {
        return attendenceSignOutTime;
    }

    public void setAttendenceSignOutTime(String attendenceSignOutTime) {
        this.attendenceSignOutTime = attendenceSignOutTime;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "AttendenceTm{" +
                "attendenceId='" + attendenceId + '\'' +
                ", attendencedate='" + attendencedate + '\'' +
                ", holidayOrWorkedday='" + holidayOrWorkedday + '\'' +
                ", attendenceSignInTime='" + attendenceSignInTime + '\'' +
                ", attendenceSignOutTime='" + attendenceSignOutTime + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
