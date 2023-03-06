package com.sinarmas.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class PhoneBookRequestDto {

    private String phoneNumber;
    private String phoneName;
    private String address;
}
