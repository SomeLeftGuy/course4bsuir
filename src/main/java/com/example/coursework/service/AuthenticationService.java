package com.example.coursework.service;

import com.example.coursework.model.enums.EventName;
import com.example.coursework.model.entity.Employee;
import com.example.coursework.repository.PollRepository;
import com.example.coursework.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.coursework.model.dto.JwtAuthenticationResponseDTO;
import com.example.coursework.model.dto.AuthorizationEmployeeDTO;
import com.example.coursework.model.dto.RegistrationEmployeeDTO;
import com.example.coursework.model.enums.Role;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final EmployeeService employeeService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final PollRepository pollRepository;
    private final PositionRepository positionRepository;
    public Integer signUp(RegistrationEmployeeDTO dto) {
        var poll = pollRepository.getReferenceById(dto.getPollId());
        var position = positionRepository.getReferenceById(dto.getPositionId());
        employeeService.isExistsByUsername(dto.getUsername());

        var employee = Employee.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(Role.ROLE_USER)
                .birthday(dto.getBirthday())
                .poll(poll)
                .position(position)
                .build();

        return employeeService.create(employee);
    }

    public JwtAuthenticationResponseDTO signIn(AuthorizationEmployeeDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = employeeService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);
        var isAdmin = employeeService.isAdmin(user);
        return new JwtAuthenticationResponseDTO(jwt, isAdmin);
    }
}
