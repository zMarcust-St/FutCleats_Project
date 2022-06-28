package com.futcleats.http.dto.response;

import com.futcleats.model.ReservationModel;
import lombok.*;

import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID id;

    private String name;

    private String login;

    private String cpf;

    private String telephone;

    private String email;

    private Date birthDate;

    private String password;

    private List<RoleResponse> roleResponseList;
}
