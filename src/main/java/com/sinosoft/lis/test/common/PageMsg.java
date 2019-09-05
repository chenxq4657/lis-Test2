package com.sinosoft.lis.test.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

/**
 * Created by cxq on 2019/8/23.
 */
@Data
public abstract class PageMsg<T1,T2> {
    private List<T2> records;
    private long total;
    private long size;
    private long current;
    private String message;
    private String flag;

    private PageMsg(){}

    public PageMsg(String flag,String message){
        this.message = message;
        this.flag = flag;
    }

    public void setRecords(IPage<T1> iPage){
        this.total = iPage.getTotal();
        this.size = iPage.getSize();
        this.current = iPage.getCurrent();
        this.records = this.entitiesToVoes(iPage.getRecords());
    }

    protected abstract List<T2> entitiesToVoes(List<T1> list);
}
