package com.young.securitydemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtSecurityProperties {

    /** Request Headers */
    private String header;

    /** 令牌前置 Bearer */
    private String tokenStartWith;

    /** base64该令牌进行编码 */
    private String base64Secret;

    /** 令牌过期时间 单位为毫秒*/
    private Long tokenValidityInSeconds;

    public String getTokenStartWith() {
        return tokenStartWith+" ";
    }
}
