package br.com.vanessa.application.domain.models;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import br.com.vanessa.application.domain.exception.BalanceToWithdrawException;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AccountDomain {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;
    private String customer;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create() {
    }

    public void deposit(BigDecimal amount){
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) >= 0){
            this.balance.subtract(amount);
        }else {
            throw new BalanceToWithdrawException("error withdraw");
        }
    }
}
