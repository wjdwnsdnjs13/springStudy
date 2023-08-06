package com.together.springStudy.mapper;

import com.together.springStudy.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClubMapper {
    int createClub(ClubData clubData);
    int createClubMaster(ClubMember clubMember);

    List<ClubData> getAllClub();

    List<ClubJoinQueue> getJoinClubQueue(int clubId);

    List<ClubMemberData> getClubMemberByClubId(int clubId);

    ClubData getClubByPrimaryKey(int clubId);
    int joinClub(ClubJoinQueue clubJoinQueue);

    int joinClubApproval(ClubJoinQueue clubJoinQueue);
    int deleteJoinClub(int joinQueueId);
}
