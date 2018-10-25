/*
 *
 *                        http://www.aicode.io
 *        郑州仁中和科技有限公司保留所有代码著作权.如有任何疑问请访问官方网站与我们联系.
 *        代码只针对特定客户使用，不得在未经允许或授权的情况下对外传播扩散.恶意传播者，法律后果自行承担.
 *        本代码仅用于AI-Code.
 *
 */
package io.aicode.core.exceptions;

/**
 * 设置异常类
 *
 * @author lixin 2017-08-03 17:46
 */

public class ProjectException extends BaseException {
    public ProjectException(BaseExceptionEnum exceptionMessage) {
        super(exceptionMessage);
    }

    public ProjectException(BaseExceptionEnum exceptionMessage, Object... params) {
        super(exceptionMessage, params);
    }

    public ProjectException(String message) {
        super(message);
    }

    public ProjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
