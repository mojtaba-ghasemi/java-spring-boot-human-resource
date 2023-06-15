package com.azin.javaspringboothumanresource.serviceImplementation;

import com.azin.javaspringboothumanresource.input.EmployeeInput;
import com.azin.javaspringboothumanresource.messages.ErrorMessageException;
import com.azin.javaspringboothumanresource.model.Employee;
import com.azin.javaspringboothumanresource.output.EmployeeOutput;
import com.azin.javaspringboothumanresource.repository.EmployeeRepository;
import com.azin.javaspringboothumanresource.service.EmployeeService;
import com.azin.javaspringboothumanresource.utility.logmanagement.logenum.LogDirection;
import com.azin.javaspringboothumanresource.utility.logmanagement.serviceImplimentation.LogServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private LogServiceImplementation logServiceImplementation;


    @Override
    public EmployeeOutput createEmployee(EmployeeInput employeeInput) throws Exception {
        UUID logUuid = logServiceImplementation.createServiceStartLog("createEmployee", employeeInput, true, true);

        try {
            if (employeeInput.getName() != null && employeeInput.getFamily() != null) {
                Employee employee = new Employee().fromDto(employeeInput);
                employee.setUuid(UUID.randomUUID());

                employee = employeeRepository.save(employee);
                logServiceImplementation.createDebugLog(logUuid, LogDirection.FINISH, employee);

                return employee.toDto();
            } else
                throw new ErrorMessageException(0, 100, "NameOrFamilyEmpty");

        } catch (Exception exception) {
            logServiceImplementation.createDebugLog(logUuid, LogDirection.FINISH, "", exception.getMessage());
            throw exception;
        }
    }
}
