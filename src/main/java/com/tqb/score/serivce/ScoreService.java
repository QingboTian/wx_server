package com.tqb.score.serivce;

import com.tqb.score.SearchVO;
import com.tqb.score.pojo.School;
import com.tqb.score.pojo.Score;

import java.util.List;

/**
 * @InterfaceName ScoreService
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/28 12:11
 * @Version v1.0
 */
public interface ScoreService {
    List<School> getSchoolList();

    List<Score> searchScore(SearchVO vo) throws Exception;
}
