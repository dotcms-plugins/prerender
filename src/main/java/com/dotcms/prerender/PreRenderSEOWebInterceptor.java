package com.dotcms.prerender;

import com.dotcms.filters.interceptor.Result;
import com.dotcms.filters.interceptor.WebInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PreRenderSEOWebInterceptor implements WebInterceptor {

    private final PreRenderSeoWebAPI prerenderSeoWebAPI = new PreRenderSeoWebAPIImpl();

    @Override
    public String[] getFilters() {
        return new String[] {"/*"};
    }

    @Override
    public Result intercept(final HttpServletRequest httpServletRequest,
                            final HttpServletResponse httpServletResponse) throws IOException {

        final boolean isPrerendered = this.prerenderIfEligible(
                httpServletRequest, httpServletResponse);
        if (!isPrerendered) {

            return Result.NEXT;
        }

        return Result.SKIP_NO_CHAIN;
    }

    private boolean prerenderIfEligible(final HttpServletRequest request, final HttpServletResponse response) {
        return this.prerenderSeoWebAPI.prerenderIfEligible(request, response);
    }
}
