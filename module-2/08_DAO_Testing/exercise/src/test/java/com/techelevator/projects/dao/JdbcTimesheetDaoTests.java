package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;

    Timesheet test;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        test = dao.getTimesheet(1);
        Assert.assertEquals(TIMESHEET_1, test);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        test = dao.getTimesheet(99);
        Assert.assertNull(test);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timeSheets = new ArrayList<Timesheet>();
        timeSheets = dao.getTimesheetsByEmployeeId(1);
        Assert.assertEquals(2, timeSheets.size());
        Assert.assertTrue(timeSheets.contains(TIMESHEET_1));
        Assert.assertTrue(timeSheets.contains(TIMESHEET_2));
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timeSheets = new ArrayList<Timesheet>();
        timeSheets = dao.getTimesheetsByProjectId(1);
        Assert.assertEquals(3, timeSheets.size());
        Assert.assertTrue(timeSheets.contains(TIMESHEET_1));
        Assert.assertTrue(timeSheets.contains(TIMESHEET_2));
        Assert.assertTrue(timeSheets.contains(TIMESHEET_3));
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        test = new Timesheet(5, 1, 1, LocalDate.parse("2021-01-01"), 1.0, true, "test 1");
        dao.createTimesheet(test);
        Assert.assertEquals(5, test.getTimesheetId());
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        test = dao.createTimesheet(TIMESHEET_1);
        Timesheet correctTimesheet = new Timesheet(5, 1, 1, LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
        assertTimesheetsMatch(correctTimesheet, test);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        dao.updateTimesheet(TIMESHEET_1);
        Assert.assertEquals(1, TIMESHEET_1.getEmployeeId());
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        dao.deleteTimesheet(1);
        Assert.assertTrue(dao.getTimesheet(1) == null);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double billable = dao.getBillableHours(2,2);
        Assert.assertEquals(0, billable, .9);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
