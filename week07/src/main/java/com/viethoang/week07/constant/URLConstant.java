package com.viethoang.week07.constant;

public class URLConstant {

    public static final class Company {
        public static final String PREFIX     = "/companies";
        public static final String GET_ONE    = PREFIX + "/{company-id}";
        public static final String GET_LIST   = PREFIX;
        public static final String ADD_ONE    = PREFIX;
        public static final String UPDATE_ONE = PREFIX + "/{company-id}";
        public static final String DELETE_ONE = PREFIX + "/{company-id}";
    }

    public static final class Employee {
        public static final String PREFIX              = "/employees";
        public static final String GET_ONE             = PREFIX + "/{employee-id}";
        public static final String GET_LIST            = PREFIX;
        public static final String ADD_ONE             = Company.PREFIX + "/{company-id}" + Employee.PREFIX;
        public static final String UPDATE_ONE          = Company.PREFIX + "/{company-id}" + Employee.PREFIX + "/{employee-id}";
        public static final String DELETE_ONE          = Company.PREFIX + "/{company-id}" + Employee.PREFIX + "/{employee-id}";
        public static final String GET_LIST_BY_COMPANY = Company.PREFIX + "/{company-id}" + Employee.PREFIX;
    }

    public static final class Job {
        public static final String PREFIX               = "/jobs";
        public static final String GET_ONE              = PREFIX + "/{jobId}";
        public static final String GET_LIST             = PREFIX;
        public static final String ADD_ONE              = Employee.PREFIX + "/{employeeId}" + Job.PREFIX;
        public static final String UPDATE_ONE           = Employee.PREFIX + "/{employeeId}" + Job.PREFIX;
        public static final String DELETE_ONE           = Employee.PREFIX + "/{employeeId}" + Job.PREFIX;
        public static final String GET_LIST_BY_EMPLOYEE = Employee.PREFIX + "/{employeeId}" + Job.PREFIX;
    }


}
