package uz.nodir.rediscachedemo.model.dto.status.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Nodir
 * on Date 02 март, 2025
 * Java Spring Boot by Davr Coders
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusBaseResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("definition")
    private String definition;
}
