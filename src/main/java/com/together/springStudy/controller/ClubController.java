package com.together.springStudy.controller;

import com.together.springStudy.model.ClubData;
import com.together.springStudy.model.UserData;
import com.together.springStudy.service.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/together/club")
@RequiredArgsConstructor
@RestController
public class ClubController {

    @Autowired
    ClubService clubService;

    @GetMapping("/createClub")
    public ResponseEntity<Void> createClub(ClubData clubData, Integer clubLeaderDid){
        log.debug("club info : {}", clubData);
        log.debug("club leader : {}", clubLeaderDid);
        Integer result = clubService.createClub(clubData);
        if (result.equals(1)) return ResponseEntity.status(HttpStatus.CREATED).build();
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getAllClub")
    public List<ClubData> getAllClub(){
        log.debug("getAllClub play.");
        List<ClubData> clubDataList = clubService.getAllClub();
        log.debug("club List : {}", clubDataList);
        return clubDataList;
//        clubDataList가 안 불러와졌을 때 Bad Request날릴 수 있어야할 듯?
//        if(clubDataList != null) return clubDataList;
//        else ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
