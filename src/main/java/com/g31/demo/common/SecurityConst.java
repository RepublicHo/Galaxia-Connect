package com.g31.demo.common;

/**
 * @Description:
 */
public final class SecurityConst {

    public static final String TOKEN_TYPE = "JWT";

    // the expiration period is 20 minutes if rememberMe is false.
    public static final long EXPIRATION_FALSE_REMEMBER = 20 * 60L;

    // the expiration period is 7 days if rememberMe is false.
    public static final long EXPIRATION_TRUE_REMEMBER = 60 * 60 * 24 * 7L;

    public static final String JWT_SECRET_KEY = "D*A-PbNdRgAkXn5r5u8x/A?D(G+KbPeShVmYq3s6v9y$B&E)H@McQfTjWnZr4u7w";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String ROLE_CLAIMS = "rol";

    // System WHITELIST
    public static final String[] SYSTEM_WHITELIST = {
            "/auth/login",
            "/users/sign-up"
    };

    public static final String[] SWAGGER_WHITELIST = {
            "/swagger-ui.html",
            "/swagger-ui/*",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/v3/api-docs"
    };

    public static final String H2_CONSOLE = "/h2-console/**";
}
