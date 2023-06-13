package com.azin.javaspringboothumanresource.utility.logmanagement.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "COM_LOG")
public class Com_Log {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "REGISTER_DATE")
    private LocalDateTime registerDate;

    @Column(name = "SERVICE_NAME")
    private String serviceName;

    @Column(name = "SERVICE_ID", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID serviceId;

    public String getServiceInOutParams() {
        return serviceInOutParams;
    }

    public void setServiceInOutParams(String serviceInOutParams) {
        this.serviceInOutParams = serviceInOutParams;
    }

    @Column(name = "SERVICE_IN_OUT_PARAMS")
    private String serviceInOutParams;

    @Column(name = "ACTION_NAME")
    private String actionName;

    @Column(name = "DIRECTION")
    private String direction;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MESSAGE")
    private String Message;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public UUID getServiceId() {
        return serviceId;
    }

    public void setServiceId(UUID serviceId) {
        this.serviceId = serviceId;
    }


    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }




}
