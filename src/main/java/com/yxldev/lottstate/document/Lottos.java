package com.yxldev.lottstate.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

import org.bson.types.ObjectId;

@Data
@Document(collection = "lottos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lottos {
    @Id
    private ObjectId _id;
    private String lottoId;
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private String c5;
    private String c6;
    private String c7;
    private Instant openDate;
}
