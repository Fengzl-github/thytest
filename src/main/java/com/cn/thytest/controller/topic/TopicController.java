package com.cn.thytest.controller.topic;

import com.cn.common.exception.FzlException;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.topic.ExamTopicDTO;
import com.cn.thytest.entity.topic.ExamTopic;
import com.cn.thytest.service.topic.ExamTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author fengzhilong
 * @Date 2020/9/30 16:39
 * @Desc //TODO
 **/
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private ExamTopicService examTopicService;

    /**
     * @Author fengzhilong
     * @Desc //TODO 获取全类型题库
     * @Date 2020/9/30 18:23
     * @param examTopicDTO
     * @return com.cn.common.vo.ResResult
     **/
    @PostMapping("/getexamtopiclist")
    public ResResult getExamTopicList(@RequestBody ExamTopicDTO examTopicDTO) throws FzlException {

        return examTopicService.getExamTopicList(examTopicDTO);

    }


    /**
     * @Author fengzhilong
     * @Desc //TODO 禁用题目
     * @Date 2020/10/9 15:21
     * @Param [tpId]
     * @return com.cn.common.vo.ResResult
     **/
    @PostMapping("/removetopic")
    public ResResult removeTopic(@RequestBody ExamTopicDTO examTopicDTO) throws FzlException {

        return examTopicService.removeTopic(examTopicDTO);

    }


    /**
     * @Author fengzhilong
     * @Desc //TODO 删除题目
     * @Date 2020/10/9 15:26
     * @Param [tpId]
     * @return com.cn.common.vo.ResResult
     **/
    @PostMapping("/deletetopic")
    public ResResult deleteTopic(@RequestBody ExamTopicDTO examTopicDTO) throws FzlException {

        return examTopicService.deleteTopic(examTopicDTO);

    }


    /**
     * @Author fengzhilong
     * @Desc //TODO 新增题目
     * @Date 2020/10/9 15:46
     * @Param [examTopic]
     * @return com.cn.common.vo.ResResult
     **/
    @PostMapping("/addtopic")
    public ResResult addTopic(@RequestBody ExamTopic examTopic) throws FzlException {

        return examTopicService.addTopic(examTopic);

    }
}
