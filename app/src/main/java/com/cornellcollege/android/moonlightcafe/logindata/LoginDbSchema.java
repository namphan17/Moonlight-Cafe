package com.cornellcollege.android.moonlightcafe.logindata;

/**
 * Database schema for user profile
 */
public class LoginDbSchema {
    public static final class LoginTable {
        public static final String NAME = "login";
        public static final class Cols {
            public static final String USERNAME = "username";
            public static final String FNAME = "fname";
            public static final String LNAME = "lname";
            public static final String EMAIL = "email";
            public static final String SECURE_ANS = "secureAns";
            public static final String SECURE_QUES = "secureQues";
            public static final String PASSWORD = "password";
        }
    }
}
