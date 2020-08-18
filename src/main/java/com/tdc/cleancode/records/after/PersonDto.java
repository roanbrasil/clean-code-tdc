package com.tdc.cleancode.records.after;

import java.time.LocalDate;

public record PersonDto(String name, int document, String email, Address address, String phone,
                        LocalDate dateOfBirth) {
}
