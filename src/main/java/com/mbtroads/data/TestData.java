package com.mbtroads.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public interface TestData {

    /* =========================================================
       DATE HANDLING (unchanged logic)
       ========================================================= */

    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
    String strDate = dateFormat.format(date);

    /* =========================================================
       SERVICE REGISTRY PAYLOADS
       ========================================================= */

    String InvaledServiceRegistery =
            "{ \"providerSystem\": { \"systemName\": \"insecuretemperaturesensor\", " +
                    "\"address\": \"192.168.0.2\", \"port\": 8080, " +
                    "\"authenticationInfo\": \"eyJhbGciOiJIUzI1Ni...\"}, " +
                    "\"serviceUri\": \"temperature\", " +
                    "\"endOfValidity\": \"2024-12-05T05:53:00+00:00\", " +
                    "\"secure\": \"NOT_SECURE\", " +
                    "\"metadata\": { \"unit\": \"celsius\"}, " +
                    "\"version\": 1, " +
                    "\"interfaces\": [ \"HTTP-INSECURE-JSON\" ]}";

    String ValidServiceRegistery_Payload =
            "{ \"serviceDefinition\": \"IndoorTemperature\", " +
                    "\"providerSystem\": { \"systemName\": \"insecuretemperaturesensornew\", " +
                    "\"address\": \"192.168.0.2\", \"port\": 8080, " +
                    "\"authenticationInfo\": \"eyJhbGciOiJIUzI1Ni...\"}, " +
                    "\"serviceUri\": \"temperature\", " +
                    "\"endOfValidity\": \"2024-12-05T05:53:00+00:00\", " +
                    "\"secure\": \"NOT_SECURE\", " +
                    "\"metadata\": { \"unit\": \"celsius\"}, " +
                    "\"version\": 1, " +
                    "\"interfaces\": [ \"HTTP-INSECURE-JSON\" ]}";

    String NewService =
            "{ \"serviceDefinition\": \"IndoorTemperature\", " +
                    "\"providerSystem\": { \"systemName\": \"insecuretemperaturesensor-" + strDate + "\", " +
                    "\"address\": \"192.168.0.2\", \"port\": 8080, " +
                    "\"authenticationInfo\": \"eyJhbGciOiJIUzI1Ni...\"}, " +
                    "\"serviceUri\": \"temperature\", " +
                    "\"endOfValidity\": \"2024-12-05T05:53:00+00:00\", " +
                    "\"secure\": \"NOT_SECURE\", " +
                    "\"metadata\": { \"unit\": \"celsius\"}, " +
                    "\"version\": 1, " +
                    "\"interfaces\": [ \"HTTP-INSECURE-JSON\" ]}";

    String NewServiceNotExist =
            "{ \"serviceDefinition\": \"IndoorTemperature\", " +
                    "\"providerSystem\": { \"systemName\": \"insecuretemperaturesensorNX_" + strDate + "\", " +
                    "\"address\": \"192.168.0.2\", \"port\": 8080, " +
                    "\"authenticationInfo\": \"eyJhbGciOiJIUzI1Ni...\"}, " +
                    "\"serviceUri\": \"temperature\", " +
                    "\"endOfValidity\": \"2024-12-05T05:53:00+00:00\", " +
                    "\"secure\": \"NOT_SECURE\", " +
                    "\"metadata\": { \"unit\": \"celsius\"}, " +
                    "\"version\": 1, " +
                    "\"interfaces\": [ \"HTTP-INSECURE-JSON\" ]}";

    String NewServiceConsumer =
            "{ \"serviceDefinition\": \"IndoorTemperature\", " +
                    "\"providerSystem\": { \"systemName\": \"insecuretemperaturesensorConsumer-" + strDate + "\", " +
                    "\"address\": \"192.168.0.2\", \"port\": 8080, " +
                    "\"authenticationInfo\": \"eyJhbGciOiJIUzI1Ni...\"}, " +
                    "\"serviceUri\": \"temperature\", " +
                    "\"endOfValidity\": \"2024-12-05T05:53:00+00:00\", " +
                    "\"secure\": \"NOT_SECURE\", " +
                    "\"metadata\": { \"unit\": \"celsius\"}, " +
                    "\"version\": 1, " +
                    "\"interfaces\": [ \"HTTP-INSECURE-JSON\" ]}";

    String EXISTService =
            "{ \"serviceDefinition\": \"IndoorTemperature\", " +
                    "\"providerSystem\": { \"systemName\": \"insecuretemperaturesensor\", " +
                    "\"address\": \"192.168.0.2\", \"port\": 8080, " +
                    "\"authenticationInfo\": \"eyJhbGciOiJIUzI1Ni...\"}, " +
                    "\"serviceUri\": \"temperature\", " +
                    "\"endOfValidity\": \"2024-12-05T05:53:00+00:00\", " +
                    "\"secure\": \"NOT_SECURE\", " +
                    "\"metadata\": { \"unit\": \"celsius\"}, " +
                    "\"version\": 1, " +
                    "\"interfaces\": [ \"HTTP-INSECURE-JSON\" ]}";

    /* =========================================================
       QUERY SERVICE PAYLOADS
       ========================================================= */

    String InvaledServiceQuery = "{ }";

    String ValidServiceQuery_Payload =
            "{ \"serviceDefinitionRequirement\": \"indoortemperature\" }";

    String InterfaceNotDefined =
            "{ \"interfaceRequirements\": [ \"TTP-INSECURE-JSON\" ], " +
                    "\"serviceDefinitionRequirement\": \"indoortemperature\" }";

    String InterfaceDefined =
            "{ \"interfaceRequirements\": [ \"HTTP-INSECURE-JSON\" ], " +
                    "\"serviceDefinitionRequirement\": \"indoortemperature\" }";

    String SecureNotDefined =
            "{ \"securityRequirements\": [ \"NO_SECURE\" ], " +
                    "\"serviceDefinitionRequirement\": \"indoortemperature\" }";

    String SecureDefined =
            "{ \"securityRequirements\": [ \"NOT_SECURE\" ], " +
                    "\"serviceDefinitionRequirement\": \"indoortemperature\" }";

    String VersionNotDefined =
            "{ \"serviceDefinitionRequirement\": \"indoortemperature\", " +
                    "\"versionRequirement\": 0 }";

    String VersionDefined =
            "{ \"serviceDefinitionRequirement\": \"indoortemperature\", " +
                    "\"versionRequirement\": 1 }";

    String MetaDataNotDefined =
            "{ \"metadataRequirements\": { \"unit\": \"celsius1\" }, " +
                    "\"serviceDefinitionRequirement\": \"indoortemperature\" }";

    String MetaDataDefined =
            "{ \"metadataRequirements\": { \"unit\": \"celsius\" }, " +
                    "\"serviceDefinitionRequirement\": \"indoortemperature\" }";

    String PingProviders =
            "{ \"pingProviders\": true, " +
                    "\"serviceDefinitionRequirement\": \"indoortemperature\" }";

    /* =========================================================
       UNREGISTER SERVICE PAYLOADS
       ========================================================= */

    String UnregisterService =
            "address=192.168.0.2&port=8080&service_definition=indoortemperature" +
                    "&service_uri=temperature&system_name=NOTEXIST";

    String registerService =
            "address=192.168.0.2&port=8080&service_definition=indoortemperature" +
                    "&service_uri=temperature&system_name=";

    /* =========================================================
       ANSI COLORS (unchanged)
       ========================================================= */

    String ANSI_GREEN = "\u001B[32m";
    String ANSI_BLACK = "\u001B[30m";
}
