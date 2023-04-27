package by.kozlov.dto;

import lombok.Value;

@Value
public class TicketDto {
    private Long id;
    private Long flightId;
    private String seatNo;
}
