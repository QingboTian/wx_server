package com.tqb.score.serivce;

import com.tqb.score.SearchVO;

/**
 * @InterfaceName StudentService
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/29 12:39
 * @Version v1.0
 */
public interface StudentService {
    boolean isExit(String stuNum);

    void add(SearchVO vo);
}
