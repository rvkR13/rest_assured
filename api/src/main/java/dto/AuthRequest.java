package dto;

import config.BaseConfig;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.aeonbits.owner.ConfigFactory;

@Value
@Builder
public class AuthRequest {
    private static final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());
    @Builder.Default
    Object password = config.username();
    @Builder.Default
    Object username = config.password();
}