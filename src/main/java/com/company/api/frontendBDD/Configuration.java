package com.company.api.frontendBDD;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {


        public static final Config CONFIG = ConfigFactory.load("configuration/config.conf");
        public static final String ENVIRONMENT = CONFIG.getString("environment");
        public static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);

        public static final String KOMPASS_LOGIN_D = ENV.getString("kompassLoginD");
        public static final String KOMPASS_PASSWORD_D = ENV.getString("kompassPasswordD");
        public static final String KOMPASS_LOGIN_V = ENV.getString("kompassLoginV");
        public static final String KOMPASS_PASSWORD_V = ENV.getString("kompassPasswordV");
        public static final String KOMPASS_DEV_URL = ENV.getString("kompassDevUrl");
        public static final String KOMPASS_UAT_URL = ENV.getString("kompassUatUrl");
        public static final String CORRELATION_ID_DEV = ENV.getString("correlationID_DEV");
        public static final String CORRELATION_ID = ENV.getString("correlationID");
        public static final String CORRELATION_ID_UAT = ENV.getString("correlationID_UAT");


}
