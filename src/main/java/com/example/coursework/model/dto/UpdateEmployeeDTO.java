package com.example.coursework.model.dto;

import com.example.coursework.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeDTO {
    private Integer positionId;
    private Set<Integer> cellIds;
    private Role role;
}
