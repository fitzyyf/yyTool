/*
 * Copyright (c) 2018, Fitzyy. All Rights Reserved.
 */

package me.fitzyy.tool.security.shiro.freemarker.auth;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

/**
 * <p> . </p>
 *
 * @author poplar.yfyang
 * @version 1.0 2012-10-27 10:33 AM
 * @since JDK 1.5
 */
public class GuestTagBase extends BaseSecureTag {


    @Override
    public void render(Environment env, Map params, TemplateDirectiveBody body) throws IOException, TemplateException {
        if (getSubject() == null || getSubject().getPrincipal() == null) {
            if (_logger.isDebugEnabled()) {
                _logger.debug("Subject does not exist or does not have a known identity (aka 'principal').  " +
                        "Tag body will be evaluated.");
            }

            renderBody(env, body);
        } else {
            if (_logger.isDebugEnabled()) {
                _logger.debug("Subject exists or has a known identity (aka 'principal').  " +
                        "Tag body will not be evaluated.");
            }
        }
    }
}
