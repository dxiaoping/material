package com.powersi.material.mapper;

import com.powersi.material.pojo.RepoRemain;
import com.powersi.material.pojo.RepoRemainDetail;
import com.powersi.material.pojo.RepoRemainExample;
import com.powersi.material.pojo.responseBody.ClassRemainRes;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface RepoRemainMapper {
    int countByExample(RepoRemainExample example);

    int deleteByExample(RepoRemainExample example);

    int deleteByPrimaryKey(String id);
    List<RepoRemainDetail> selectByTime(Date startTime, Date endTime,@Param("itemClass")List<Integer> itemClass);

    int insert(RepoRemain record);

    int insertSelective(RepoRemain record);

    List<RepoRemain> selectByExample(RepoRemainExample example);

    RepoRemain selectByPrimaryKey(String id);
    RepoRemain selectByItemId(String itemId);

    int updateByExampleSelective(@Param("record") RepoRemain record, @Param("example") RepoRemainExample example);

    int updateByExample(@Param("record") RepoRemain record, @Param("example") RepoRemainExample example);

    int updateByPrimaryKeySelective(RepoRemain record);

    int updateByPrimaryKey(RepoRemain record);

    @Select("select\n" +
            "ic.id,ic.item_class_name,sum(c.totalRemain) AS allTotalRemain\n" +
            "from\n" +
            "(select\n" +
            "ic.item_class_father,ic.item_class_name,sum( rr.total_remain ) as totalRemain\n" +
            "from \n" +
            "item i,item_class ic,repo_remain rr\n" +
            "where \n" +
            "i.item_class_id = ic.id and rr.item_id = i.id\n" +
            "GROUP BY\n" +
            "ic.id) as c,item_class ic\n" +
            "where \n" +
            "c.item_class_father = ic.id\n" +
            "GROUP BY\n" +
            "ic.id")
    List<ClassRemainRes> getAllClassRemain();

    @Select("select\n" +
            "ic.id,ic.item_class_name,sum( rr.total_remain ) as allTotalRemain\n" +
            "from \n" +
            "item i,item_class ic,repo_remain rr\n" +
            "where \n" +
            "i.item_class_id = ic.id and rr.item_id = i.id and ic.item_class_father = #{classId} \n" +
            "GROUP BY\n" +
            "ic.id")
    List<ClassRemainRes> getOneClassRemain(@Param("classId") Integer classId);
}
