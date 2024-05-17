package com.ukd.userservice.mepper;

import com.ukd.userservice.client.dto.NoteDto;
import com.ukd.userservice.dto.UserWithNotesDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ukd.userservice.dto.CreateUserDto;
import com.ukd.userservice.entity.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    User toEntity(CreateUserDto user);

    @Mapping(target = "notes", source = "notes")
    @Mapping(target = "lastName", source = "user.lastName")
    UserWithNotesDto toUserWithNotesDto(User user, List<NoteDto> notes);
}
