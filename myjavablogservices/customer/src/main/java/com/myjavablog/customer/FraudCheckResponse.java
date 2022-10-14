package com.myjavablog.customer;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FraudCheckResponse {

    private Boolean fraudster;
}
