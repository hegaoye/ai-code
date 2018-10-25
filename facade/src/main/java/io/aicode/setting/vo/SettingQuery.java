/*
 *
 *                        http://www.aicode.io
 *        郑州仁中和科技有限公司保留所有代码著作权.如有任何疑问请访问官方网站与我们联系.
 *        代码只针对特定客户使用，不得在未经允许或授权的情况下对外传播扩散.恶意传播者，法律后果自行承担.
 *        本代码仅用于AI-Code.
 *
 */


package io.aicode.setting.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SettingQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;

    /**
     * 键
     */
    private String k;
    /**
     * 值
     */
    private String v;

    /**
     * 说明
     */
    private String summary;

}

