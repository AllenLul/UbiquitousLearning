package just.learn.controller;

import just.learn.cache.CommonCacheUtil;
import just.learn.common.constants.Constants;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.UserElement;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ethanp
 * @version V1.0
 * @Package cn.jihangyu.glowworm.common.base
 * @Description: TODO
 * @date 2018/2/7 12:15
 */
@Slf4j
public class BaseController {
    @Autowired
    private CommonCacheUtil cacheUtil;
    protected UserElement getCurrentUser(){
        //前端把token放到header中
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token=request.getHeader(Constants.REQUEST_TOKEN_KEY);
        if(!StringUtils.isBlank(token)){
            try {
                UserElement ue=cacheUtil.getUserByToken(token);
                if (ue != null) {
                    return ue;
                }else {
                    throw new CustomException(ResultEnum.NO_LOGIN);
                }

            }catch (Exception e){
                log.error("fail to get user by token",e);
                throw  e;
            }
        }else {
            throw new CustomException(ResultEnum.NO_LOGIN);
        }
    }
}
