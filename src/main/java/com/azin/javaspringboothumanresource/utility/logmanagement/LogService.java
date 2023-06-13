package com.azin.javaspringboothumanresource.utility.logmanagement;

import com.azin.javaspringboothumanresource.utility.logmanagement.model.Com_Log;
import org.springframework.lang.Nullable;

import java.util.UUID;

public interface LogService {
    void createInfoLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                       String description, String message);


    void createDebugLog(String serviceName, String actionName, UUID serviceId,  LogDirection logDirection,
                         String description, String message, Object inputObject);
    void createDebugLog(String serviceName, String actionName, UUID serviceId,  LogDirection logDirection,
                         Object inputObject);

    void createDebugLog(String serviceName, String actionName, UUID serviceId,  LogDirection logDirection,
                        String description, String message);

}
