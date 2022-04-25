package ecommerce.ajc.backend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class MessageResponse {

    private String message;
}
