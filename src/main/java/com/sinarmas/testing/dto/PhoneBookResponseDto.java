package com.sinarmas.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PhoneBookResponseDto {
    private String id;
    private String phoneNumber;
    private String phoneName;
    private String address;
    private String updatedAt;
}
