package ch.unil.jobchallenge2022a.changeme;

import ch.unil.jobchallenge2022a.generated.jaxb.NewsunilType;
import org.mapstruct.Mapper;

/**
 * Implementation of {@link NewsunilMapper} converter as a Spring Bean using MapStruct mapper.
 */
@Mapper(componentModel = "spring")
public abstract class MapStructNewsunilMapper implements NewsunilMapper {
    abstract News map(NewsunilType newsunilType);

    @Override
    public News convert(NewsunilType newsunilType) {
        return this.map(newsunilType);
    }
}
