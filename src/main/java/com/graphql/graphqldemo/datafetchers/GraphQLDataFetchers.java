package com.graphql.graphqldemo.datafetchers;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {
    private static List<Map<String, String>> employeeList = Arrays.asList(
            ImmutableMap.of("id", "1",
                    "firstName", "Jack",
                    "lastName", "Tim",
                    "salary", "300",
                    "addressId", "1"),
            ImmutableMap.of("id", "2",
                    "firstName", "Bob",
                    "lastName", "Seif",
                    "salary", "1000",
                    "addressId", "2"),
            ImmutableMap.of("id", "3",
                    "firstName", "Mina",
                    "lastName", "Trump",
                    "salary", "500",
                    "addressId", "3"),
            ImmutableMap.of("id", "4",
                    "firstName", "Alice",
                    "lastName", "Madison",
                    "salary", "800",
                    "addressId", "4")
    );

    private static List<Map<String, String>> addresses = Arrays.asList(
            ImmutableMap.of("houseNo", "1",
                    "street", "nameless",
                    "city","Stockholm",
                    "state","Stockholm",
                    "country","Sweden"),
            ImmutableMap.of("houseNo", "2",
                    "street", "nameless",
                    "city","Stockholm",
                    "state","Stockholm",
                    "country","Sweden"),
            ImmutableMap.of("houseNo", "3",
                    "street", "nameless",
                    "city","Stockholm",
                    "state","Stockholm",
                    "country","Sweden"),
            ImmutableMap.of("houseNo", "4",
                    "street", "nameless",
                    "city","Stockholm",
                    "state","Stockholm",
                    "country","Sweden")
    );

    public DataFetcher<Map<String, String>> getEmployeeByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String employeeId = dataFetchingEnvironment.getArgument("id");
            return employeeList
                    .stream()
                    .filter(employee -> employee.get("id").equals(employeeId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getAllEmployees(){
        return dataFetchingEnvironment -> employeeList;
    }

    public DataFetcher getAddressByEmployeeDataFetcher(){
        return dataFetchingEnvironment -> {
            Map<String, String> employee = dataFetchingEnvironment.getSource();
            String addressId = employee.get("addressId");
            return addresses
                    .stream()
                    .filter(address -> address.get("houseNo").equals(addressId))    // find the address with the same id to the requested employee's address
                    .findFirst()
                    .orElse(null);
        };
    }
}