package com.myjavablog.fraud;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FraudCheckResponse {

    private boolean isFraudster;
}
