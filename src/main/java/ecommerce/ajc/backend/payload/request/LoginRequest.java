package ecommerce.ajc.backend.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class LoginRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Override
    public String toString() {
        return this.email;
    }
}
