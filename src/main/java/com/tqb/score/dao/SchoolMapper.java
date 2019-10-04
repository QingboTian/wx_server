package com.tqb.score.dao;

import com.tqb.score.pojo.School;
import com.tqb.score.pojo.SchoolExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface SchoolMapper {
    @SelectProvider(type=SchoolSqlProvider.class, method="countByExample")
    int countByExample(SchoolExample example);

    @DeleteProvider(type=SchoolSqlProvider.class, method="deleteByExample")
    int deleteByExample(SchoolExample example);

    @Delete({
        "delete from school",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into school (id, name, ",
        "website, publickey_url, ",
        "check_score_url)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{website,jdbcType=VARCHAR}, #{publickeyUrl,jdbcType=VARCHAR}, ",
        "#{checkScoreUrl,jdbcType=VARCHAR})"
    })
    int insert(School record);

    @InsertProvider(type=SchoolSqlProvider.class, method="insertSelective")
    int insertSelective(School record);

    @SelectProvider(type=SchoolSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="website", property="website", jdbcType=JdbcType.VARCHAR),
        @Result(column="publickey_url", property="publickeyUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_score_url", property="checkScoreUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<School> selectByExample(SchoolExample example);

    @Select({
        "select",
        "id, name, website, publickey_url, check_score_url",
        "from school",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="website", property="website", jdbcType=JdbcType.VARCHAR),
        @Result(column="publickey_url", property="publickeyUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_score_url", property="checkScoreUrl", jdbcType=JdbcType.VARCHAR)
    })
    School selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SchoolSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolExample example);

    @UpdateProvider(type=SchoolSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") School record, @Param("example") SchoolExample example);

    @UpdateProvider(type=SchoolSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(School record);

    @Update({
        "update school",
        "set name = #{name,jdbcType=VARCHAR},",
          "website = #{website,jdbcType=VARCHAR},",
          "publickey_url = #{publickeyUrl,jdbcType=VARCHAR},",
          "check_score_url = #{checkScoreUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(School record);
}