package com.azin.javaspringboothumanresource.utility.logmanagement;

import com.azin.javaspringboothumanresource.utility.logmanagement.model.Com_Log;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LogServiceImplementation implements LogService {

    @Autowired
    private LogRepository logRepository;


    @Override
    public void createInfoLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                              String description, String message) {

        Com_Log com_log = getCom_Log(serviceName, actionName, serviceId, logDirection, description
                , message, "");
        com_log.setType(LogType.INFO.name());
        logRepository.save(com_log);
    }

    @Override
    public void createDebugLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                               String description, String message, Object inputObject) {

        String objectSerialize = "";
        if (inputObject != null) {
            Gson gson = new Gson();
            objectSerialize = gson.toJson(inputObject);
        }
        Com_Log com_log = getCom_Log(serviceName, actionName, serviceId, logDirection, description
                , message, objectSerialize);
        com_log.setType(LogType.DEBUG.name());
        logRepository.save(com_log);
    }

    @Override
    public void createDebugLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                               String description, String message) {
        createDebugLog(serviceName, actionName, serviceId, logDirection, description, message, null);
    }
    @Override
    public void createDebugLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                               Object inputObject) {
        createDebugLog(serviceName, actionName, serviceId, logDirection, "", "", inputObject);
    }
    private Com_Log getCom_Log(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                               String description, String message, String serviceInOutParams) {
        Com_Log com_log = new Com_Log();
        com_log.setUserId("111");
        com_log.setDirection(logDirection.name());
        com_log.setServiceName(serviceName);
        com_log.setServiceId(serviceId);
        com_log.setActionName(actionName);
        com_log.setRegisterDate(LocalDateTime.now());
        com_log.setMessage(message);
        com_log.setDescription(description);
        com_log.setServiceInOutParams(serviceInOutParams);

        return com_log;
    }
}
