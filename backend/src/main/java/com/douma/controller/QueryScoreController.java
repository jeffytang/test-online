package com.douma.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ApiResult;
import com.douma.entity.ExamManager;
import com.douma.entity.Score;
import com.douma.service.QueryScoreService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryScoreController {
    @Autowired
    private QueryScoreService scoreService;
    /**
     * 根据id查询个人成绩
     * @param studentId
     * @return
     */
    @GetMapping("/score/{studentId}")
    public ApiResult findById(@PathVariable Integer studentId){
        List<Score> res = scoreService.findById(studentId);
        return ApiResultHandler.buildApiResult(200,"成功查询", res);
    }

    /**
     * 分页查询所有试卷信息
     */
    @GetMapping("/exams/{page}/{size}")
    public ApiResult findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        Page<ExamManager> examManager = new Page<>(page,size);
        IPage<ExamManager> res = scoreService.findAll(examManager);
        if (res != null){
            return ApiResultHandler.buildApiResult(200, "成功查询", res);
        }else {
            return ApiResultHandler.buildApiResult(403, "查询错误", null);
        }
    }

    /**
     * 查询学生学科的分数
     * @param examCode
     * @return
     */
    @GetMapping("/scores/{examCode}")
    public ApiResult findByExamCode(@PathVariable("examCode") Integer examCode){
        List<Score> res = scoreService.fondByExamCode(examCode);
        return ApiResultHandler.buildApiResult(200, "成功查询", res);
    }


    /*@GetMapping("/scores")
    public ApiResult findAll() {
        List<Score> res = scoreService.findAll();
        return ApiResultHandler.buildApiResult(200,"查询所有学生成绩",res);
    }
    //    分页
    @GetMapping("/score/{page}/{size}/{studentId}")
    public ApiResult findById(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("studentId") Integer studentId) {
        Page<Score> scorePage = new Page<>(page, size);
        IPage<Score> res = scoreService.findById(scorePage, studentId);
        return ApiResultHandler.buildApiResult(200, "根据ID查询成绩", res);
    }*/
}
