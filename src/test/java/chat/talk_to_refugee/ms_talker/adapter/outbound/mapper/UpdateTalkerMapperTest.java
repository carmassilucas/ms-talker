package chat.talk_to_refugee.ms_talker.adapter.outbound.mapper;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerLocation;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import chat.talk_to_refugee.ms_talker.util.DataProviderUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(classes = { UpdateTalkerMapperImpl.class })
class UpdateTalkerMapperTest {

    @Autowired
    private UpdateTalkerMapper mapper;

    @Test
    @DisplayName("Deve atualizar apenas com valores válidos os campos mapeados")
    void should_only_update_mapped_fields_with_valid_values() {
        var now = Instant.now();
        var source = new Talker(
                UUID.randomUUID(),
                "Jane Doe",
                LocalDate.now().minusYears(25),
                "Pseudônimo usado para ocultar verdadeiro nome",
                "s3:/profile-photos/jane-doe.jpg",
                new TalkerLocation("US", "Update City"),
                TalkerType.Value.IMMIGRANT.get(),
                "jane.doe@t2r.com",
                "jane.doe",
                false,
                now,
                now
        );

        var target = DataProviderUtil.getSampleDomain();

        this.mapper.update(source, target);

        assertThat(target).usingRecursiveComparison()
                .comparingOnlyFields(
                        "fullName",
                        "birthDate",
                        "aboutMe",
                        "profilePhoto",
                        "location.state",
                        "location.city",
                        "type",
                        "password",
                        "active"
                )
                .isEqualTo(source);

        assertThat(target).usingRecursiveComparison()
                .comparingOnlyFields(
                        "id",
                        "email",
                        "createdAt",
                        "updatedAt"
                )
                .isNotEqualTo(source);
    }

    @Test
    @DisplayName("Deve não atualizar quando valor nulo ou vazio")
    void should_not_update_when_value_null_or_empty() {
        var source = new Talker();
        var target = DataProviderUtil.getSampleDomain();

        this.mapper.update(source, target);

        assertThat(target).usingRecursiveComparison()
                .comparingOnlyFields(
                        "id",
                        "fullName",
                        "birthDate",
                        "aboutMe",
                        "profilePhoto",
                        "location.state",
                        "location.city",
                        "type",
                        "email",
                        "password",
                        "active",
                        "createdAt",
                        "updatedAt"
                )
                .isNotEqualTo(source);
    }
}