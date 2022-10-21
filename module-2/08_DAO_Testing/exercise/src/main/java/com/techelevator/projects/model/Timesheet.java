package com.techelevator.projects.model;

import java.time.LocalDate;
import java.util.Objects;

public class Timesheet {
    private int timesheetId;
    private int employeeId;
    private int projectId;
    private LocalDate dateWorked;
    private double hoursWorked;
    private boolean billable;
    private String description;

    public Timesheet() {}

    public Timesheet(int timesheetId, int employeeId, int projectId, LocalDate dateWorked, double hoursWorked,
                     boolean billable, String description) {
        this.timesheetId = timesheetId;
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.dateWorked = dateWorked;
        this.hoursWorked = hoursWorked;
        this.billable = billable;
        this.description = description;
    }

    public int getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(int timesheetId) {
        this.timesheetId = timesheetId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LocalDate getDateWorked() {
        return dateWorked;
    }

    public void setDateWorked(LocalDate dateWorked) {
        this.dateWorked = dateWorked;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timesheet timesheet = (Timesheet) o;
        return timesheetId == timesheet.timesheetId && employeeId == timesheet.employeeId && projectId == timesheet.projectId && Double.compare(timesheet.hoursWorked, hoursWorked) == 0 && billable == timesheet.billable && Objects.equals(dateWorked, timesheet.dateWorked) && Objects.equals(description, timesheet.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timesheetId, employeeId, projectId, dateWorked, hoursWorked, billable, description);
    }
}
