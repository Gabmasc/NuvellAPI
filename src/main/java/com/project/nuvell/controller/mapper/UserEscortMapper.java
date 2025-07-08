package com.project.nuvell.controller.mapper;

import com.project.nuvell.controller.dto.UserEscortDTO;
import com.project.nuvell.entity.UserEscort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserEscortMapper {

    @Mappings({
            @Mapping(target = "socialName", expression = "java(userEscort.getSocialName())"),
            @Mapping(target = "firstName", expression = "java(userEscort.getFirstName())"),
            @Mapping(target = "lastName", expression = "java(userEscort.getLastName())"),
            @Mapping(target = "gender", expression = "java(userEscort.getGender())"),
            @Mapping(target = "age", expression = "java(userEscort.getAge())"),
    })
    UserEscortDTO entityToDTO(UserEscort userEscort);

    @Mappings({
            @Mapping(target = "socialName", expression = "java(New SocialName(dto.getSocialName()))"),
            @Mapping(target = "firstName", expression = "java(New FirstName(dto.getFirstName()))"),
            @Mapping(target = "lastName", expression = "java(New LastName(dto.getLastName()))"),
            @Mapping(target = "gender", expression = "java(New Gender(dto.getGender()))"),
            @Mapping(target = "age", expression = "java(New Age(dto.getAge()))"),
    })
    UserEscort dtoToEntity(UserEscortDTO dto);
}
