package com.xjtlubooks.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Document("count")
public class Count implements Serializable {
    private static final long serialVersionUID = 10087L;

    private int countTimes;
}