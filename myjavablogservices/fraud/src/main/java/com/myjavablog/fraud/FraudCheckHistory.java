package com.myjavablog.fraud;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "fraud_check_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FraudCheckHistory {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;

}
