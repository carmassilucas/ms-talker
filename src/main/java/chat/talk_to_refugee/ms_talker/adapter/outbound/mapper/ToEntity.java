package chat.talk_to_refugee.ms_talker.adapter.outbound.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "type", qualifiedByName = "toTypeEntity"),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "updatedAt", ignore = true),
})
public @interface ToEntity {
}
