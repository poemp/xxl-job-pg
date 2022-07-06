package org.poem.service.impl;

import org.poem.core.model.XxlJobInfo;
import org.poem.core.model.XxlJobLog;
import org.poem.core.thread.JobCompleteHelper;
import org.poem.core.thread.JobRegistryHelper;
import org.poem.core.thread.JobTriggerPoolHelper;
import org.poem.core.trigger.TriggerTypeEnum;
import org.poem.core.util.I18nUtil;
import org.poem.dao.XxlJobGroupDao;
import org.poem.dao.XxlJobInfoDao;
import org.poem.dao.XxlJobLogDao;
import org.poem.dao.XxlJobRegistryDao;
import org.poem.biz.AdminBiz;
import org.poem.biz.model.HandleCallbackParam;
import org.poem.biz.model.RegistryParam;
import org.poem.biz.model.ReturnT;
import org.poem.handler.IJobHandler;
import org.poem.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuxueli 2017-07-27 21:54:20
 */
@Service
public class AdminBizImpl implements AdminBiz {


    @Override
    public ReturnT<String> callback(List<HandleCallbackParam> callbackParamList) {
        return JobCompleteHelper.getInstance().callback(callbackParamList);
    }

    @Override
    public ReturnT<String> registry(RegistryParam registryParam) {
        return JobRegistryHelper.getInstance().registry(registryParam);
    }

    @Override
    public ReturnT<String> registryRemove(RegistryParam registryParam) {
        return JobRegistryHelper.getInstance().registryRemove(registryParam);
    }

}
