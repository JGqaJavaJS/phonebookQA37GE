package dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AllContactsDTO {
    List<ContactDTOLombok> contacts;
}
