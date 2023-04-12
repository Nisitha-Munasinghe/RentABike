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
    int rent;
    boolean firstAidKit;
    boolean milage;
    boolean transmission;
    boolean roadAssistance;
    boolean available;
}
