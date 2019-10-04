package com.tqb.score.serivce.impl;

import com.tqb.score.SearchVO;
import com.tqb.score.dao.SchoolMapper;
import com.tqb.score.pojo.School;
import com.tqb.score.pojo.SchoolExample;
import com.tqb.score.pojo.Score;
import com.tqb.score.serivce.ScoreService;
import com.tqb.score.utils.ZFsoft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ScoreServiceImpl
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/28 12:12
 * @Version v1.0
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired(required = false)
    private SchoolMapper schoolMapper;

    @Override
    public List<School> getSchoolList() {
        SchoolExample example = new SchoolExample();
        List<School> schools = schoolMapper.selectByExample(example);
        return schools;
    }

    @Override
    public List<Score> searchScore(SearchVO vo){
        School school = selectById(Integer.parseInt(vo.getSchool()));
        ZFsoft zFsoft = new ZFsoft(school.getWebsite(), school.getPublickeyUrl(), school.getCheckScoreUrl());
        List<Score> list =  zFsoft.login(vo.getStuNum(), vo.getPwd()).checkScore(vo.getXuenian(), vo.getXueqi());
        return list;
    }

    public School selectById(Integer id){
        School school = schoolMapper.selectByPrimaryKey(id);
        return school;
    }
}
