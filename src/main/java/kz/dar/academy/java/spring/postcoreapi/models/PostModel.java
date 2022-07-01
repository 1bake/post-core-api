package kz.dar.academy.java.spring.postcoreapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {
        @NotNull(message = "Must be not null")
        private String postId;
        @NotNull(message = "Must be not null")
        private String clientId;
        @NotNull(message = "Must be not null")
        private String postRecipientId;
        @Email
        private String clientEmail;
        @Size(min = 2, max = 20, message = "Name must be more than 2 and less than 20")
        private String clientName;
        private String postItem;
        private String status;
}
