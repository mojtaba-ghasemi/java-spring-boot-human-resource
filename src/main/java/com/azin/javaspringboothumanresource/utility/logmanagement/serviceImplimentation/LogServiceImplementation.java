package com.azin.javaspringboothumanresource.utility.logmanagement.serviceImplimentation;

import com.azin.javaspringboothumanresource.utility.logmanagement.logenum.LogDirection;
import com.azin.javaspringboothumanresource.utility.logmanagement.service.LogService;
import com.azin.javaspringboothumanresource.utility.logmanagement.model.Com_Log;
import com.azin.javaspringboothumanresource.utility.logmanagement.repository.LogRepository;

import com.azin.javaspringboothumanresource.utility.logmanagement.logenum.LogType;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LogServiceImplementation implements LogService {

    @Autowired
    private LogRepository logRepository;


    @Override
    public void createInfoLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection) {

        Com_Log com_log = getCom_Log(serviceName, actionName, serviceId, logDirection, "", "", "");
        com_log.setType(LogType.INFO.name());
        logRepository.save(com_log);
    }

    public void createInfoLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                              String description, String errorMessage) {

        Com_Log com_log = getCom_Log(serviceName, actionName, serviceId, logDirection, description
                , errorMessage, "");
        com_log.setType(LogType.INFO.name());
        logRepository.save(com_log);
    }

    @Override
    public void createDebugLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                               String description, String errorMessage) {
        createDebugLog(serviceName, actionName, serviceId, logDirection, description, errorMessage, null);
    }

    @Override
    public void createDebugLog(UUID serviceId, LogDirection logDirection, String description, String errorMessage) {

        createDebugLog(null, "", serviceId, logDirection, description, errorMessage, null);
    }

    @Override
    public void createDebugLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                               Object inputObject) {

        createDebugLog(serviceName, actionName, serviceId, logDirection, "", "", inputObject);
    }

    @Override
    public void createDebugLog(UUID serviceId, LogDirection logDirection, Object inputObject) {

        createDebugLog(null, "", serviceId, logDirection, "", "", inputObject);
    }

    @Value("${app.config.log.debug}")
    private Boolean appConfigLogDebug;

    @Override
    public void createDebugLog(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                               String description, String errorMessage, Object inputObject) {

        if (appConfigLogDebug) {
            String objectSerialize = "";

            if (inputObject != null) {
                Gson gson = new Gson();
                objectSerialize = gson.toJson(inputObject);
            }
            if(serviceName == null)
                serviceName = Thread.currentThread().getStackTrace()[2].getClassName()
                        .concat("/").concat(Thread.currentThread().getStackTrace()[2].getMethodName());

            Com_Log com_log = getCom_Log(serviceName, actionName, serviceId, logDirection, description
                    , errorMessage, objectSerialize);
            com_log.setType(LogType.DEBUG.name());
            logRepository.save(com_log);
        }
    }

    private Com_Log getCom_Log(String serviceName, String actionName, UUID serviceId, LogDirection logDirection,
                               String description, String errorMessage, String serviceInOutParams) {
        Com_Log com_log = new Com_Log();
        com_log.setUserId("111");
        com_log.setDirection(logDirection.name());
        com_log.setServiceName(serviceName);
        com_log.setServiceId(serviceId);
        com_log.setActionName(actionName);
        com_log.setRegisterDate(LocalDateTime.now());
        com_log.setErrorMessage(errorMessage);
        com_log.setDescription(description);
        com_log.setServiceInOutParams(serviceInOutParams);

        return com_log;
    }

    @Override
    public UUID createServiceStartLog(String serviceName, Object inputObject
            , boolean createInfoLog, boolean createDebugLog) {

        UUID logUuid = UUID.randomUUID();
        if (createInfoLog)
            this.createInfoLog(serviceName, "", logUuid, LogDirection.START);
        if (createDebugLog)
            this.createDebugLog(serviceName, "", logUuid, LogDirection.START, inputObject);

        return logUuid;
    }
}
