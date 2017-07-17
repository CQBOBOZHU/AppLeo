package com.leoyou.appleo.net.logInterceptor;

/**
 * Created by Administrator on 2017/5/17.
 */

public enum  Level  {
    /**
     * No logs.
     */
    NONE,
    /**
     * <p>Example:
     * <pre>{@code
     *  - URL
     *  - Method
     *  - Headers
     *  - Body
     * }</pre>
     */
    BASIC,
    /**
     * <p>Example:
     * <pre>{@code
     *  - URL
     *  - Method
     *  - Headers
     * }</pre>
     */
    HEADERS,
    /**
     * <p>Example:
     * <pre>{@code
     *  - URL
     *  - Method
     *  - Body
     * }</pre>
     */
    BODY
}
