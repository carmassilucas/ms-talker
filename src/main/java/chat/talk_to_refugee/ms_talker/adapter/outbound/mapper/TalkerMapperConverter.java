package chat.talk_to_refugee.ms_talker.adapter.outbound.mapper;

import chat.talk_to_refugee.ms_talker.adapter.outbound.repository.TalkerTypeEntity;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import org.mapstruct.Named;

public interface TalkerMapperConverter {

    @Named(value = "toTypeEntity")
    default TalkerTypeEntity toTypeEntity(TalkerType type) {
        return new TalkerTypeEntity(type.getId(), type.getDescription());
    }
}
