package com.azin.javaspringboothumanresource.utility.logmanagement.service;

import com.azin.javaspringboothumanresource.utility.logmanagement.logenum.LogDirection;

import java.util.UUID;

public interface LogService {
    void createInfoLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection);

    void createInfoLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                       String description, String errorMessage);

    void createDebugLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                        String description, String errorMessage, Object inputObject);

    void createDebugLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                        Object inputObject);

    void createDebugLog(UUID serviceId, LogDirection logDirection, Object inputObject);

    void createDebugLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                        String description, String errorMessage);

    void createDebugLog(UUID serviceId, LogDirection logDirection,
                        String description, String errorMessage);

    UUID createServiceStartLog(String serviceName, Object inputObject, boolean createInfoLog, boolean createDebugLog);

}
