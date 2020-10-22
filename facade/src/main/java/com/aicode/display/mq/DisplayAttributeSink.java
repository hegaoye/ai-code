package com.aicode.display.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 显示属性
 * 定义 stream 通道
 * 定义方式采用变量方式，将变量名作为 传递的标准，变量的值作为通道的名字，
 * 与stream中的配置保持一致，此处默认将变量名与值相同
 */
public interface DisplayAttributeSink {
    String buildDisplayAttributeOutput = "buildDisplayAttributeOutput";
    String buildDisplayAttributeInput = "buildDisplayAttributeInput";

    @Output(value = buildDisplayAttributeOutput)
    MessageChannel buildDisplayAttributeOutput();

    @Input(buildDisplayAttributeInput)
    SubscribableChannel buildDisplayAttributeInput();
}
