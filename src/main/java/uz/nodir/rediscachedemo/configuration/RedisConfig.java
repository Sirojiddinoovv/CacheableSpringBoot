package uz.nodir.rediscachedemo.configuration;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


/**
 * @author: PC
 * @date: 02.03.2025
 * @group: DavrCoders
 **/

@Configuration
@EnableRedisRepositories(
        basePackages = {
                "uz.nodir.*"
        },
        enableKeyspaceEvents
                = RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP)
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "spring.data.redis", name = "enabled", havingValue = "true", matchIfMissing = false)
@Slf4j
public class RedisConfig {

    @PostConstruct
    public void init() {
        log.info("Initializing Redis Cache");
    }
}
