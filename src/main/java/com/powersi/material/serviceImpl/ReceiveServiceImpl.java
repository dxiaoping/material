package com.powersi.material.serviceImpl;

import com.powersi.material.mapper.ReceiveMapper;
import com.powersi.material.pojo.Receive;
import com.powersi.material.service.IReceiveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReceiveServiceImpl implements IReceiveService {
    @Resource
    private ReceiveMapper receiveMapper;
    @Override
    public void insertReceive(Receive receive) {
        receiveMapper.insert(receive);
    }

    @Override
    public List<Receive> findAll() {
        return receiveMapper.selectByExample(null);
    }

    @Override
    public Receive findRecByRecId(String recId) {
        return receiveMapper.selectByPrimaryKey(recId);
    }

    @Override
    public void updateRec(Receive receive) {
        receiveMapper.updateByPrimaryKey(receive);
    }
}
