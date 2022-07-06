package org.poem.biz.model;

import java.io.Serializable;

/**
 * @author xuxueli 2020-04-11 22:27
 */
public class IdleBeatParam implements Serializable {
    private static final long serialVersionUID = 42L;

    public IdleBeatParam() {
    }
    public IdleBeatParam(Long jobId) {
        this.jobId = jobId;
    }

    private Long jobId;


    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

}