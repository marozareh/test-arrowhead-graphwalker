package com.mbtroads.core;

import java.net.InetAddress;

public interface ISystemProperties {

    String OS = System.getProperty("os.name");
    String currentDir = System.getProperty("user.dir");
    String pathSeperator = OS.contains("Window") ? "\\" : "/";
    String env = System.getProperty("SuiteEnv");
    String testCaseName = System.getProperty("test");
    String pipelineName = String.valueOf(System.getProperty("Pipeline"));

    static String getMachineName() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostName().toUpperCase();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
