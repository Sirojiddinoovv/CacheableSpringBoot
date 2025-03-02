package uz.nodir.rediscachedemo.model.dto.core.response;

import com.fasterxml.jackson.annotation.JsonAlias;
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
public class CoreResult {

    @JsonProperty("code")
    @JsonAlias({"code", "Code", "CODE"})
    private Integer code;

    @JsonProperty("message")
    @JsonAlias({"message", "Message", "MESSAGE"})
    private String message;
}
