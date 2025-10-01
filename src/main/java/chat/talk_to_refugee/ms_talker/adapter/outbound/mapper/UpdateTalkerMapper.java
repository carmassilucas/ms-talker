package chat.talk_to_refugee.ms_talker.adapter.outbound.mapper;

import chat.talk_to_refugee.ms_talker.adapter.outbound.repository.TalkerEntity;
import chat.talk_to_refugee.ms_talker.adapter.outbound.repository.TalkerTypeEntity;
import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import org.mapstruct.*;
import org.springframework.util.StringUtils;

@Mapper(componentModel = "spring")
public interface UpdateTalkerMapper {

    @Mappings({
            @Mapping(target = "type", qualifiedByName = "toTypeEntity"),
            @Mapping(target = "currentlyState", source = "talker.location.state"),
            @Mapping(target = "currentlyCity", source = "talker.location.city"),
    })
    TalkerEntity map(Talker talker);

    @Condition
    default boolean isNotBlank(Object value) {
        if (value == null) {
            return false;
        }
        if (value.getClass().equals(String.class)) {
            return StringUtils.hasText(value.toString());
        }
        return true;
    }

    @Named(value = "toTypeEntity")
    default TalkerTypeEntity toTypeEntity(TalkerType type) {
        return new TalkerTypeEntity(type);
    }
}
