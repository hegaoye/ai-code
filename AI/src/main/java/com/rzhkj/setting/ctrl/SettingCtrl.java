/*
 *  Copyright (c) 2017. 郑州仁中和科技有限公司.保留所有权利.
 *                        http://www.rzhkj.com/
 *        郑州仁中和科技有限公司保留所有代码著作权.如有任何疑问请访问官方网站与我们联系.
 *        代码只针对特定客户使用，不得在未经允许或授权的情况下对外传播扩散.恶意传播者，法律后果自行承担.
 *        本代码仅用于龐帝業務系统.
 *
 */

package com.rzhkj.setting.ctrl;

import com.google.common.collect.Maps;
import com.rzhkj.core.base.BaseUploadCtrl;
import com.rzhkj.core.entity.BeanRet;
import com.rzhkj.core.exceptions.BaseException;
import com.rzhkj.setting.entity.Setting;
import com.rzhkj.setting.service.SettingSV;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 系统中的参数设置
 * Created by lixin on 2017/6/3.
 */
@Controller
@RequestMapping("/setting")
@Api(value = "系统中的参数设置", description = "系统中的参数设置接口")
public class SettingCtrl extends BaseUploadCtrl {
    private final static Logger logger = LoggerFactory.getLogger(SettingCtrl.class);

    @Resource
    private SettingSV settingSV;


    /**
     * 加载一个系统中的参数设置
     *
     * @return BeanRet
     */
    @ApiOperation(value = "加载一个系统中的参数设置", notes = "加载一个系统中的参数设置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "k", value = "键", required = true, paramType = "query")
    })
    @GetMapping("/loadset")
    @ResponseBody
    public BeanRet loadSetting(String k) {
        try {
            logger.info("加载一个系统中的参数设置 k : ====> " + k);
            Assert.hasText(k, BaseException.BaseExceptionEnum.Empty_Param.toString());
            Map<String, Object> map = Maps.newHashMap();
            map.put("k", k);
            Setting setting = settingSV.load(map);
            return BeanRet.create(true, "Load Setting info Success!", setting.getV());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return BeanRet.create(false, "Load Setting info failed!");
        }
    }


    /**
     * 修改设置值
     *
     * @param setting 设置对象
     * @return BeanRet
     */
    @ApiOperation(value = "修改设置值", notes = "修改设置值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "k", value = "键", required = true, paramType = "query"),
            @ApiImplicitParam(name = "v", value = "值", required = true, paramType = "query"),
            @ApiImplicitParam(name = "summary", value = "说明", paramType = "query")
    })
    @PostMapping("/modifyset")
    @ResponseBody
    public BeanRet modifySetting(@ApiIgnore Setting setting) {
        try {
            Assert.notNull(setting, BaseException.BaseExceptionEnum.Empty_Param.toString());
            settingSV.modifySetting(setting);
            return BeanRet.create(true, "Modify Success!");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return BeanRet.create(false, "Modify failed!");
        }
    }


    /**
     * 查询所有设置参数
     *
     * @return
     */
    @ApiOperation(value = "查询所有设置参数")
    @GetMapping(value = "/settings")
    @ResponseBody
    public BeanRet settingList() {
        try {
            List<Setting> settings = settingSV.listSetting();
            return BeanRet.create(true, "", settings);
        } catch (Exception e) {
            return BeanRet.create(e.getMessage());
        }
    }


    /**
     * 查询所有设置参数
     *
     * @return
     */
    @ApiOperation(value = "查询所有设置参数")
    @GetMapping(value = "/setting/custom/upperlimit")
    @ResponseBody
    public BeanRet settingCustomUpperlimit() {
        try {
            Map<String, Object> map = Maps.newHashMap();
            map.put("k", Setting.Key.Custom_Upper_Limit.name());
            Setting setting = settingSV.load(map);
            return BeanRet.create(true, "", setting.getV());
        } catch (Exception e) {
            return BeanRet.create(e.getMessage());
        }
    }
}
