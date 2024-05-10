package com.alperen.dto.response;

import com.alperen.entity.superclasses.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarResponseDto {

    Car car;
    List<String> imageUrls;
}
