package com.furniture.InventoryManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class DateSearchModel {


    @JsonProperty("fromDate")
    private LocalDate fromDate;

    @JsonProperty("toDate")
    private LocalDate toDate;

}
