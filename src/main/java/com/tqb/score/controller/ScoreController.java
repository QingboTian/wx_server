package com.tqb.score.controller;

import com.tqb.common.WXResult;
import com.tqb.score.SearchVO;
import com.tqb.score.pojo.School;
import com.tqb.score.pojo.Score;
import com.tqb.score.serivce.ScoreService;
import com.tqb.score.serivce.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ScoreController
 * @Description: 查询学校信息
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/28 11:48
 * @Version v1.0
 */
@RestController
@RequestMapping("/score/")
@Slf4j
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("list/school")
    public WXResult<List<School>> schoolList() {
        List<School> schoolList = scoreService.getSchoolList();
        return new WXResult<List<School>>(schoolList);
    }

    @RequestMapping("list/score")
    public WXResult<List<Score>> scoreList(SearchVO vo) {
        List<Score> scores = null;
        try {
            scores = scoreService.searchScore(vo);
            if (scores != null && scores.size() != 0)
                return new WXResult<List<Score>>(scores);
            else
                return new WXResult<List<Score>>(scores, "error", "当前无成绩信息");
        } catch (Exception e) {
            return new WXResult<List<Score>>(scores, "error", "请检查学号密码是否输入正确！");
        }
    }

    @RequestMapping("check")
    public void check(String school, String stuNum, String pwd){
        // 对用户数据进行存储
        boolean isExit = studentService.isExit(stuNum);
        if (!isExit){
            SearchVO vo = new SearchVO();
            vo.setSchool(school);
            vo.setStuNum(stuNum);
            vo.setPwd(pwd);
            studentService.add(vo);
        }
    }

}
