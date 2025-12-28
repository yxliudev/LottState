package com.yxldev.lottstate.helper;

import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;

import com.yxldev.lottstate.document.Lottos;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class mongoHelper {
    private final MongoTemplate lottoMongoTemplate;

    public List<Lottos> findLottosByOpenDate(String openDate) {
        Query query = new Query(Criteria.where("openDate").is(openDate));
        return lottoMongoTemplate.find(query, Lottos.class);
    }

    public List<Lottos> findLottosByOpenDate(String openDate, int page, int size) {
        Query query = new Query(Criteria.where("openDate").is(openDate))
                .skip((long) page * size)
                .limit(size);
        return lottoMongoTemplate.find(query, Lottos.class);
    }

    public List<Lottos> findLottosStartFromOpenDateByScanCount(String openDate, int scanCount) {
        Query query = new Query(Criteria.where("openDate").gte(openDate))
                .with(Sort.by(Sort.Direction.DESC, "openDate"))
                .limit(scanCount);
        return lottoMongoTemplate.find(query, Lottos.class);
    }

}
