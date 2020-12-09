package com.douma.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ApiResult;
import com.douma.entity.ExamManager;
import com.douma.service.ExamService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {
    @Autowired
    private ExamService examService;
    /**
     * 分页查询所有试卷信息
     */
    @GetMapping("/exams/{page}/{size}")
    public ApiResult findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<ExamManager> examManager = new Page<>(page,size);
        IPage<ExamManager> res = examService.findAll(examManager);
        if (res != null){
            return ApiResultHandler.buildApiResult(200, "成功查询", res);
        }else {
            return ApiResultHandler.buildApiResult(403, "查询错误", null);
        }
    }

    /**
     * 不进行分页查询所有试卷
     * 此时前端报 Cannot read property 'includes' of null 错误应该是页面没有连接，
     * 所以无法自动跳转到页面所出现的错误，下一步修改点击试卷信息会弹出一个界面，
     * 预计此时错误会解决
     * @return
     */
    @GetMapping("/exams")
    public ApiResult findAllUnPage(){
        List<ExamManager> res = examService.findAllUnPage();
        if (res != null){
            return ApiResultHandler.buildApiResult(200, "成功查询", res);
        }else {
            return ApiResultHandler.buildApiResult(403, "查询错误", null);
        }
    }

    @GetMapping("/examManagePaperId")
    public ApiResult findByPaperId(){
        ExamManager res = examService.findByPaperId();
        return ApiResultHandler.buildApiResult(200,"查询成功", res);
    }

    /**
     * 添加考试信息
     * @param examManager
     * @return
     */
    @PostMapping("/exam")
    public ApiResult add(@RequestBody ExamManager examManager){
        int res = examService.add(examManager);
        return ApiResultHandler.buildApiResult(200, "成功添加", res);
    }

    /**
     * 根据 examCode 查询 试卷信息
     * @param examCode
     * @return
     */
    @GetMapping("/exam/{examCode}")
    public ApiResult findByExamCode(@PathVariable Integer examCode){
        ExamManager res = examService.findByExamCode(examCode);
        return ApiResultHandler.buildApiResult(200,"成功查询", res);
    }

    /**
     * 根据查询到的试卷信息，进行修改并保存
     * @param examManager
     * @return
     */
    @PutMapping("/exam")
    public ApiResult save(@RequestBody ExamManager examManager){
        int res = examService.save(examManager);
        return ApiResultHandler.buildApiResult(200,"修改成功", res);
    }

    @DeleteMapping("/exam/{examCode}")
    public ApiResult move(@PathVariable("examCode") Integer examCode){
        int res = examService.move(examCode);
        return ApiResultHandler.buildApiResult(200,"删除成功", res);
    }

}
