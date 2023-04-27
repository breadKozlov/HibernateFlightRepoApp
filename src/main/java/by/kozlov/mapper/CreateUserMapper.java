package by.kozlov.mapper;

import by.kozlov.dto.CreateUserDto;
import by.kozlov.entity.Birthday;
import by.kozlov.entity.Gender;
import by.kozlov.entity.Role;
import by.kozlov.entity.User;
import by.kozlov.utils.LocalDateFormatter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .nameUser(object.getName())
                .birthday(new Birthday(LocalDateFormatter.format(object.getBirthday())))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
