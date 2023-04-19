package lk.ijse.rentabike.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class VehicleTm {
    String vehicleId;
    String vehicleName;
    String vehicleType;
    Double vehicleRent;
    String vehicleMilage;
    String vehicleFirstAidKit;
    String vehicleTransmission;
    String vehicleRoadAssistance;
    String vehicleAvailale;

}
