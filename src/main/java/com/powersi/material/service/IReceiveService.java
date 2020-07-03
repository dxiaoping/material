package com.powersi.material.service;

import com.powersi.material.pojo.Receive;

import java.util.List;

public interface IReceiveService {

    public void insertReceive(Receive receive);
    public List<Receive> findAll();
    public Receive findRecByRecId(String recId);
}
