package com.powersi.material.service;

import com.powersi.material.pojo.ReceiveDetail;

import java.util.List;

public interface IReceiveDetailService {

    public void insertReceiveDetail(ReceiveDetail receiveDetail);
    public List<ReceiveDetail> findRecDetailByRecId(String id);
    public void updateReceiveDetail(ReceiveDetail receiveDetail);
}
