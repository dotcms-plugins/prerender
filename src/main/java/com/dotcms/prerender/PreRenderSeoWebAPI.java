package com.dotcms.prerender;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PreRenderSeoWebAPI {

    boolean prerenderIfEligible(HttpServletRequest request, HttpServletResponse response);

}
