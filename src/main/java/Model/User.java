package Model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String Id;
    private String ref;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    List<CashFlow> cashFlows;
}
