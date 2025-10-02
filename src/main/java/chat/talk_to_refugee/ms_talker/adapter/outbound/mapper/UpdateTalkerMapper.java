package chat.talk_to_refugee.ms_talker.adapter.outbound.mapper;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import org.mapstruct.*;
import org.springframework.util.StringUtils;

@Mapper(componentModel = "spring")
public interface UpdateTalkerMapper {

    @ToEntity
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(source = "source.location.state", target = "target.location.state"),
            @Mapping(source = "source.location.city", target = "target.location.city")
    })
    void update(Talker source, @MappingTarget Talker target);

    @Condition
    default boolean isNotBlank(Object value) {
        if (value == null) return false;
        if (value.getClass().equals(String.class)) return StringUtils.hasText((String) value);
        return true;
    }
}
