package com.leoyou.appleo.ui.http;

import com.leoyou.appleo.base.BasePresenter;
import com.leoyou.appleo.base.BaseView;
import com.leoyou.appleo.bean.QueryBean;
import com.leoyou.appleo.ui.query.QueryController;

import java.util.List;

/**
 * Created by BoBoZhu on 2017/8/11.
 */

public class HttpController {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {
    }
}
