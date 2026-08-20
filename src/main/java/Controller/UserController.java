package Controller;

import Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/cash-flows")
    public List<CashFlow> getCashFlows(@RequestParam(required = false) String type) {
        return UserService.findByType(type);
    }
}
