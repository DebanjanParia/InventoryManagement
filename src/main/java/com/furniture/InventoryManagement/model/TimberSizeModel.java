package com.furniture.InventoryManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TimberSizeModel {


//    @JsonProperty("id")
//    private long id;

    @JsonProperty("productId")
    private long productId;

    @JsonProperty("length")
    private int length;

    @JsonProperty("width")
    private int width;

    @JsonProperty("height")
    private  int height;

    @JsonProperty("timberQuantity")
    private String timberQuantity;

}
