package by.kozlov.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "flight",schema = "public")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "flight_no")
    private String flightNo;
    @Column(name = "departure_date")
    private LocalDateTime departureDate;
    @Column(name = "departure_airport_code")
    private String departureAirportCode;
    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;
    @Column(name = "arrival_airport_code")
    private String arrivalAirportCode;
    @Column(name = "aircraft_id")
    private Integer aircraftId;
    @Enumerated(EnumType.STRING)
    private FlightStatus status;
}
