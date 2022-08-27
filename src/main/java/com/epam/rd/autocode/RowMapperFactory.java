package com.epam.rd.autocode;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigInteger;
import java.math.BigDecimal;


public class RowMapperFactory {

    public RowMapper<Employee> employeeRowMapper() {
        return new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet resultSet) {
                try {
                    return new Employee(
                            new BigInteger(resultSet.getString("id")),
                            new FullName(resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getString("middlename")),
                            Position.valueOf(resultSet.getString("position")),
                            resultSet.getDate("hiredate").toLocalDate(),
                            new BigDecimal(resultSet.getString("salary"))
                    );
                } catch (SQLException e) {
                    return null;
                }
            }
        };
    }
}
