package streamapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal balance;
    private Birthday birthday;
    private LocalDateTime creationDate;
    private Sex sex;
}
