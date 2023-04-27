package by.kozlov.mapper;

import by.kozlov.convertor.BirthdayConvertor;
import by.kozlov.dto.UserDto;
import by.kozlov.entity.User;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper implements Mapper<User, UserDto> {

    private static final UserMapper INSTANCE = new UserMapper();
    private final BirthdayConvertor birthdayConvertor = new BirthdayConvertor();

    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getNameUser())
                .birthday(birthdayConvertor.convertToDatabaseColumn(object.getBirthday()).toLocalDate())
                .email(object.getEmail())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}