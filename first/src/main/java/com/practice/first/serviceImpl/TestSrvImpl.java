package com.practice.first.serviceImpl;

import com.practice.first.dto.FriendDto;
import com.practice.first.dto.TestDto;
import com.practice.first.service.TestSrv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class TestSrvImpl implements TestSrv {

    @Override
    public TestDto getTest(TestDto testDto) {

        final Predicate<Integer> greaterThanFive = a -> a > 5;
        Integer optInt = Optional.ofNullable(testDto)
                .map(TestDto::getIntegers)
                .map(List::size)
                .filter(greaterThanFive)
                .orElse(0);

        Optional.ofNullable(testDto)
                .map(TestDto::getId)
                .ifPresent(id -> {
                    log.info("TODO MAL"  + id);

                });

//        List<Integer> transactionsIds =
//                transactions.stream()
//                        .filter(t -> t.getType() == Transaction.GROCERY)
//                        .sorted(comparing(Transaction::getValue).reversed())
//                        .map(Transaction::getId)
//                        .collect(toList());

        List<TestDto> dtos = new ArrayList<>();

        Map<String, TestDto> nameTestMap = dtos.stream().collect(Collectors.toMap(TestDto::getName, Function.identity()));

        TestDto out = new TestDto();



        return out;

    }

}
