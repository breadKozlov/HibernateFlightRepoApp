package by.kozlov.servlet;

import by.kozlov.dto.CreateUserDto;
import by.kozlov.entity.Gender;
import by.kozlov.entity.Role;
import by.kozlov.exception.ValidationException;
import by.kozlov.service.UserService;
import by.kozlov.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static by.kozlov.utils.UrlPath.REGISTRATION;

@Slf4j
@WebServlet(REGISTRATION)
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", Role.values());
        req.setAttribute("genders", Gender.values());
        log.info("User wants to register");
        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userDto = CreateUserDto.builder()
                .name(req.getParameter("name"))
                .birthday(req.getParameter("birthday"))
                .email(req.getParameter("email"))
                .password(req.getParameter("pwd"))
                .role(req.getParameter("role"))
                .gender(req.getParameter("gender"))
                .build();
        try {
            userService.create(userDto);
            resp.sendRedirect("./login");
        } catch (ValidationException exception) {
            req.setAttribute("errors", exception.getErrors());
            log.error("Registration error: " + exception.getErrors());
            doGet(req, resp);
        }

    }
}
