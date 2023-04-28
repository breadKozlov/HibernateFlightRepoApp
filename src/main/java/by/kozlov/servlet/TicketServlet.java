package by.kozlov.servlet;

import by.kozlov.dto.UserDto;
import by.kozlov.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
@Slf4j

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {

    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("The user: " + ((UserDto)req.getSession().getAttribute("user")).getName() + " incoming to page ticket");
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Long flightId = Long.valueOf(req.getParameter("flightId"));
        req.setAttribute("tickets", ticketService.findAllByFlightId(flightId));
        req.getRequestDispatcher("/WEB-INF/jsp/tickets.jsp").forward(req, resp);

    }
}
