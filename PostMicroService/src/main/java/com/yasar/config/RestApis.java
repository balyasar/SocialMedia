package com.yasar.config;

public class RestApis {
    private static final String DEV = "/dev";
    private static final String VERSION = "/v1";
    private static final String ENDPOINT = DEV + VERSION;

    public static final String POST = ENDPOINT+"/post";
    public static final String COMMENT = ENDPOINT+"/comment";
    public static final String CREATE_POST = "/create-post";
    public static final String GET_ALL = "/get_all";

}
