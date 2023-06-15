package com.azin.javaspringboothumanresource.utility.logmanagement.repository;
import com.azin.javaspringboothumanresource.utility.logmanagement.model.Com_Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Com_Log, Long> {
}
