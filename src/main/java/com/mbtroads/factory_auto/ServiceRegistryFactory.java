package com.mbtroads.factory_auto;

import org.openapitools.client.model.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class ServiceRegistryFactory {

    public static ServiceRegistryRequestDTO validRegister() {

        ServiceRegistryRequestDTO request =
                new ServiceRegistryRequestDTO();

        // -------- Basic Fields --------
        request.setServiceDefinition("IndoorTemperature");
        request.setServiceUri("temperature");
        request.setSecure("NOT_SECURE");
        request.setVersion(1);

        // -------- Provider System --------
        SystemRequestDTO provider = new SystemRequestDTO();
        provider.setSystemName("sensor-" + System.currentTimeMillis());
        provider.setAddress("192.168.0.2");
        provider.setPort(8080);
        provider.setAuthenticationInfo("test-auth");

        request.setProviderSystem(provider);

        // -------- Metadata (YOUR DTO EXPECTS MAP) --------
        Map<String, String> metadata = new HashMap<>();
        metadata.put("unit", "celsius");
        request.setMetadata(metadata);

        // -------- Interfaces --------
        request.setInterfaces(
                Collections.singletonList("HTTP-INSECURE-JSON")
        );

        // -------- End of Validity (YOUR DTO EXPECTS STRING) --------
        String endOfValidity =
                OffsetDateTime.now()
                        .plusDays(1)
                        .withOffsetSameInstant(ZoneOffset.UTC)
                        .toString();

        request.setEndOfValidity(endOfValidity);

        return request;
    }

    public static ServiceRegistryRequestDTO invalidRegister() {
        return new ServiceRegistryRequestDTO();
    }
}
