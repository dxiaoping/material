package com.powersi.material.serviceImpl;

import com.powersi.material.mapper.ReceiveDetailMapper;
import com.powersi.material.pojo.ReceiveDetail;
import com.powersi.material.service.IReceiveDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReceiveDetailImpl implements IReceiveDetailService {
    @Resource
    private ReceiveDetailMapper receiveDetailMapper;
    @Override
    public void insertReceiveDetail(ReceiveDetail receiveDetail) {

        receiveDetailMapper.insert(receiveDetail);
    }
}
