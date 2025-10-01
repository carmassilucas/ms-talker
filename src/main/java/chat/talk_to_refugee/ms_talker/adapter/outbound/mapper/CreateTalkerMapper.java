package chat.talk_to_refugee.ms_talker.adapter.outbound.mapper;

import chat.talk_to_refugee.ms_talker.adapter.outbound.repository.TalkerEntity;
import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CreateTalkerMapper extends TalkerMapperConverter {

    @ToEntity
    @Mappings({
            @Mapping(target = "profilePhoto", ignore = true),
            @Mapping(target = "currentlyState", ignore = true),
            @Mapping(target = "currentlyCity", ignore = true),
            @Mapping(target = "aboutMe", ignore = true)
    })
    TalkerEntity map(Talker talker);
}
