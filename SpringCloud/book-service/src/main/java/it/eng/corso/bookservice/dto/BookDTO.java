package it.eng.corso.bookservice.dto;

import it.eng.corso.bookservice.groups.Step1;
import it.eng.corso.bookservice.groups.Step2;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    @Null(groups = Step1.class)
    private String uuid;
    @NotNull(message = "ma che fai!?!?!?", groups = {Step1.class, Step2.class})
    @Size( min = 5, max = 50, groups = Step1.class)
    private String title;
    @Email( groups = Step2.class)
    private String author;
    private Double price;

    private Double stars;
}
