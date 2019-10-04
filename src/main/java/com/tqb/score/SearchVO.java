package com.tqb.score;

import lombok.Data;

/**
 * @ClassName SearchVO
 * @Description: TODO
 * @Author 田清波
 * @Mail tqb820965236@163.com
 * @Date 2019/7/28 14:37
 * @Version v1.0
 */
@Data
public class SearchVO {
    private String school;// int值 学校id
    private String xuenian;// 学年
    private String xueqi;// 学期
    private String stuNum;// 学号
    private String pwd;// 密码
}
