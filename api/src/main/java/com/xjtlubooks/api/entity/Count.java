package com.xjtlubooks.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Document("count")
public class Count implements Serializable {
    private static final long serialVersionUID = 10087L;
    @Id
    private String id;
    private String name;
}
