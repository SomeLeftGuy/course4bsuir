package com.example.coursework.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum EventName {
    RECEIVED_EMPLOYEE(Constants.RECEIVED_EMPLOYEE),
    CREATED_ANIMAL_DESCRIPTION(Constants.CREATED_ANIMAL_DESCRIPTION),
    EMPLOYEE_CREATED(Constants.EMPLOYEE_CREATED),
    EMPLOYEE_DELETED(Constants.EMPLOYEE_DELETED),
    EMPLOYEE_UPDATED(Constants.EMPLOYEE_UPDATED),
    RECEIVED_DESCRIPTION_FOR_AN_ANIMAL(Constants.RECEIVED_DESCRIPTION_FOR_AN_ANIMAL),
    RECEIVED_LIST_OF_SUPPLIED_FOOD_SUPPLIERS(Constants.RECEIVED_LIST_OF_SUPPLIED_FOOD_SUPPLIERS),
    RECEIVED_LIST_OF_FOOD_FOR_AN_ANIMAL(Constants.RECEIVED_LIST_OF_FOOD_FOR_AN_ANIMAL),
    RECEIVED_LIST_ANIMALS(Constants.RECEIVED_LIST_ANIMALS),
    RECEIVED_ANIMAL(Constants.RECEIVED_ANIMAL),
    RECEIVED_SUPPLIER(Constants.RECEIVED_SUPPLIER),
    RECEIVED_LIST_SUPPLIERS(Constants.RECEIVED_LIST_SUPPLIERS);

    private static final Map<String, EventName> LOOKUP_MAP = new HashMap<>();

    private final String value;

    static {
        for (EventName documentStatus : values()) {
            LOOKUP_MAP.put(documentStatus.getValue(), documentStatus);
        }
    }

    public static EventName getByValue(String value) {
        return LOOKUP_MAP.get(value);
    }

    public static class Constants {

        private Constants() {
        }

        public static final String RECEIVED_EMPLOYEE = "RECEIVED_EMPLOYEE";
        public static final String EMPLOYEE_CREATED = "EMPLOYEE_CREATED";
        public static final String EMPLOYEE_DELETED = "EMPLOYEE_DELETED";
        public static final String EMPLOYEE_UPDATED = "EMPLOYEE_UPDATED";
        public static final String CREATED_ANIMAL_DESCRIPTION = "CREATED_ANIMAL_DESCRIPTION";
        public static final String RECEIVED_DESCRIPTION_FOR_AN_ANIMAL = "RECEIVED_DESCRIPTION_FOR_AN_ANIMAL";
        public static final String RECEIVED_LIST_OF_SUPPLIED_FOOD_SUPPLIERS = "RECEIVED_LIST_OF_SUPPLIED_FOOD_SUPPLIERS";
        public static final String RECEIVED_LIST_OF_FOOD_FOR_AN_ANIMAL = "RECEIVED_LIST_OF_FOOD_FOR_AN_ANIMAL";
        public static final String RECEIVED_LIST_SUPPLIERS = "RECEIVED_LIST_SUPPLIERS";
        public static final String RECEIVED_LIST_ANIMALS = "RECEIVED_LIST_ANIMALS";
        public static final String RECEIVED_ANIMAL = "RECEIVED_ANIMAL";
        public static final String RECEIVED_SUPPLIER = "RECEIVED_SUPPLIER";
    }
}