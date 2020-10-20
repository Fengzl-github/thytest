package com.cn.thytest.service.topic.impl;

import com.cn.common.exception.FzlException;
import com.cn.common.jpa.util.PageUtil;
import com.cn.common.jpa.vo.Pageparam;
import com.cn.common.utils.DateTime;
import com.cn.common.utils.myString;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dao.topic.ExamTopicDao;
import com.cn.thytest.dto.topic.ExamTopicDTO;
import com.cn.thytest.entity.topic.ExamTopic;
import com.cn.thytest.service.topic.ExamTopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengzhilong
 * @Date 2020/9/30 17:04
 * @Desc //TODO
 **/
@Slf4j
@Service
public class ExamTopicServiceImpl implements ExamTopicService {

    @Resource
    private ExamTopicDao examTopicDao;

    @Override
    public ResResult getExamTopicList(ExamTopicDTO examTopicDTO) throws FzlException{

        ExamTopic examTopic = new ExamTopic();
        examTopic.setTpName(examTopicDTO.getTpName());
        examTopic.setFounder(examTopicDTO.getFounder());
        Pageparam pageparam = new Pageparam();
        pageparam.setPagesize(examTopicDTO.getPagesize());
        pageparam.setCurrentPage(examTopicDTO.getCurrentPage());
        Specification<ExamTopic> specification = new Specification<ExamTopic>() {
            @Override
            public Predicate toPredicate(Root<ExamTopic> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (myString.isNotEmpty(examTopic.getTpName())){
                    predicateList.add(criteriaBuilder.like(root.get("tpName"), "%"+examTopic.getTpName()+"%"));
                }
                if (myString.isNotEmpty(examTopic.getFounder())){
                    predicateList.add(criteriaBuilder.like(root.get("founder"), "%"+examTopic.getFounder()+"%"));
                }

                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

        Pageable pageable = PageUtil.getPageable(pageparam.getCurrentPage(), pageparam.getPagesize(), "tpId");
        Page<ExamTopic> page = examTopicDao.findAll(specification,pageable);
        return ResCode.OK.msg("查询成功")
                .putData("total", page.getTotalElements())
                .putData("content", page.getContent());
    }

    @Override
    public ResResult removeTopic(ExamTopicDTO examTopicDTO) throws FzlException{

        if (myString.isNotEmpty(examTopicDTO.getTpId())){
            int nRemove = examTopicDao.removeTopic(examTopicDTO.getTpId(), examTopicDTO.getStatus());
            if (nRemove == 1){
                return ResCode.OK.msg("操作成功！");
            }else {
                return ResCode.ERROR.msg("操作失败！");
            }
        }else {
            return ResCode.ERROR.msg("缺少参数");
        }
    }

    @Override
    public ResResult deleteTopic(ExamTopicDTO examTopicDTO) throws FzlException{

        if (myString.isNotEmpty(examTopicDTO.getTpId())){
            int nRemove = examTopicDao.deleteTopic(examTopicDTO.getTpId());
            if (nRemove == 1){
                return ResCode.OK.msg("删除成功！");
            }else {
                return ResCode.ERROR.msg("删除失败！");
            }
        }else {
            return ResCode.ERROR.msg("缺少参数");
        }
    }

    @Override
    public ResResult addTopic(ExamTopic examTopic) throws FzlException {

        //新增
        if (myString.isEmpty(examTopic)){
            examTopic.setTpId(DateTime.Now().ToString("yyyyMMddHHmmss")+ myString.getRandom(4));
            examTopic.setUid("8600");
        }
        ExamTopic examTopic1 = examTopicDao.saveAndFlush(examTopic);
        return ResCode.OK.msg("添加成功！");
    }
}
