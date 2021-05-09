package com.young.myoauth2server.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

/**
 * 认证服务器配置
 * Created by macro on 2019/9/30.
 */
@Configuration
@EnableAuthorizationServer //开启认证服务器
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

//    @Autowired
//    private MyClientDetailsService myClientDetailsService;
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    /**
     *  创建jdbcClientDetailsService实例，并注入spring容器中，不要少了@Bean
     *  注意：访问修饰符不要写错了。
     * @return
     */
    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
        return new JdbcClientDetailsService(dataSource());
    }

    /**
     * 指定令牌管理方式
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        // redis 管理令牌
//        return new RedisTokenStore(redisConnectionFactory);
        // 注入数据源
        return new JdbcTokenStore(dataSource());
        // 使用JWT管理令牌
//        return new JwtTokenStore(jwtAccessTokenConverter());
    }


    /**
     * 令牌服务的具体的bean
     * @return
     */
    @Bean
    public AuthorizationServerTokenServices tokenService(){
        DefaultTokenServices defaultTokenServices= new DefaultTokenServices();
        defaultTokenServices.setClientDetailsService(jdbcClientDetailsService());//客户端详情服务
        defaultTokenServices.setTokenStore(tokenStore());//令牌存储策略
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setAccessTokenValiditySeconds(7200);
        defaultTokenServices.setRefreshTokenValiditySeconds(259200);
        return defaultTokenServices;
    }

    /**
     * 配置授权码的服务
     * @return
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        return new JdbcAuthorizationCodeServices(dataSource());
    }


    /**
     * 配置客户端详情服务，客户端详情信息在这个方法中初始化，
     * 可以在这里写死或者通过数据库来
     * 校验客户端的是否正确
     * 调用详情信息
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(jdbcClientDetailsService());
//        clients.inMemory()
//                .withClient("admin")//配置client_id
//                .secret(passwordEncoder.encode("admin123456"))//配置client_secret
//                .accessTokenValiditySeconds(3600)//配置访问token的有效期
//                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
//                .redirectUris("http://www.baidu.com")//配置redirect_uri，用于授权成功后跳转
//                .scopes("all")//配置申请的权限范围
//                .authorizedGrantTypes("authorization_code","password");//配置grant_type，表示授权类型
    }

    /**
     * 令牌访问端点 和令牌服务
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//        endpoints.authenticationManager(authenticationManager)//认证管理器
//                .userDetailsService(myUserDetailService)
//                .authorizationCodeServices(authorizationCodeServices())//授权码服务
//                .tokenServices(tokenService())//令牌管理服务
//                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
//                .tokenStore(tokenStore())
//                .authorizationCodeServices(authorizationCodeServices())
//                .setClientDetailsService(myClientDetailsService);

//         密码模式需要设置认证管理器
        endpoints.authenticationManager(authenticationManager);
        // 刷新令牌获取新令牌时需要
        endpoints.userDetailsService(myUserDetailService);
        // 令牌的管理方式，并指定JWT转换器 accessTokenConverter
//        endpoints.tokenStore(tokenStore()).accessTokenConverter(jwtAccessTokenConverter);
        endpoints.tokenStore(tokenStore());
        // 授权码管理策略
        endpoints.authorizationCodeServices(authorizationCodeServices());

    }

    /**
     * 配置令牌端点的安全约束
     *
     * @param security
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        // 所有人可访问 /oauth/token_key 后面要获取公钥, 默认拒绝访问
        security.tokenKeyAccess("permitAll()");
        // 认证后可访问 /oauth/check_token , 默认拒绝访问
        security.checkTokenAccess("isAuthenticated()");
    }

}
