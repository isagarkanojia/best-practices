package com.software.practices.solutions.traffic.split.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BucketInfo {
    private final char bucketId;
    private final int weight;

}

