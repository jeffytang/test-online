package com.douma.controller;

import com.douma.entity.ApiResult;
import com.douma.entity.Score;
import com.douma.service.ScoreService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    /**
     * 根据id查询个人成绩
     * @param studentId
     * @return
     */
    @GetMapping("/score/{studentId}")
    public ApiResult findByStudentId(@PathVariable Integer studentId){
        List<Score> res = scoreService.findByStudentId(studentId);
        return ApiResultHandler.buildApiResult(200,"成功查询", res);
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

    /**
     * 添加一条分数记录
     * @param score
     * @return
     */
    @PostMapping("/score")
    public ApiResult add(@RequestBody Score score) {
        int res = scoreService.add(score);
        if (res == 0) {
            return ApiResultHandler.buildApiResult(400,"成绩添加失败",res);
        }else {
            return ApiResultHandler.buildApiResult(200,"成绩添加成功",res);
        }
    }

}
