package com.mbtroads.resolver_auto;

import org.openapitools.client.model.ServiceRegistryRequestDTO;
import org.openapitools.client.model.SystemRequestDTO;

public class EdgeScenarioResolver {

    public static ServiceRegistryRequestDTO resolveRegister(String scenario) {

        ServiceRegistryRequestDTO dto = new ServiceRegistryRequestDTO();

        if ("valid".equalsIgnoreCase(scenario)) {

            dto.setServiceDefinition("indoortemperature");
            dto.setServiceUri("temperature");
            dto.setVersion(1);
            dto.setSecure("NOT_SECURE");

            SystemRequestDTO provider = new SystemRequestDTO();
            provider.setSystemName("test-system-" + System.currentTimeMillis());
            provider.setAddress("192.168.0.2");
            provider.setPort(8080);

            dto.setProviderSystem(provider);

        } else {

            dto.setServiceDefinition(null); // invalid scenario

        }

        return dto;
    }
}
