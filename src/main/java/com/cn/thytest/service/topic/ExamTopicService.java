package com.cn.thytest.service.topic;

import com.cn.common.exception.FzlException;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.topic.ExamTopicDTO;
import com.cn.thytest.entity.topic.ExamTopic;
import org.springframework.validation.annotation.Validated;

/**
 * @Author fengzhilong
 * @Date 2020/9/30 17:02
 * @Desc //TODO
 **/
@Validated
public interface ExamTopicService {

    ResResult getExamTopicList(ExamTopicDTO examTopicDTO);

    ResResult removeTopic(ExamTopicDTO examTopicDTO) throws FzlException;

    ResResult deleteTopic(ExamTopicDTO examTopicDTO);

    ResResult addTopic(ExamTopic examTopic);
}
