package com.myjavablog.customer;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerRequest {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
