package com.powersi.material.serviceImpl;

import com.powersi.material.mapper.ReceiveDetailMapper;
import com.powersi.material.pojo.ReceiveDetail;
import com.powersi.material.pojo.ReceiveDetailExample;
import com.powersi.material.service.IReceiveDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReceiveDetailImpl implements IReceiveDetailService {
    @Resource
    private ReceiveDetailMapper receiveDetailMapper;
    @Override
    public void insertReceiveDetail(ReceiveDetail receiveDetail) {

        receiveDetailMapper.insert(receiveDetail);
    }

    @Override
    public List<ReceiveDetail> findRecDetailByRecId(String id) {
        ReceiveDetailExample example=new ReceiveDetailExample();
        ReceiveDetailExample.Criteria criteria = example.createCriteria();
        criteria.andReceIdEqualTo(id);
        return receiveDetailMapper.selectByExample(example);
    }

    @Override
    public void updateReceiveDetail(ReceiveDetail receiveDetail) {
        receiveDetailMapper.updateByPrimaryKey(receiveDetail);
    }
}
