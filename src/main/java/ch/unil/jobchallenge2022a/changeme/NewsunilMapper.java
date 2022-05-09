package ch.unil.jobchallenge2022a.changeme;


import ch.unil.jobchallenge2022a.generated.jaxb.NewsunilType;

/**
 * Converter from a JAXB generated {@link NewsunilType} to a corresponding model
 * object: {@link News}.
 */
public interface NewsunilMapper {
    News convert(NewsunilType newsunilType);
}
