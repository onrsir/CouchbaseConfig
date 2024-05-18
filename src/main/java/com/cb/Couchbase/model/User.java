package com.cb.Couchbase.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.UUID;

@Document
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private UUID id;
    private String name;
    private String email;
}
