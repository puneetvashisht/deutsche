package com.dte.spring_boot_jpa_demp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
    
}
