package com.powersi.material.pojo.responseBody;

import com.powersi.material.pojo.Supplier;
import lombok.Data;

import java.util.List;
@Data
public class RemainDetailTimesSupRes {

    private List<Integer> times;

    private List<Supplier> suppliers;

}
