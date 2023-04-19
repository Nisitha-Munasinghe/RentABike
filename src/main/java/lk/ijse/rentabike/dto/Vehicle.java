package lk.ijse.rentabike.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Vehicle {
    String vehicleId;
    String vehicleName;
    String type;
    Double rent;
    String milage;
    String firstAidKit;
    String transmission;
    String roadAssistance;
    String available;
}
