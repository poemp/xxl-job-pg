package org.poem.config;

/**
 * @author Administrator
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.poem.config.jackson.BeanSerializerModifier;

import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * 返回Long转换为String
 *
 * @author sangfor
 */
public class JacksonMapper extends ObjectMapper {

    public JacksonMapper() {
        super();
        this.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
        this.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        simpleModule.addSerializer(long.class, ToStringSerializer.instance);
        //添加LocalDateTime序列化及反序列化，返回前端以及接收前端时间字符串时不必手动转化
        simpleModule.addSerializer(LocalDateTime.class, LocalDateTimeSerializer.INSTANCE);
        simpleModule.addDeserializer(LocalDateTime.class, LocalDateTimeDeserializer.INSTANCE);
        // 为mapper注册一个带有SerializerModifier的Factory，此modifier主要做的事情为：当序列化类型为array，list、set时，当值为空时，序列化成[]
        simpleModule.setSerializerModifier(new BeanSerializerModifier());

        registerModule(simpleModule);

    }
}
