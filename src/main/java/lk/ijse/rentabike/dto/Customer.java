package lk.ijse.rentabike.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Customer {
    private String customerId;
    private String fullName;
    private int age;
    private String phoneNumber;
    private String Email;
    private String Address;
    private String city;
    private String country;
    private String zipCode;


}
